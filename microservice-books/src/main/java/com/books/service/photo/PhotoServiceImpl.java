package com.books.service.photo;



import com.libraries.exception.FileStorageException;
import com.libraries.exception.MyFileNotFoundException;
import com.libraries.model.Photo;
import com.books.repository.photo.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Gestion du téléchargement des images et du caroussel d'image de la page d'accueil
 *
 */
@Service
public class PhotoServiceImpl implements IPhotoService {

    @Value("${data.interval}")
    private Long dataInterval;

    @Value("${data.photo.utilisation}")
    private String utilisation;

    @Autowired
    private IPhotoRepository photoRepository;


    /**
     * Récupère les images déstinés à l'affichage du caroussel
     * @return la liste des images pour le caroussel
     */
    public List<Photo> findAll(){return photoRepository.findAllByUtilisationIs("carousel");}

    /**
     * Gère la sauvegarde du fichier en base de données. On vérifie si le fichier est existant et dans le cas contraire
     * le fichier est sauvegardé dans la base de données
     * @param file le fichier à sauvegarder
     *
     * @return On retourne le fichier si présent en base de données
     * sinon on retourne le nouveau fichier : (entity) Photo
     */
    public Photo storeFile(MultipartFile file)  {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Le chemin d'accès au fichier "+ fileName + " est invalide.");
            }
            String contentType = file.getContentType();
            byte[] data = file.getBytes();

            Photo photo = photoRepository.findByData( data );

            if(photo != null )
                return photo;
            else
                return this.save( fileName, contentType,  data );

        } catch (IOException ex) {

            throw new FileStorageException("Impossible de stocker ou de trouver  le fichier " + fileName + ". Veuillez réessayer!", ex);
        }
    }

    /**
     * Sauvegarde du fichier téléchargé
     * @param fileName Le nom du fichier téléchargé
     * @param contentType Le type du fichier téléchargé
     * @param data Le contenu du fichier
     * @return Le nouveau fichier sauvegardé : (entity) Photo
     */
    public Photo save(String fileName, String contentType, byte[] data) {
            Photo photo = new Photo(fileName, contentType, data, this.utilisation);
            return photoRepository.save( photo );
    }

    /**
     * On récupère le fichier en base de données
     * @param fileId Identifiant du fichier à récupérer
     * @return Le fichier : (entity) Photo
     */
    public Photo getFile(String fileId) {
        return photoRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("Fichier non trouvé avec l'id " + fileId));
    }

    /**
     * Getter
     * @return Retourne le timer du caroussel. Paramètre par défaut  application.properties : data.interval
     */
    public Long getDataInterval() {
        return dataInterval;
    }
}

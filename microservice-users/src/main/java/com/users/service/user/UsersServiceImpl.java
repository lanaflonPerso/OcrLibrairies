package com.users.service.user;

import com.users.config.ApplicationPropertiesConfig;
import com.users.controller.dto.user.UserPasswordUpdateDto;
import com.users.model.user.Role;
import com.users.model.user.Users;
import com.users.repository.user.IUsersRepository;
import com.users.service.user.role.IRoleService;
import com.users.technical.authentificationfacade.IAuthenticationFacade;
import com.users.technical.rolechecker.IRoleChecker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Gestion des utilisateurs
 */
@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private IRoleChecker roleChecker;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public Users findUser(Long idUser){
        return usersRepository.getOne( idUser );
    }

    /**
     * (Réservé à l'administreur)
     * On recherche la liste de tous les utilisateurs
     * @return La liste des utilisateurs
     */
    public List<Users> findAll(){
        return usersRepository.findAll();
    }


    public void save( Users user){
        if(user.getId() == null){
            user.setActive( appPropertiesConfig.isActive() );
            user.setPassword(passwordEncoder.encode(user.getPassword() ) );
            user.setRoleList( roleService.findListRole()  );
        }

        usersRepository.save( user );
    }
    /**
     * Réservé à l'administrateur :
     * Active ou Désactive un utilisateur
     * @param idUser Id de l'utilisateur à activer ou désactiver
     */
    public void updateActive(Long idUser){
        Users user = usersRepository.getOne( idUser );
        if( user.isActive())
            user.setActive( false );
        else
            user.setActive( true );

        if( !this.isCurrentUser( idUser ) )
            usersRepository.save( user );
    }

    /**
     * Réservé à l'administrateur :
     * Modification du role de l'utilisateur
     * @param idUser Id de l'utilisateur
     * @param newRole Nouveau role à affecter
     */
    public void updateRole(Long idUser,String newRole){

        Users user = usersRepository.getOne( idUser );
        Role role = roleService.findRole( "ROLE_"+ newRole);
        user.getRoleList().clear();
        user.getRoleList().add( role );
        usersRepository.save( user );
    }

    /**
     * Modification du mot de passe utilisateur
     * @param userPasswordUpdateDto Mot de passe utilisateur :(entity)User
     */
    public void updatePassword( UserPasswordUpdateDto userPasswordUpdateDto) {

        Users currentUser = this.findCurrentUserDetail();

        currentUser.setPassword(passwordEncoder.encode( userPasswordUpdateDto.getNewPassword() ) );

        usersRepository.save( currentUser );
    }

    /**
     * On recherche quel utilisateur est connecté
     * @return L'indentifiant d'authentification de l'utilisateur
     */
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }
    /**
     * On recherche les informations de l'utilisateur connecté
     * @return L'utilisateur connecté (entity)User
     */
    public Users findCurrentUserDetail(){
        return this.findUser( currentUserNameSimple() );
    }


    /**
     * On récupère le prénom de l'utilisateur connecté
     * @return Prénom de l'utilisateur
     */
    public String currentUserFirstName(){
        return this.findCurrentUserDetail().getFirstName();
    }


    /**
     * On récupère le nom et le prénom de l'utlisateur connecté
     * @return Le prénom et nom de l'utilisateur
     */
    public String currentUserFullName(){
        Users user = this.findCurrentUserDetail();
        return user.getFirstName()+ ' ' + user.getLastName();
    }

    /**
     * On récupère le téléphone de l'utilisateur connecté
     * @return Le téléphone de l'utilisateur
     */
    public String currentUserPhone(){

        return  this.findCurrentUserDetail().getPhone();
    }

    /**
     * Récupère l'email de l'utilisateur connecté
     * @return L'email de l'utilisateur
     */
    public String currentUserEmail(){

        return this.findCurrentUserDetail().getEmail();
    }

    /**
     * On récupère le profil de l'utilisateur connecté
     * @return Le profil de l'utilisateur
     */
    public String currentUserProfil(){
        return this.findCurrentUserDetail().getRoleList().get(0).getWording();
    }

    /**
     * On récupère l'identifiant de Id de l'utilisateur connecté
     * @return Id de l'utilisateur
     */
    public Long currentUserId(){
        return this.findCurrentUserDetail().getId();
    }

    /**
     * On vérifié si l'utilisateur connecté est administrateur
     * @return true si l'utilisateur est administrateur sinon false
     */
    public boolean isAdmin(){
        return roleChecker.hasRole("ADMIN");
    }

    /**
     * On vérifie si l'utilisateur connecté est membre de l'association
     * @return true si l'utilisateur est membre de l'association sinon false
     */
    public boolean isActuator(){
        return roleChecker.hasRole("ACTUATOR");
    }

    /**
     * On vérifié si l'utilisateur connecté est simple utilisateur
     * @return true l'utilisateur est simple utilisateur sinon false
     */
    public boolean isUser(){
        return roleChecker.hasRole("USER");
    }

    /**
     * Recherche d'un utilisateur
     * @param email Email de l'utilisateur
     * @return L'utilisateur (entity)User
     */
    public Users findUser(String email) {
        return usersRepository.findByEmailAndActiveTrue(email);
    }

    /**
     * On recherche un utilisateur et on vérifie si c'est l'utilisateur connecté
     * @param email Email de l'utilisateur à chercher
     * @return true si l'utilisateur recherché est l'utilisateur connecté sinon false
     */
    public boolean isUserExisting(String email){
        Users user = usersRepository.findByEmailAndActiveTrue(email);
        Users currentUser = this.findCurrentUserDetail();

        if( user.equals( currentUser ))
            return true;
        else
            return false;
    }

    /**
     * On vérifie si l'utilisateur connecté est identique à l'utilisateur cherché
     * @param userCompare utilisateur cherché
     * @return true si l'utilisateur connecté est l'utilisateur cherché sinon false
     */
    public boolean isUserConnected (Users userCompare){
        Users currentUser = this.findCurrentUserDetail();
        if(currentUser.equals( userCompare)  )
            return true;
        else
            return false;
    }

    public boolean isCurrentUser(Long idUser){
        Users user = usersRepository.getOne( idUser );
        Users currentUser = this.findCurrentUserDetail();

        if( currentUser.equals(user) )
            return true;
        else
            return false;
    }

    /**
     * On vérifie si le mot de passe saisi correspond au mot de passe de l'utilisateur connecté
     * @param pw Mot de passe à vérifier
     * @return true si le mote de passe correspond sion false
     */
    public boolean isPasswordMatch(String pw){
        return  passwordEncoder.matches(pw, this.findCurrentUserDetail().getPassword() );
    }

    /**
     * On cherche un utilisateur
     * @param email Email de l'utilisateur à chercher
     * @return L'utilisateur si l'utilisateur est trouvé.
     * @throws UsernameNotFoundException Exception de la présence de l'utilisateur recherché
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("email : " + email);
        Users user = usersRepository.findByEmailAndActiveTrue(email);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur ou mot de passe incorrect.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities( user.getRoleList() ) ) ;

    }

    /**
     *
     * @param roles role de l'utilisateur
     * @return
     */
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(List< Role > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
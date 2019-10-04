package com.libraries.repository.user;



import com.libraries.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JPA Initialisation de l'entity user
 */
@Repository
public interface IUsersRepository extends JpaRepository<Users,Long > {
    Users findByEmailAndActiveTrue(String email);
    Users findUserById(Long id);


}

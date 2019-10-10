package com.users.repository.user;




import com.users.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JPA Initialisation de l'entity user
 */
@Repository
public interface IUsersRepository extends JpaRepository<Users,Long > {

Users findByEmailAndActiveTrue(String email);

}

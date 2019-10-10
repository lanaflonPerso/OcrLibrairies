

insert into "role" (id,name,wording)
VALUES
(1,'ROLE_ADMIN','Administrateur'),
(2,'ROLE_ACTUATOR','Membre'),
(3,'ROLE_USER','Utilisateur');


/*  Insert USERS */
INSERT INTO "users"
(id,email,active,last_name,password,first_name,phone)
VALUES
(1,'admin@gmail.com',
true,'ADMIN','$2a$10$mVLweGs6HLxItvuYt5W21e9sr7sgkqeuk6q.3pke4HEHJZry4fWSO',
'Romain-David' ,'0768000001'),
(2,'actuator@gmail.com',
true,'ACTUATOR','$2a$10$mVLweGs6HLxItvuYt5W21e9sr7sgkqeuk6q.3pke4HEHJZry4fWSO',
'Romain-David' ,'0768000002'),
(3,'user@gmail.com',
true,'USER','$2a$10$mVLweGs6HLxItvuYt5W21e9sr7sgkqeuk6q.3pke4HEHJZry4fWSO',
'Romain-David' ,'0768000003');

/*  Insert role_user */
insert into "users_role" (id_user,id_role)
VALUES
(1,1),
(2,2),
(3,3);



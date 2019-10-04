package com.libraries.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Hibernate :
 * Permet la création en base de données de la table User
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public @Data class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private String nom;

    @NonNull private String prenom;

    @NonNull private String email;

    @NonNull private String password;

    @NonNull private String telephone;

    @NonNull private boolean active;

    // Jointures
    @ManyToMany
    @JoinTable(
            name="users_role",
            joinColumns=@JoinColumn(name="id_user", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_role", referencedColumnName="id")
    )
    @NonNull private  List<Role>  roleList;

















}

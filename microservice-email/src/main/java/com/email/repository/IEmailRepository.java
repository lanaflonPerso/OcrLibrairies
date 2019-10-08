package com.email.repository;

import com.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<Email,Long> {
}

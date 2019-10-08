package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);
}

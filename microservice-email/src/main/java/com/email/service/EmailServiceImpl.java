package com.email.service;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private IEmailRepository emailRepository;

    public List<Email> findAll(){
        return emailRepository.findAll();
    }

    public void save(Email email){
        emailRepository.save(email);
    }
}

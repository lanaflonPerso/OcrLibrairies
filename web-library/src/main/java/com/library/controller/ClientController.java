package com.library.controller;

import com.library.beans.mbooks.book.LanguageBean;
import com.library.proxies.IMicroserviceBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private IMicroserviceBooksProxy booksProxy;

    @RequestMapping("/")
    public String accueil(Model model){

        List<LanguageBean> languageList =  booksProxy.languageList();

        model.addAttribute( languageList );

        return "index";
    }
}

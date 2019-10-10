package com.library.proxies;

import com.library.beans.mbooks.book.LanguageBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "gateway")
@RibbonClient("microservice-books")
public interface IMicroserviceBooksProxy {

    @GetMapping(value = "/microservice-books/Language/all")
    List<LanguageBean> languageList();
}

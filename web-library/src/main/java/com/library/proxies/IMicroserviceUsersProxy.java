package com.library.proxies;

import com.library.beans.musers.user.UsersBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient( "gateway")
@RibbonClient("microservice-users")
@RequestMapping("/microservice-users")
public interface IMicroserviceUsersProxy {

    @GetMapping("/User/connection/{id}")
    UsersBean user(@PathVariable("id") String email);
}

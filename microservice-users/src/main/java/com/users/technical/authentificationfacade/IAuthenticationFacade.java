package com.users.technical.authentificationfacade;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade  {

    Authentication getAuthentication();
}

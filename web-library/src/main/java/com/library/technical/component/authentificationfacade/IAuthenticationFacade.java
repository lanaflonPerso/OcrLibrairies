package com.library.technical.component.authentificationfacade;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade  {

    Authentication getAuthentication();
}
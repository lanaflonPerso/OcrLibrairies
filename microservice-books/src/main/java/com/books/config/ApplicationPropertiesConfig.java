package com.books.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice.config")
@Getter
@Setter
public class ApplicationPropertiesConfig {

    private int renewalNumber;
    private int renewalDay;
}

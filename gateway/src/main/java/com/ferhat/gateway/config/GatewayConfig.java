package com.ferhat.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ferhat on 6/4/2023
 * @project employee-managment-microservices
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}

package com.ferhat.gateway.config;

import com.ferhat.gateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ferhat on 6/4/2023
 * @project employee-managment-microservices
 */

@Configuration
public class GatewayConfig {
    private JwtAuthenticationFilter filter;

    public GatewayConfig(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employee-service",
                        r -> r.path("/employee/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://employee-service"))

                .route("department-service",
                        r -> r.path("/department/**")
                                .filters(f -> f.filter(filter))
                                .uri("lb://department-service"))

                .route("auth-service",
                        r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth-service"))
                .build();
    }
}

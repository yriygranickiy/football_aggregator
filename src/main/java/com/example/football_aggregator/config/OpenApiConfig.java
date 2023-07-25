package com.example.football_aggregator.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Yurii",
                        email = "hranitskyi@gmail.com"
                ),
                description = "OpenApi documentation for aggregator application",
                title = "OpenApi specification - Yurii",
                version = "1.0"
        )
)
public class OpenApiConfig {
}

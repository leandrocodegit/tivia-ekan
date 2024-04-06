package br.com.ekan.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI iniApi() {

        Info information = new Info()
                .title("Api beneficiarios")
                .version("1.0")
                .description("Esta é uma api de teste") ;
        return new OpenAPI().info(information);
    }

    @Bean
    public OpenApiCustomizer openApiCustomiser() {
        return openApi -> openApi.getComponents().addSecuritySchemes("bearerScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
    }
}


package com.swagger.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	@Bean
	public Docket api()
	{
		List<ApiKey> list = new ArrayList();
		list.add(apiKey());
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(metadata()).securitySchemes(list);
	}

	@Bean
    public SecurityConfiguration securityInfo() {
       return new SecurityConfiguration(null, null, null, null, "", ApiKeyVehicle.QUERY_PARAM, "Authorization", "");
    }

    private ApiKey apiKey() {
        //return new ApiKey("Authorization", "Authorization", "header");
    	return new ApiKey("api_token", "api_token", "query");
    }

	private ApiInfo metadata()
	{
		return new ApiInfoBuilder()
				.title("API documentation of our App")
				.description("Use this documentation as a reference how to interact with app's API")
				.version("1")
				.contact(new Contact("Dev-Team", "https://dev-website", "dev@mailbox"))
				.build();
	}
}
package co.springcoders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2ClientCredentialsGrantApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ClientCredentialsGrantApplication.class, args);
	}

}

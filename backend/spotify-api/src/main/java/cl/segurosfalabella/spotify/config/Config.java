package cl.segurosfalabella.spotify.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Config{

    @Bean
    @ConfigurationProperties("spotify.oauth2.client")
    public ClientCredentialsResourceDetails oAuthDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Qualifier("spotifyRestTemplate")
    @Bean
    protected RestTemplate spotifyRestTemplate() {
        return new OAuth2RestTemplate(oAuthDetails());
    }

}
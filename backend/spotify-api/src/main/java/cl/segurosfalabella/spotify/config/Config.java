package cl.segurosfalabella.spotify.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import cl.segurosfalabella.spotify.core.SpotifyRequestHandler;
import cl.segurosfalabella.spotify.features.GetAlbumsCompositeRequestHandler;
import cl.segurosfalabella.spotify.features.GetAlbumsMongoRequestHandler;
import cl.segurosfalabella.spotify.features.GetAlbumsSpotifyRequestHandler;
import cl.segurosfalabella.spotify.infrastructure.AlbumHttpRepository;
import cl.segurosfalabella.spotify.infrastructure.AlbumMongoRepository;
import cl.segurosfalabella.spotify.infrastructure.SpotifyHttpAlbumRepository;


@Configuration
public class Config{

    @Bean
    public AlbumHttpRepository httpAlbumRepository(@Value("${baseUrl}") String baseurl){
       
        return new SpotifyHttpAlbumRepository(baseurl,spotifyRestTemplate());
    }

    @Qualifier(value="compositeRequestHandler")
    @Bean
    public SpotifyRequestHandler compositeRequestHandler(@Autowired AlbumMongoRepository respository,@Qualifier(value="mongodbRequestHandler") @Autowired SpotifyRequestHandler mongodb,@Qualifier(value="spotifyRequestHandler") @Autowired SpotifyRequestHandler http){
        return new GetAlbumsCompositeRequestHandler(respository,mongodb,http);

    }
    @Qualifier(value="mongodbRequestHandler")
    @Bean
    public SpotifyRequestHandler mongodbRequestHandler(@Autowired AlbumMongoRepository respository){
        return new GetAlbumsMongoRequestHandler(respository);

    }
    @Qualifier(value="spotifyRequestHandler")
    @Bean
    public SpotifyRequestHandler spotifyRequestHandler(@Autowired AlbumHttpRepository respository){
        return new GetAlbumsSpotifyRequestHandler(respository);

    }

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
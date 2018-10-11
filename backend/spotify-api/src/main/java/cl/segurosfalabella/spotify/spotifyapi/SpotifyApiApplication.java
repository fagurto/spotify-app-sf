package cl.segurosfalabella.spotify.spotifyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "cl.segurosfalabella.spotify.infrastructure")
@ComponentScan(basePackages = "cl.segurosfalabella.spotify")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpotifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApiApplication.class, args);
	}
}

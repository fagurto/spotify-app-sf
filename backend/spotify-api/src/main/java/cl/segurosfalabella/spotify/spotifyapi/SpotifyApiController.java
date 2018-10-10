package cl.segurosfalabella.spotify.spotifyapi;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpotifyApiController {

    @Autowired
    private RestTemplate spotifyRestTemplate;

    @GetMapping(value="/api/albums")
    public JsonNode  searchQ() throws IOException{

        String content=spotifyRestTemplate.getForEntity("https://api.spotify.com/v1/search?q=Muse&type=album",String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
         JsonNode response = mapper.readTree(content); 
         JsonNode items= response.get("albums").get("items");
        return items;
    }

}
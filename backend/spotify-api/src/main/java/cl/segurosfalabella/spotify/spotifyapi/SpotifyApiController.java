package cl.segurosfalabella.spotify.spotifyapi;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.segurosfalabella.spotify.model.Album;

@RestController
public class SpotifyApiController {

    @Autowired
    private RestTemplate spotifyRestTemplate;

    @GetMapping(value="/api/albums")
    public Object  searchQ() throws IOException{

        String content=spotifyRestTemplate.getForEntity("https://api.spotify.com/v1/search?q=Muse&type=album",String.class).getBody();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       
        JsonNode response = mapper.readTree(content); 
        

      ArrayList<Album> albums= mapper.readValue(response.path("albums").path("items").toString(), new TypeReference<ArrayList<Album>>(){});
       // ArrayList<Album> albums = ,new TypeReference<ArrayList<Album>>(){}.getClass());
        return albums ;
    }

}
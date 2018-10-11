package cl.segurosfalabella.spotify.infrastructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyResponse;
import cl.segurosfalabella.spotify.model.Album;
import cl.segurosfalabella.spotify.infrastructure.AlbumHttpRepository;


public class SpotifyHttpAlbumRepository implements AlbumHttpRepository  {

    private RestTemplate spotifyRestTemplate;

    private String baseUrl;

    public SpotifyHttpAlbumRepository(String baseUrl, RestTemplate spotifyRestTemplate){
        
        this.spotifyRestTemplate=spotifyRestTemplate;
        this.baseUrl=baseUrl;
    }

    
    public SpotifyResponse getByRequest(SpotifyRequest request) {
        SpotifyResponse spotifyResponse= new SpotifyResponse();

      try {
          
        String url = baseUrl+request.getQueryString();

        String content=spotifyRestTemplate.getForEntity(url,String.class).getBody();

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       
        JsonNode response;
        
            response = mapper.readTree(content);
        
        
        List<Album> albums= mapper.readValue(response.path("albums").path("items").toString(), new TypeReference<ArrayList<Album>>(){});

        spotifyResponse.setAlbums(albums);
        spotifyResponse.setRequest(request);
        spotifyResponse.setLimit(response.path("albums").path("limit").intValue());
        spotifyResponse.setOffset(response.path("albums").path("offset").intValue());
        spotifyResponse.setTotal(response.path("albums").path("total").intValue());

        return spotifyResponse;
    } catch (IOException e) {
        
        spotifyResponse.setAlbums(new ArrayList<Album>());

        return spotifyResponse;
      }
    }
}
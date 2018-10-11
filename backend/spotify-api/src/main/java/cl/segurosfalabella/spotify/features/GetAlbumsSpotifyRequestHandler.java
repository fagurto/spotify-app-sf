package cl.segurosfalabella.spotify.features;

import org.springframework.web.client.RestTemplate;

import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyRequestHandler;
import cl.segurosfalabella.spotify.core.SpotifyResponse;
import cl.segurosfalabella.spotify.infrastructure.AlbumHttpRepository;

public class GetAlbumsSpotifyRequestHandler implements SpotifyRequestHandler {

    
    private AlbumHttpRepository repository;
    
    public GetAlbumsSpotifyRequestHandler(AlbumHttpRepository repository){
      this.repository=repository;
      
    }

    @Override
    public SpotifyResponse handle(SpotifyRequest request) {

	    	return repository.getByRequest(request);
	  }
    
}
package cl.segurosfalabella.spotify.features;

import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyRequestHandler;
import cl.segurosfalabella.spotify.core.SpotifyResponse;
import cl.segurosfalabella.spotify.infrastructure.AlbumMongoRepository;


public class GetAlbumsMongoRequestHandler implements SpotifyRequestHandler {

    private AlbumMongoRepository repository;
    public GetAlbumsMongoRequestHandler(AlbumMongoRepository repository){
        this.repository=repository;
    }


    
    @Override
    public SpotifyResponse handle(SpotifyRequest request) {

       String searchKey = request.getSearchKey();

       if(searchKey.equalsIgnoreCase("[]")){
           return null;
       }
        
       return repository.getBySearchKey(searchKey);

	}
    
}
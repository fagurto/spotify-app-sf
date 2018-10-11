package cl.segurosfalabella.spotify.features;

import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyRequestHandler;
import cl.segurosfalabella.spotify.core.SpotifyResponse;
import cl.segurosfalabella.spotify.infrastructure.AlbumMongoRepository;

public class GetAlbumsCompositeRequestHandler implements SpotifyRequestHandler {

    AlbumMongoRepository repository;
    SpotifyRequestHandler mongodb;
    SpotifyRequestHandler http;

    public GetAlbumsCompositeRequestHandler(AlbumMongoRepository repository,SpotifyRequestHandler mongodb , SpotifyRequestHandler http) {
        this.repository=repository;
        this.mongodb=mongodb;
        this.http=http;
    }

    @Override
    public SpotifyResponse handle(SpotifyRequest request) {

        request.setLimit(20);

        SpotifyResponse response=null;

        response=mongodb.handle(request);

        if(response!=null)
          return response;

          response=http.handle(request);
          response.setSearchKey(request.getSearchKey());
          repository.save(response);

		return response;
	}
}
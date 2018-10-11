package cl.segurosfalabella.spotify.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cl.segurosfalabella.spotify.core.SpotifyResponse;

@Repository
public interface AlbumMongoRepository extends MongoRepository<SpotifyResponse, String> {

    public SpotifyResponse getBySearchKey(String searchKey);
}
package cl.segurosfalabella.spotify.infrastructure;

import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyResponse;

public interface AlbumHttpRepository  {

    public SpotifyResponse getByRequest(SpotifyRequest request);
}
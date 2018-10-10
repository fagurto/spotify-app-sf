package cl.segurosfalabella.spotify.core;

public interface SpotifyRequestHandler<T,I> {

   public T handle(I action);
}
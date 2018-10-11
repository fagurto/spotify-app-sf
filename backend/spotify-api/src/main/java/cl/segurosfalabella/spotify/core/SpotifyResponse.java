package cl.segurosfalabella.spotify.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cl.segurosfalabella.spotify.model.Album;

@Document
public class SpotifyResponse {

     @Id
     private String id;
     private String searchKey;
     private SpotifyRequest request;
     private List<Album> albums;
     private int limit;
     private int offset;
     private int total;


    
    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @return the searchKey
     */
    @JsonIgnore
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * @param searchKey the searchKey to set
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * @return the request
     */
    public SpotifyRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(SpotifyRequest request) {
        this.request = request;
    }

    /**
     * @return the albums
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * @param albums the albums to set
     */
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }


}
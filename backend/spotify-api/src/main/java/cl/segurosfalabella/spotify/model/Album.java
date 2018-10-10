package cl.segurosfalabella.spotify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Album {
    
    private String name;

    private String releaseDate;

    private String type;

    private int totalTracks;

    private List<Image> images;
    
    public String getName() {
        return name;
    }

    
    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonGetter("total_tracks")
    public int getTotalTracks() {
        return totalTracks;
    }

   
    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }

    public String getType() {
        return type;
    }

  
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }
   
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setName(String name) {
        this.name = name;
    }


}
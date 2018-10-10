package cl.segurosfalabella.spotify.model;

public class Image {
    
    private int width;
    private int height;
    private String url;

    public String getUrl() {
        return url;
    }

    
    
    public int getHeight() {
        return height;
    }

   
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

   
    public void setWidth(int width) {
        this.width = width;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
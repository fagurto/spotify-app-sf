package cl.segurosfalabella.spotify.core;

public class SpotifyRequest {

    private String album;
    private String artist;
    private int limit;
    private int offset;

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
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
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }


    public String getQueryString(){
        StringBuilder builder=new StringBuilder();
        builder.append("?q=");
        if(this.getAlbum() != null && !this.getAlbum().isEmpty()){

            builder.append("album:")
                   .append(this.getAlbum());
        }

        if(this.getArtist() != null && !this.getArtist().isEmpty()){

            builder.append("artist:")
                   .append(this.getArtist());
        }

        if(this.getLimit()!=0){
            builder.append("&limit=")
                   .append(this.getLimit());
        }

        if(this.getOffset()!=0){
            builder.append("&offset=")
                   .append(this.getOffset());
        }

        builder.append("&type=album");

        return builder.toString();
    }
    public String getSearchKey(){

        StringBuilder builder=new StringBuilder();
        builder.append("[");
        if(this.getAlbum() != null && !this.getAlbum().isEmpty()){

            builder.append("album:")
                   .append(this.getAlbum());
        }

        if(this.getArtist() != null && !this.getArtist().isEmpty()){

            builder.append("artist:")
                   .append(this.getArtist());
        }

        if(this.getLimit()!=0){
            builder.append("limit:")
                   .append(this.getLimit());
        }

        if(this.getOffset()!=0){
            builder.append("offset:")
                   .append(this.getOffset());
        }

        builder.append("]");

        return builder.toString();
    }
}
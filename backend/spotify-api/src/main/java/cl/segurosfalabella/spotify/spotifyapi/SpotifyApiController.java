package cl.segurosfalabella.spotify.spotifyapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.segurosfalabella.spotify.core.SpotifyRequest;
import cl.segurosfalabella.spotify.core.SpotifyRequestHandler;
import cl.segurosfalabella.spotify.core.SpotifyResponse;


@RestController
public class SpotifyApiController {

   

    @Qualifier(value="compositeRequestHandler")
    @Autowired
    private SpotifyRequestHandler handler;
    
    @CrossOrigin(origins = "*")
    @GetMapping(value="/api/albums" , produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpotifyResponse>  searchQ(@RequestParam(value="album",required=false) String album,@RequestParam(value="artist",required=false) String artist,@RequestParam(value="offset",required=false) Integer offset){

        SpotifyRequest request=  new SpotifyRequest();
                       request.setAlbum(album);
                       request.setArtist(artist);
                       if(offset!=null)
                       request.setOffset(offset);

            if(request.getSearchKey().equalsIgnoreCase("[]"))
                return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).build();

        return ResponseEntity.ok(handler.handle(request)) ;
    }

}
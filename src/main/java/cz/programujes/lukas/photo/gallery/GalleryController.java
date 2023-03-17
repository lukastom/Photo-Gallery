package cz.programujes.lukas.photo.gallery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GalleryController {

    //database of photos
    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "photo1.jpg"));
    }};

    //GET methods
    @GetMapping("/")
    public String hello () {
        return "Hello";
    }

    @GetMapping("/gallery")
    public Collection<Photo> getPhotos () {
        return db.values();
    }

    @GetMapping("/gallery/{id}")
    public Photo getPhoto (@PathVariable String id) {
        Photo photo = db.get(id);
        // If photo not found, throw 404
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    //DELETE method
    @DeleteMapping ("/gallery/{id}")
    public void deletePhoto (@PathVariable String id) {
        Photo photo = db.remove(id);
        // If photo not found, throw 404
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}

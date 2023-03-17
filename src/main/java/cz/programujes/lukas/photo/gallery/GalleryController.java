package cz.programujes.lukas.photo.gallery;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GalleryController {

    //mock database of photos for prototyping
    private Map<String, Photo> db = new HashMap<>() {{
        //the key is just for retrieving, the actual data are in value
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

    //POST method + validation of JSON input (invalid throws 400 Bad Request)
    @PostMapping("/gallery")
    //For just text input (prototyping): uploadPhoto (@RequestBody @Valid Photo photo)
    public Photo uploadPhoto (@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }


}

package cz.programujes.lukas.photo.gallery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GalleryController {

    /*database of photos
      • List.of – immutable list (for mutable List use ArrayList)
     */
    private List<Photo> db = List.of(new Photo("1", "photo1.jpg"));

    @GetMapping("/")
    public String hello () {
        return "Hello";
    }

    @GetMapping("/gallery")
    public List<Photo> getPhotos () {
        return db;
    }

}

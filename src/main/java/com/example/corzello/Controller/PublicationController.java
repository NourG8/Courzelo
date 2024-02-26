package com.example.corzello.Controller;

import com.example.corzello.Entity.Publication;
import com.example.corzello.Service.PublicationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/publications")
@RequiredArgsConstructor
public class PublicationController {

    @Autowired
    private PublicationServiceImpl publicationService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("getAll")
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublication();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{idPublication}")
    public Publication getPublicationById(@PathVariable Long idPublication) {
        return publicationService.getPublicationById(idPublication);
    }

    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/add")
    public Publication ajouterPublication(@RequestBody Publication publication) {
        return publicationService.ajouterPublication(publication);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @DeleteMapping("/delete/{idPublication}")
    public void deletePublication(@PathVariable Long idPublication) {
        publicationService.deletePublication(idPublication);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PutMapping("/update/{idPublication}")
    public Publication updatePublication(@RequestBody Publication publication) {
        return publicationService.updatePublication(publication);
    }


}

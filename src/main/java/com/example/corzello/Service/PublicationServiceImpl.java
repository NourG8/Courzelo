package com.example.corzello.Service;

import com.example.corzello.Entity.Publication;
import com.example.corzello.Entity.Publication;
import com.example.corzello.Repository.CommentaireRepository;
import com.example.corzello.Repository.PublicationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl  implements  PublicationService{


    private PublicationRepository publicationRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;


    public PublicationServiceImpl(PublicationRepository publicationRepository){
        this.publicationRepository=publicationRepository;
    }


    @Override
    public Publication ajouterPublication(Publication publication) {
        return publicationRepository.save(publication);
    }


    @Override
    @Transactional
    public Publication updatePublication(Publication publication) {
        // Retrieve the existing publication from the database
        Optional<Publication> existingPublicationOptional = publicationRepository.findById(publication.getIdPublication());
        if (existingPublicationOptional.isPresent()) {
            // Update the existing publication with the new values
            Publication existingPublication = existingPublicationOptional.get();
            existingPublication.setTitle(publication.getTitle());
            existingPublication.setDescription(publication.getDescription());
            existingPublication.setBody(publication.getBody());
            existingPublication.setTags(publication.getTags());
            // Save the updated publication
            return publicationRepository.save(existingPublication);
        } else {
            // Handle the case where the publication with the given ID doesn't exist
            throw new EntityNotFoundException("Publication not found with ID: " + publication.getIdPublication());
        }
    }

    @Override
    public Publication getPublicationById(long idPublication) {
        Publication publication = publicationRepository.findById(idPublication).orElse(null);

        return publication;
    }
    @Override
    public List<Publication> getAllPublication() {
        return (List<Publication>) publicationRepository.findAll()  ;


    }

    @Override
    public void deletePublication(long idPublication) {
        publicationRepository.deleteById(idPublication);

    }
}

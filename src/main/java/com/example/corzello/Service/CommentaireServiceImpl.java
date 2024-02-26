package com.example.corzello.Service;

import com.example.corzello.Entity.Commentaire;
import com.example.corzello.Service.CommentaireService;
import com.example.corzello.Repository.CommentaireRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    @Override
    public Commentaire createComment(Commentaire commentaire) {
        commentaire.setCreatedAt(new Date());
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> getCommentsByPublicationId(Long idPublication) {
        return commentaireRepository.findByPublicationIdPublication(idPublication);
    }

    @Override
    public Commentaire updateComment(Long idCommentaire, Commentaire updatedComment) {
        Optional<Commentaire> existingCommentOptional = commentaireRepository.findById(idCommentaire);
        if (existingCommentOptional.isPresent()) {
            Commentaire existingComment = existingCommentOptional.get();
            existingComment.setContent(updatedComment.getContent());
            return commentaireRepository.save(existingComment);
        } else {
            throw new EntityNotFoundException("Comment not found with ID: " + idCommentaire);
        }
    }

    @Override
    public void deleteComment(Long idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);
    }
}

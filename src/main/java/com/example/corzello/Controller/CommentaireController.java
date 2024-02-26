package com.example.corzello.Controller;

import com.example.corzello.Entity.Commentaire;

import com.example.corzello.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @PostMapping("/create")
    public ResponseEntity<Commentaire> createComment(@RequestBody Commentaire commentaire) {
        Commentaire createdComment = commentaireService.createComment(commentaire);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/publication/{idPublication}")
    public ResponseEntity<List<Commentaire>> getCommentsByPublicationId(@PathVariable Long idPublication) {
        List<Commentaire> comments = commentaireService.getCommentsByPublicationId(idPublication);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/update/{idCommentaire}")
    public ResponseEntity<Commentaire> updateComment(@PathVariable Long idCommentaire, @RequestBody Commentaire commentaire) {
        Commentaire updatedComment = commentaireService.updateComment(idCommentaire, commentaire);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCommentaire}")
    public ResponseEntity<?> deleteComment(@PathVariable Long idCommentaire) {
        commentaireService.deleteComment(idCommentaire);
        return ResponseEntity.noContent().build();
    }
}

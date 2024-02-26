package com.example.corzello.Service;

import com.example.corzello.Entity.Commentaire;

import java.util.List;

public interface CommentaireService {

    Commentaire createComment(Commentaire commentaire);

    List<Commentaire> getCommentsByPublicationId(Long idPublication);

    Commentaire updateComment(Long idCommentaire, Commentaire commentaire);

    void deleteComment(Long idCommentaire);
}

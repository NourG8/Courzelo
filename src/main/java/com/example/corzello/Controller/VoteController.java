package com.example.corzello.Controller;

import com.example.corzello.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {
    private final VoteService voteService;

    @PutMapping("/upvote/{publicationId}")
    public ResponseEntity<?> upvotePublication(@PathVariable Long publicationId) {
        if (voteService.upvotePublication(publicationId)) {
            return ResponseEntity.ok().body("{\"message\": \"Publication upvoted successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Publication not found.\"}");
        }
    }

    @PutMapping("/downvote/{publicationId}")
    public ResponseEntity<?> downvotePublication(@PathVariable Long publicationId) {
        if (voteService.downvotePublication(publicationId)) {
            return ResponseEntity.ok().body("{\"message\": \"Publication downvoted successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Publication not found.\"}");
        }
    }
    @GetMapping("/netscore/{publicationId}")
    public ResponseEntity<?> getNetScoreForPublication(@PathVariable Long publicationId) {
        int netScore = voteService.calculateNetScore(publicationId);
        if (netScore != Integer.MIN_VALUE) {
            return ResponseEntity.ok().body(netScore);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Publication not found.\"}");
        }

    }
    @DeleteMapping("/ivote/{publicationId}")
    public ResponseEntity<?> undoVote(@PathVariable Long publicationId, @RequestParam boolean isUpvote) {
        if (voteService.undoVote(publicationId, isUpvote)) {
            return ResponseEntity.ok().body("{\"message\": \"Vote undone successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Publication not found or vote not undone.\"}");
        }
    }
    }



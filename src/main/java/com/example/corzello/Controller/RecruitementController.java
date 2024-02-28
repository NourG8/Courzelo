package com.example.corzello.Controller;

import com.example.corzello.Entity.Recruitement_process_details;
import com.example.corzello.Service.RecruitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recruitment")
@CrossOrigin(origins = "http://localhost:4200") // Moved CrossOrigin annotation to the class level
public class RecruitementController {

    private final RecruitementService recruitementService;

    @Autowired
    public RecruitementController(RecruitementService recruitementService) {
        this.recruitementService = recruitementService;
    }

    @GetMapping("GetAll")
    public List<Recruitement_process_details> getAllRecruitementProcesses() {
        return recruitementService.getAllRecruitementProcesses();
    }

    @PostMapping("CreateRecruitementProcess/{etudiantId}")
    public Recruitement_process_details createRecruitementProcess(@PathVariable("etudiantId") Long etudiantId, @RequestBody Recruitement_process_details processDetails) {
        // Now you have the etudiantId available here
        System.out.println("Etudiant ID: " + etudiantId);
        System.out.println(processDetails.toString());
        // Assuming you have a method to create the recruitment process for the given etudiantId
        return recruitementService.createRecruitementProcess(etudiantId, processDetails);
    }

    @GetMapping("GetById/{idRecrutement_PDetails}")
    public ResponseEntity<Recruitement_process_details> getRecruitementProcessById(@PathVariable Long id) {
        Optional<Recruitement_process_details> processOptional = recruitementService.getRecruitementProcessById(id);
        return processOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("UpdateRecruitementProcess/{idRecrutement_PDetails}")
    public Recruitement_process_details updateRecruitementProcess(@RequestBody Recruitement_process_details updatedRecruitementProcess) {
        return recruitementService.updateRecruitementProcess(updatedRecruitementProcess);
    }

    @DeleteMapping("Delete/{idRecrutement_PDetails}")
    public ResponseEntity<Void> deleteRecruitementProcess(@PathVariable Long idRecrutement_PDetails) {
        recruitementService.deleteRecruitementProcess(idRecrutement_PDetails);
        return ResponseEntity.noContent().build();
    }
}

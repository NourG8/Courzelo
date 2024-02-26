package com.example.corzello.Service;

import com.example.corzello.Entity.Recruitement_process_details;
import com.example.corzello.Repository.RecruitementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitementServiceImpl implements RecruitementService {

    private final RecruitementRepo recruitementRepo;

    @Autowired
    public RecruitementServiceImpl(RecruitementRepo recruitementRepo) {
        this.recruitementRepo = recruitementRepo;
    }

    @Override
    public List<Recruitement_process_details> getAllRecruitementProcesses() {
        return recruitementRepo.findAll();
    }

    @Override
    public Optional<Recruitement_process_details> getRecruitementProcessById(Long id) {
        return recruitementRepo.findById(id);
    }

    @Override
    public Recruitement_process_details createRecruitementProcess(Recruitement_process_details recruitementProcess) {
        //recruitementProcess.setEtudiant(etudiant); // Associate the student with the recruitment process
        return recruitementRepo.save(recruitementProcess); // Save the recruitment process with the associated student
    }


    @Override
    public Recruitement_process_details updateRecruitementProcess(Recruitement_process_details updatedRecruitementProcess) {

            return recruitementRepo.save(updatedRecruitementProcess);

    }

    @Override
    public void deleteRecruitementProcess(Long id) {
        recruitementRepo.deleteById(id);
    }
}

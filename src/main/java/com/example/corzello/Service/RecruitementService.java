package com.example.corzello.Service;

import com.example.corzello.Entity.Recruitement_process_details;

import java.util.List;
import java.util.Optional;

public interface RecruitementService {
    List<Recruitement_process_details> getAllRecruitementProcesses();

    Optional<Recruitement_process_details> getRecruitementProcessById(Long id);


    Recruitement_process_details createRecruitementProcess(Recruitement_process_details recruitementProcess);


    Recruitement_process_details updateRecruitementProcess(Recruitement_process_details updatedRecruitementProcess);

    void deleteRecruitementProcess(Long id);
}

package com.example.corzello.Repository;

import com.example.corzello.Entity.Recruitement_process_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitementRepo extends JpaRepository<Recruitement_process_details,Long> {
}

package com.example.corzello.Repository;
import com.example.corzello.Entity.proposed_job_offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapingRepository extends JpaRepository<proposed_job_offer,Long> {
}

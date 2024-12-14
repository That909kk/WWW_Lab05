package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.backend.models.Candidate;

import java.util.Set;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c JOIN c.jobPostings jp WHERE jp.id = :jobPostingId")
    Set<Candidate> findByJobPostingId(Long jobPostingId);
}

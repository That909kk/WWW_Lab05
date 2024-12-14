package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backend.models.Candidate;

import java.util.Optional;
import java.util.Set;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT c FROM Candidate c JOIN c.jobPostings jp WHERE jp.id = :jobPostingId")
    Set<Candidate> findByJobPostingId(Long jobPostingId);

    @Query("SELECT DISTINCT c FROM Candidate c " +
            "JOIN c.jobPostings jp " +
            "LEFT JOIN FETCH c.candidateSkills cs " +
            "LEFT JOIN FETCH cs.skill " +
            "WHERE jp.id = :jobPostingId")
    Set<Candidate> findCandidatesByJobPostingIdWithSkills(@Param("jobPostingId") Long jobPostingId);
}

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Long> {
    @Query("SELECT cs.skill FROM CandidateSkill cs WHERE cs.can.id = :candidateId")
    List<Skill> findSkillsByCandidateId(@Param("candidateId") Long candidateId);
}

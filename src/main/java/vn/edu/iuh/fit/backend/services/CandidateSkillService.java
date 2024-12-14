package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;

import java.util.List;

@Service
public class CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    public List<CandidateSkill> getAllCandidateSkills() {
        return candidateSkillRepository.findAll();
    }
    public CandidateSkill getCandidateSkillById(Long id) throws Throwable {
        return (CandidateSkill) candidateSkillRepository.findById(id).orElseThrow(() -> new RuntimeException("CandidateSkill not found"));
    }
    public CandidateSkill saveCandidateSkill(CandidateSkill candidateSkill) {
        return (CandidateSkill) candidateSkillRepository.save(candidateSkill);
    }
    public void deleteCandidateSkill(Long id) {
        candidateSkillRepository.deleteById(id);
    }
    public CandidateSkill updateCandidateSkill(CandidateSkill candidateSkill) {
        return (CandidateSkill) candidateSkillRepository.save(candidateSkill);
    }


}

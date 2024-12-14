package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;

import java.util.List;
import java.util.Set;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        Candidate candidate = getCandidateById(id);
        candidate.setDob(updatedCandidate.getDob());
        candidate.setEmail(updatedCandidate.getEmail());
        candidate.setFullName(updatedCandidate.getFullName());
        candidate.setPhone(updatedCandidate.getPhone());
        candidate.setAddress(updatedCandidate.getAddress());
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
    // Lấy ứng viên theo JobPosting ID
//    public Set<Candidate> findCandidatesByJobPostingId(Long jobPostingId) {
//        return candidateRepository.findByJobPostingId(jobPostingId);
//    }

    //Mới

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    public Set<Candidate> findCandidatesByJobPostingId(Long jobPostingId) {
        return candidateRepository.findCandidatesByJobPostingIdWithSkills(jobPostingId);
    }

    public List<Skill> findSkillsByCandidateId(Long candidateId) {
        return candidateSkillRepository.findSkillsByCandidateId(candidateId);
    }

}

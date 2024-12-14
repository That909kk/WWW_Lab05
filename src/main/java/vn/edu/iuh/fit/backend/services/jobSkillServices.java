package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;

import java.util.List;

@Service
public class jobSkillServices {
    @Autowired
    private JobSkillRepository jobSkillRepository;
    public List<JobSkill> getAllJobSkills() {
        return jobSkillRepository.findAll();
    }
    public JobSkill getJobSkillById(Long id) {
        return jobSkillRepository.findById(id).orElseThrow(() -> new RuntimeException("JobSkill not found"));
    }
    public JobSkill saveJobSkill(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }
    public void deleteJobSkill(Long id) {
        jobSkillRepository.deleteById(id);
    }
    public JobSkill updateJobSkill(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }
}

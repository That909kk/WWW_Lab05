package vn.edu.iuh.fit.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.repositories.JobPostingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public Page<JobPosting> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return jobPostingRepository.findAll(pageable);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public JobPosting saveJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }

    public List<JobPosting> findJobPostingsByCompany(Long companyId) {
        return jobPostingRepository.findByCompany_Id(companyId);
    }

    public List<JobPosting> searchJobPostings(String keyword) {
        return jobPostingRepository.findByTitleContaining(keyword);
    }
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobPosting not found"));
    }
    public void toggleStatus(Long jobPostingId) {
        Optional<JobPosting> optionalJobPosting = jobPostingRepository.findById(jobPostingId);
        if (optionalJobPosting.isPresent()) {
            JobPosting jobPosting = optionalJobPosting.get();
            jobPosting.setStatus(!jobPosting.isStatus()); // Đổi trạng thái (true <-> false)
            jobPostingRepository.save(jobPosting);
        }
    }
    public Page<JobPosting> findActiveJobPostings(Pageable pageable) {
        return jobPostingRepository.findByStatusTrue(pageable);
    }





    public void save(JobPosting jobPosting) {
        jobPostingRepository.save(jobPosting);
    }
}

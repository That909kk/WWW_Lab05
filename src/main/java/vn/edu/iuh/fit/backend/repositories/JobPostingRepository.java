package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.JobPosting;

import java.util.List;
import java.util.Optional;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByCompany_Id(Long companyId);

    List<JobPosting> findByTitleContaining(String keyword);

    Optional<JobPosting> findById(Long id);
    Page<JobPosting> findByStatusTrue(Pageable pageable);
}

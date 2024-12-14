package vn.edu.iuh.fit.backend.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.JobType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // Tiêu đề của bài đăng

    @Lob
    @Column(nullable = false)
    private String description; // Mô tả công việc chi tiết

    @Column (name = "required_skills")
    private String requiredSkills; // Danh sách kỹ năng yêu cầu

    @Column(nullable = false)
    private LocalDate postedAt = LocalDate.now(); // Thời gian đăng bài

    private LocalDate expiresAt; // Thời gian hết hạn bài đăng

    @Column (name = "year_of_experience",nullable = true)
    private int yearOfExperience;

    @Column(name = "suggested_salary",nullable = true)
    private double suggestedSalary;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name="status",nullable = false)
    private boolean status;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company; // Công ty đăng bài


    @Enumerated(EnumType.STRING)
    private JobType jobType; // FULL_TIME, PART_TIME, CONTRACT, etc.
    @ManyToMany
    @JoinTable(
            name = "job_candidate",
            joinColumns = @JoinColumn(name = "job_posting_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<Candidate> candidates;
}
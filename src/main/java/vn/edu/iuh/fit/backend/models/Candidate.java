package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @ManyToMany(mappedBy = "candidates")
    private Set<JobPosting> jobPostings;

    @OneToMany(mappedBy = "can", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CandidateSkill> candidateSkills;

    public Long getJobPostingId() {
        return jobPostings.stream().findFirst().get().getId();
    }
}
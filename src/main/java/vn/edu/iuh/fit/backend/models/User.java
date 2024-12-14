package vn.edu.iuh.fit.backend.models;


import jakarta.persistence.*;
import lombok.Data;
import vn.edu.iuh.fit.backend.enums.Role;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ADMIN, HR, CANDIDATE

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company; // HR thuộc công ty nào
}
package vn.edu.iuh.fit.backend.dto;

import vn.edu.iuh.fit.backend.models.Candidate;

public class CandidateScore {
    private Candidate candidate;
    private double matchScore;

    // Constructor
    public CandidateScore(Candidate candidate, double matchScore) {
        this.candidate = candidate;
        this.matchScore = matchScore;
    }

    // Getters and Setters
    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }
}

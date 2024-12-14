package vn.edu.iuh.fit.backend.enums;

public enum JobType {
    FULL_TIME(1),
    PART_TIME(2),
    INTERNSHIP(3),
    FREELANCE(4),
    REMOTE(5);
    private final int value;
    JobType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

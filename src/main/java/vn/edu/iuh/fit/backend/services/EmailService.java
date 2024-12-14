package vn.edu.iuh.fit.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.JobPostingRepository;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendInterviewEmail(String toEmail, String candidateName, String jobTitle, String interviewDate) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Thư Mời Phỏng Vấn");
        message.setText(String.format(
                "Xin chào %s,\n\nChúng tôi vui mừng thông báo bạn đã được mời tham gia phỏng vấn cho vị trí %s. " +
                        "Thời gian phỏng vấn: %s.\n\nTrân trọng,\nBộ phận Nhân sự.",
                candidateName, jobTitle, interviewDate
        ));
        message.setFrom("your-email@gmail.com");
        mailSender.send(message);
    }

}

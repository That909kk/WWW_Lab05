package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.EmailService;

import java.util.Set;

@Controller
public class InterviewController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CandidateService candidateService;
    @GetMapping("/interview")
    public String sendInterviewEmail(@RequestParam Long candidateId, @RequestParam String jobTitle, @RequestParam String interviewDate) {
        // Lấy thông tin ứng viên từ CandidateService
        Candidate candidate = candidateService.getCandidateById(candidateId);

        // Gửi email
        emailService.sendInterviewEmail(candidate.getEmail(), candidate.getFullName(), jobTitle, interviewDate);

        // Chuyển hướng về lại trang trước
        return "redirect:/dashboard/jobposting/" + candidateId;
    }

}

package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.EmailService;
import vn.edu.iuh.fit.backend.services.JobPostingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class InterviewController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CandidateService candidateService;
//    @GetMapping("/interview")
//    public String sendInterviewEmail(@RequestParam Long candidateId, @RequestParam String jobTitle, @RequestParam String interviewDate) {
//        // Lấy thông tin ứng viên từ CandidateService
//        Candidate candidate = candidateService.getCandidateById(candidateId);
//
//        // Gửi email
//        emailService.sendInterviewEmail(candidate.getEmail(), candidate.getFullName(), jobTitle, interviewDate);
//
//        // Chuyển hướng về lại trang trước
//        return "redirect:/dashboard/jobposting/" + candidateId;
//    }
//@GetMapping("/interview")
//public String sendInterviewEmail(@RequestParam Long candidateId,
//                                 @RequestParam String jobTitle,
//                                 @RequestParam String interviewDate,
//                                 Model model) {
//    // Lấy thông tin ứng viên từ CandidateService
//    Candidate candidate = candidateService.getCandidateById(candidateId);
//
//    // Gửi email
//    emailService.sendInterviewEmail(candidate.getEmail(), candidate.getFullName(), jobTitle, interviewDate);
//
//    // Thêm thông báo vào model
//    model.addAttribute("message", "Thư mời phỏng vấn đã được gửi thành công tới " + candidate.getFullName());
//
//    // Tải lại danh sách ứng viên
//    Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(candidate.getJobPostingId());
//    model.addAttribute("candidates", candidates);
//
//    // Trả về trang hiện tại
//    return "hrs/jobposting-candidate";
//}
    @Autowired
    private JobPostingService jobPostingService;
//@GetMapping("/interview")
//public String sendInterviewEmail(@RequestParam Long candidateId,
//                                 @RequestParam String jobTitle,
//                                 @RequestParam String interviewDate,
//                                 @RequestParam Long jobPostingId,
//                                 Model model) {
//    JobPosting jobPosting =     jobPostingService.getJobPostingById(jobPostingId);
//
//    // Lấy thông tin ứng viên từ CandidateService
//    Candidate candidate = candidateService.getCandidateById(candidateId);
//
//    // Gửi email
//    emailService.sendInterviewEmail(candidate.getEmail(), candidate.getFullName(), jobTitle, interviewDate);
//
//    // Thêm thông báo vào model
//    model.addAttribute("message", "Thư mời phỏng vấn đã được gửi thành công tới " + candidate.getFullName());
//
//    // Lấy danh sách ứng viên cho JobPosting
//    Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(jobPostingId);
//    Map<Long, List<Skill>> candidateSkills = new HashMap<>();
//
//    for (Candidate c : candidates) {
//        List<Skill> skills = candidateService.getSkillsByCandidateId(c.getId());
//        candidateSkills.put(c.getId(), skills);
//    }
//
//    model.addAttribute("candidates", candidates);
//    model.addAttribute("candidateSkills", candidateSkills);
//    model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + jobPostingId + ")");
//
//    // Trả về template mà không chuyển trang
//    return "hrs/jobposting-candidate";
//}
@GetMapping("/interview")
public String sendInterviewEmail(@RequestParam Long candidateId,
                                 @RequestParam String jobTitle,
                                 @RequestParam String interviewDate,
                                 @RequestParam Long jobPostingId,
                                 Model model) {
    // Lấy thông tin bài đăng công việc
    JobPosting jobPosting = jobPostingService.getJobPostingById(jobPostingId);

    // Lấy thông tin ứng viên từ CandidateService
    Candidate candidate = candidateService.getCandidateById(candidateId);

    // Gửi email
    emailService.sendInterviewEmail(candidate.getEmail(), candidate.getFullName(), jobTitle, interviewDate);

    // Thêm thông báo vào model
    model.addAttribute("message", "Thư mời phỏng vấn đã được gửi thành công tới " + candidate.getFullName());

    // Lấy danh sách ứng viên cho JobPosting
    Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(jobPostingId);
    Map<Long, List<Skill>> candidateSkills = new HashMap<>();

    for (Candidate c : candidates) {
        List<Skill> skills = candidateService.getSkillsByCandidateId(c.getId());
        candidateSkills.put(c.getId(), skills);
    }
    model.addAttribute("jobPosting", jobPosting);
    model.addAttribute("candidates", candidates);
    model.addAttribute("candidateSkills", candidateSkills);
    model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + jobPostingId + ")");

    // Trả về template mà không chuyển trang
    return "hrs/jobposting-candidate";
}


}

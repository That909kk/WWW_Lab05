package vn.edu.iuh.fit.frontend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.JobPostingService;
import vn.edu.iuh.fit.backend.services.UserService;

import java.security.Principal;

@Controller
public class JobApplicationController {

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserService userService;
    @PostMapping("/dashboard/apply")
    public String applyJob(
            @RequestParam("jobPostingId") Long jobPostingId,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        String username = principal.getName(); // Lấy username từ Spring Security
        User user = userService.getUserByUsername(username);
        Candidate candidate = user.getCandidate();
        JobPosting jobPosting = jobPostingService.getJobPostingById(jobPostingId);
        if (jobPosting == null || candidate == null) {
            redirectAttributes.addFlashAttribute("error", "Ứng tuyển thất bại. Công việc hoặc ứng viên không tồn tại.");
            return "redirect:/dashboard/candidate";
        }

        if (jobPosting.getCandidates().contains(candidate)) {
            redirectAttributes.addFlashAttribute("error", "Bạn đã ứng tuyển vào công việc này rồi.");
            return "redirect:/dashboard/candidate";
        }

        jobPosting.getCandidates().add(candidate);
        jobPostingService.save(jobPosting);

        redirectAttributes.addFlashAttribute("message", "Ứng tuyển thành công vào công việc: " + jobPosting.getTitle());
        return "redirect:/dashboard/candidate";
    }
}
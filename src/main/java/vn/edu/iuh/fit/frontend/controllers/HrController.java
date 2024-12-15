package vn.edu.iuh.fit.frontend.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.dto.CandidateScore;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.CandidateSkillService;
import vn.edu.iuh.fit.backend.services.JobPostingService;
import vn.edu.iuh.fit.backend.services.MLService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@Controller
//public class HrController {
//
//    @Autowired
//    private CandidateService candidateService;
//
//    @GetMapping("/dashboard/hr")
//    public String hrDashboard(Model model,
//                              @RequestParam("page") Optional<Integer> page,
//                              @RequestParam("size") Optional<Integer> size) {
//       int currentPage = page.orElse(1);
//         int pageSize = size.orElse(10);
//            Page<Candidate> candidatePage= candidateService.findAll(
//                    currentPage - 1,pageSize,"id","asc");
//            model.addAttribute("candidatePage", candidatePage);
//            int totalPages = candidatePage.getTotalPages();
//            if (totalPages > 0) {
//                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                        .boxed()
//                        .collect(Collectors.toList());
//                model.addAttribute("pageNumbers", pageNumbers);
//            }
//            return "hrs/dashboard-hr";
//
//    }
//    @Autowired
//    private JobPostingService jobPostingService;
//
//    @GetMapping("/dashboard/hr")
//    public String candidateDashboard(Model model,
//                                     @RequestParam("page") Optional<Integer> page,
//                                     @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(10);
//        Page<JobPosting> jobPostingPage = jobPostingService.findAll(currentPage - 1, pageSize, "id", "asc");
//        model.addAttribute("jobPostingPage", jobPostingPage);
//        int totalPages = jobPostingPage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = java.util.stream.IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(java.util.stream.Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        return "hrs/dashboard-hr";
//    }

//}

//@Controller
//public class HrController {

//    @Autowired
//    private CandidateService candidateService;
//
//    @Autowired
//    private JobPostingService jobPostingService;
//
//    @GetMapping("/dashboard/hr")
//    public String hrDashboard(Model model,
//                              @RequestParam("candidatePage") Optional<Integer> candidatePage,
//                              @RequestParam("candidateSize") Optional<Integer> candidateSize,
//                              @RequestParam("jobPage") Optional<Integer> jobPage,
//                              @RequestParam("jobSize") Optional<Integer> jobSize) {
//        // Phân trang danh sách Candidate
//        int currentCandidatePage = candidatePage.orElse(1);
//        int candidatePageSize = candidateSize.orElse(10);
//        Page<Candidate> candidatePageResult = candidateService.findAll(
//                currentCandidatePage - 1, candidatePageSize, "id", "asc");
//        model.addAttribute("candidatePage", candidatePageResult);
//
//        // Số trang Candidate
//        int candidateTotalPages = candidatePageResult.getTotalPages();
//        if (candidateTotalPages > 0) {
//            List<Integer> candidatePageNumbers = IntStream.rangeClosed(1, candidateTotalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("candidatePageNumbers", candidatePageNumbers);
//        }
//
//        // Phân trang danh sách JobPosting
//        int currentJobPage = jobPage.orElse(1);
//        int jobPageSize = jobSize.orElse(10);
//        Page<JobPosting> jobPostingPageResult = jobPostingService.findAll(
//                currentJobPage - 1, jobPageSize, "id", "asc");
//        model.addAttribute("jobPostingPage", jobPostingPageResult);
//
//        // Số trang JobPosting
//        int jobTotalPages = jobPostingPageResult.getTotalPages();
//        if (jobTotalPages > 0) {
//            List<Integer> jobPageNumbers = IntStream.rangeClosed(1, jobTotalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("jobPageNumbers", jobPageNumbers);
//        }
//
//        // Trả về giao diện
//        return "hrs/dashboard-hr";
//    }
//
//    @GetMapping("/dashboard/jobposting/change-status/{id}")
//    public String changeStatus(@PathVariable Long id) {
//        jobPostingService.toggleStatus(id); // Thay đổi trạng thái
//        return "redirect:/dashboard/hr"; // Quay lại trang Dashboard
//    }
//
//
//    // Hiển thị danh sách ứng viên ứng tuyển vào một công việc cụ thể
//    @GetMapping("/dashboard/hr/jobposting/{id}")
//    public String listCandidatesByJobPosting(@PathVariable Long id, Model model) {
//        Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(id);
//        model.addAttribute("candidates", candidates);
//        model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + id + ")");
//        return "hrs/dashboard-hr";
//    }
@Controller
public class HrController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private CandidateSkillService candidateSkillService;

    // Hiển thị danh sách ứng viên và bài đăng
    @GetMapping("/dashboard/hr")
    public String hrDashboard(Model model,
                              @RequestParam("candidatePage") Optional<Integer> candidatePage,
                              @RequestParam("candidateSize") Optional<Integer> candidateSize,
                              @RequestParam("jobPage") Optional<Integer> jobPage,
                              @RequestParam("jobSize") Optional<Integer> jobSize) {
        // Phân trang danh sách Candidate
        int currentCandidatePage = candidatePage.orElse(1);
        int candidatePageSize = candidateSize.orElse(10);
        Page<Candidate> candidatePageResult = candidateService.findAll(
                currentCandidatePage - 1, candidatePageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePageResult);

        // Số trang Candidate
        int candidateTotalPages = candidatePageResult.getTotalPages();
        if (candidateTotalPages > 0) {
            List<Integer> candidatePageNumbers = IntStream.rangeClosed(1, candidateTotalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("candidatePageNumbers", candidatePageNumbers);
        }

        // Phân trang danh sách JobPosting
        int currentJobPage = jobPage.orElse(1);
        int jobPageSize = jobSize.orElse(10);
        Page<JobPosting> jobPostingPageResult = jobPostingService.findAll(
                currentJobPage - 1, jobPageSize, "id", "asc");
        model.addAttribute("jobPostingPage", jobPostingPageResult);

        // Số trang JobPosting
        int jobTotalPages = jobPostingPageResult.getTotalPages();
        if (jobTotalPages > 0) {
            List<Integer> jobPageNumbers = IntStream.rangeClosed(1, jobTotalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("jobPageNumbers", jobPageNumbers);
        }

        // Tiêu đề mặc định
        model.addAttribute("headerTitle", "Danh Sách Tất Cả Ứng Viên");

        // Trả về giao diện
        return "hrs/dashboard-hr";
    }
    // Thay đổi trạng thái JobPosting
    @GetMapping("/dashboard/jobposting/change-status/{id}")
    public String changeStatus(@PathVariable Long id) {
        jobPostingService.toggleStatus(id); // Thay đổi trạng thái
        return "redirect:/dashboard/hr"; // Quay lại trang Dashboard
    }

//    // Hiển thị danh sách ứng viên ứng tuyển vào một công việc cụ thể
//    @GetMapping("/dashboard/jobposting/{id}")
//    public String listCandidatesByJobPosting(@PathVariable Long id, Model model) {
//        Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(id);
//        model.addAttribute("candidates", candidates);
//        model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + id + ")");
//        return "hrs/jobposting-candidate";
//    }
//    @Autowired
//    private MLService mlService;
//@GetMapping("/dashboard/jobposting/{id}")
//public String listCandidatesByJobPosting(@PathVariable Long id, Model model) {
//        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
//    Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(id);
//    Map<Long, List<Skill>> candidateSkills = new HashMap<>();
//
//    List<Map<Candidate,Double >> candidateScores = new ArrayList<>();
//    String jobDescription = jobPosting.getRequiredSkills()+jobPosting.getDescription()+jobPosting.getTitle()+jobPosting.getPosition()+jobPosting.getJobType();
//    for (Candidate candidate : candidates) {
//        List<Skill> skills = candidateService.findSkillsByCandidateId(candidate.getId());
//        for (Skill skill : skills) {
//           String candidateinfoSkill = skill.getSkillName()+skill.getSkillDescription()+skill.getType();
//            double matchScore = mlService.getMatchScore(candidateinfoSkill, jobDescription);
//            Map<Candidate,Double> candidateScore = new HashMap<>();
//            candidateScore.put( candidate,matchScore);
//            candidateScores.add(candidateScore);
//            System.out.println("Match score: " + matchScore);
//        }
//
//        candidateSkills.put(candidate.getId(), skills);
//
//    }
//    candidateScores.sort((a, b) -> Double.compare((double) b.get("matchScore"), (double) a.get("matchScore")));
//    model.addAttribute("candidateScores", candidateScores);
//    model.addAttribute("jobPosting", jobPosting);
//    model.addAttribute("candidates", candidates);
//    model.addAttribute("candidateSkills", candidateSkills);
//    model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + id + ")");
//    return "hrs/jobposting-candidate";
//}
@GetMapping("/dashboard/jobposting/{id}")
public String listCandidatesByJobPosting(@PathVariable Long id, Model model) {
    JobPosting jobPosting = jobPostingService.getJobPostingById(id);
    Set<Candidate> candidates = candidateService.findCandidatesByJobPostingId(id);
    Map<Long, List<Skill>> candidateSkills = new HashMap<>();

    for (Candidate candidate : candidates) {
        List<Skill> skills = candidateService.findSkillsByCandidateId(candidate.getId());
        candidateSkills.put(candidate.getId(), skills);
    }
    model.addAttribute("jobPosting", jobPosting);
    model.addAttribute("candidates", candidates);
    model.addAttribute("candidateSkills", candidateSkills);
    model.addAttribute("headerTitle", "Danh Sách Ứng Viên Công Việc (ID: " + id + ")");
    return "hrs/jobposting-candidate";
}


}



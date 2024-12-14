package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.services.JobPostingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {

//    @Autowired
//    private JobPostingService jobPostingService;
//
//    @GetMapping("/dashboard/candidate")
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
//        return "candidates/dashboard-candidate";
//    }
@Autowired
private JobPostingService jobPostingService;

    // Trang danh sách JobPostings "đang hoạt động" cho Candidate
    @GetMapping("/dashboard/candidate")
    public String candidateDashboard(@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size,
                                     Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<JobPosting> jobPostingPage = jobPostingService.findActiveJobPostings(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("jobPostingPage", jobPostingPage);

        // Tạo danh sách số trang
        int totalPages = jobPostingPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "candidates/dashboard-candidate";
    }

}
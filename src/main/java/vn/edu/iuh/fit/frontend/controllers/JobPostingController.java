package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.models.JobPosting;
import vn.edu.iuh.fit.backend.services.CompanyService;
import vn.edu.iuh.fit.backend.services.JobPostingService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/dashboard")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    // Phương thức để hiển thị chi tiết JobPosting
    @GetMapping("/xemthem/{id}")
    public String viewJobPostingDetails(@PathVariable Long id, Model model) {
        // Lấy JobPosting từ cơ sở dữ liệu
        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
        if (jobPosting == null) {
            return "error"; // Trả về trang lỗi nếu không tìm thấy
        }

        // Thêm JobPosting vào Model để truyền sang giao diện
        model.addAttribute("jobPosting", jobPosting);

        return "candidates/jobposting-detail"; // Tên file HTML để hiển thị chi tiết
    }
    @Autowired
    private CompanyService companyService;

    // Hiển thị form tạo JobPosting
    @GetMapping("/jobposting/create")
    public String showCreateForm(Model model) {
        model.addAttribute("jobPosting", new JobPosting());
        model.addAttribute("companies", companyService.getAllCompanies()); // Lấy danh sách công ty
        return "candidates/jobposting-create";
    }

    // Xử lý form tạo JobPosting
    @PostMapping("/jobposting/save")
    public String saveJobPosting(@ModelAttribute JobPosting jobPosting) {
        jobPosting.setPostedAt(LocalDate.now()); // Lưu ngày hiện tại
        jobPostingService.saveJobPosting(jobPosting);
        return "redirect:/dashboard/candidate";
    }

}
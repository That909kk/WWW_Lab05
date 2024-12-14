package vn.edu.iuh.fit.frontend.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/dashboard/admin")
    public String adminDashboard(Model model) {
        return "admin/dashboard-admin";
    }
}
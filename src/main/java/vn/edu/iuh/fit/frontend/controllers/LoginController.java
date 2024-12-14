package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.GrantedAuthority;
import java.security.Principal;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    // Trang đăng nhập
    @GetMapping("/login")
    public String login(Authentication authentication, Model model) {
        // Kiểm tra nếu đã đăng nhập, chuyển hướng đến dashboard
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        return "login"; // Trả về trang login.html
    }

    // Trang dashboard sau khi đăng nhập thành công
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Lấy vai trò của người dùng
        String role = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        // Điều hướng dựa trên vai trò
        if (role.contains("ROLE_CANDIDATE")) {
            return "redirect:/dashboard/candidate";
        } else if (role.contains("ROLE_HR")) {
            return "redirect:/dashboard/hr";
        } else if (role.contains("ROLE_ADMIN")) {
            return "redirect:/dashboard/admin";
        }

        return "error"; // Trả về trang lỗi nếu không xác định được vai trò
    }
}

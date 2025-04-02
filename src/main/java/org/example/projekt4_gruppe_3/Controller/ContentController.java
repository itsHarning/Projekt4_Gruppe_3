package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String loginPage(){

        return "Login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            org.springframework.ui.Model model) {

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        System.out.println(email);
        System.out.println(password);

        try {
            List<Map<String, Object>> users = jdbcTemplate.queryForList(sql, email, password);

            if (!users.isEmpty()) {

                Map<String, Object> user = users.get(0);

                // Store user info in session
                session.setAttribute("userId", user.get("id"));
                session.setAttribute("userEmail", user.get("email"));
                session.setAttribute("isLoggedIn", true);
                System.out.println("login success");

                // Redirect to homepage
                return "redirect:/";
            } else {
                // No matching user found
                model.addAttribute("error", "Invalid email or password");
                System.out.println("wrong login");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during login");
            System.out.println(e);
            System.out.println("_____");
            e.printStackTrace();
            return "login";
        }
    }

    @GetMapping("/register")
    public String register(){
        return "Register";
    }

    @GetMapping("/")
    public String placeholder(){
        return "Placeholder";
    }

    @GetMapping("/MyWishesPage")
    public String MyWishesPage(){
        return "MyWishesPage";
    }

    @GetMapping("/profile")
    public String profile(){
        return "Profile";
    }
}

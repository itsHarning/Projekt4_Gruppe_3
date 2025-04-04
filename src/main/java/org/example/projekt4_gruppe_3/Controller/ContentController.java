package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepo;

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

        String sql = "SELECT * FROM `user` WHERE email = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
             statement.setString(1, email);

             try (ResultSet resultSet = statement.executeQuery()){
                 if (resultSet.next()){ //Hvis denne kører, er brugeren fundet. Kodeord i de to næste linjer.
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password))
                     {
                         User user = new User();
                         user.setUserId(resultSet.getInt("user_id"));
                         user.setEmail(resultSet.getString("email"));
                         user.setFullName(resultSet.getString("full_name"));
                         user.setProfilePicture("profile_picture");

                         session.setAttribute("loggedInUser", user);

                         return "redirect:/";
                     } else {
                        model.addAttribute("error", "Ugyldig email eller kode");
                        return "Login";
                     }
                 } else {
                     model.addAttribute("error", "Ugyldig email eller kode");
                     return "Login";
                 }
                 }
             }

        catch (SQLException e){
            e.printStackTrace();
            model.addAttribute("error", "Database fejl:" +e.getMessage());
            return "Login";
        }
    }

    @GetMapping("/register")
    public String register(){
        return "Registration";
    }

    @GetMapping("/")
    public String homePage(){
        return "HomePage";
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

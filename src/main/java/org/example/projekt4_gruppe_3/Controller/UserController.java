package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    DataSource dataSource;

    @GetMapping("/getDeleteUser")
    public String getDeleteUser(Model model, int id) {
        userRepo.deleteUserById(id);

        return "redirect:/";
    }


    @PostMapping("/getCreateUser")
    public String getCreateUser(@RequestParam("create-email") String email,
                              @RequestParam("create-name") String name,
                              @RequestParam("create-password") String password,
                                RedirectAttributes redirectAttributes) {

        String sql = "SELECT * FROM `user` WHERE email = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) { //Hvis denne ikke kører, er brugeren ikke fundet.
                    User user = new User (email,  name,  password,  "default-profile-picture.png");
                    userRepo.saveUser(user);

                    return "redirect:/";
                }
                else { //Viser registrationError hvis mailen eksisterer. Se linje 96 i fragments
                    redirectAttributes.addFlashAttribute("registrationError", "Denne email er allerede tilknyttet en bruger");
                    return "redirect:/";
                }
            } catch (SQLException e){
                e.printStackTrace();
                return "redirect:/";
            }
        }  catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("login-email") String email,
            @RequestParam("login-password") String password,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        String sql = "SELECT * FROM `user` WHERE email = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){ //Hvis denne kører, er brugeren fundet. Kodeord bliver valideret i de to næste linjer.
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password))
                    {
                        User user = new User();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setEmail(resultSet.getString("email"));
                        user.setFullName(resultSet.getString("full_name"));
                        user.setProfilePicture(resultSet.getString("profile_picture"));
                        session.setAttribute("loggedInUser", user);

                        return "redirect:/profile";
                    } else { // Hvis ikke den kan validere loginet, bliver "error"-model displayet
                        redirectAttributes.addFlashAttribute("error", "Ugyldig email eller kode"); //linje 66 i fragments
                        return "redirect:/";
                    }
                } else {
                    redirectAttributes.addFlashAttribute("error", "Ugyldig email eller kode");
                    return "redirect:/";
                }
            }
        }

        catch (SQLException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Database fejl:" +e.getMessage());
        }
        return "redirect:/profile";
    }

    @GetMapping("/getUpdateUser")
    public String getUpdateUser(@RequestParam ("id") int id, Model model) {
        User user = userRepo.getUserById(id);
        model.addAttribute("user", user);

        return "updateUser";
    }


    @PostMapping("/saveUpdateUser")
    public String saveUpdateUser(@RequestParam String email,
                                 @RequestParam String fullName,
                                 @RequestParam String password,
                                 @RequestParam String img) {

        User user = new User(email, fullName, password, img);
        userRepo.updateUser(user);
        return "redirect:/";
    }


    @GetMapping("/getFullName")
    public String getFullName(Model model) {
        User user = new User();

        user.getFullName();
        model.addAttribute("user", user);

        return "profile";
    }
}

package org.example.projekt4_gruppe_3.Controller;

import org.apache.catalina.User;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;


    @GetMapping("/getAllUsers")
    public String getAllUser(@RequestParam ("id") int id, Model model) {
        User user = (User) userRepo.getAllUsers();
        model.addAttribute("user", user);

        return "getAllUsers";
    }

    @GetMapping("/getDeleteUser")
    public String getDeleteUser(Model model, int id) {
        userRepo.deleteUserById(id);

        return "redirect:/";
    }

    @PostMapping("getSaveUser")
    public String getSaveUser(@RequestParam String email,
                              @RequestParam String fullName,
                              @RequestParam String password,
                              @RequestParam String img,
                              Model model) {

        User user = new User (String email, String fullName, String password, String img);
        userRepo.saveUser(user);
        model.addAttribute("user", user);

    return "redirect:/";
    }

    @GetMapping("/getUpdateUser")
    public String getUpdateUser(@RequestParam ("id") int id, Model model) {
        User user = (User) userRepo.getUserById(id);
        model.addAttribute("user", user);

        return "updateUser";
    }


    @PostMapping("/saveUpdateUser")
    public String saveUpdateUser(@RequestParam String fullName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String img) {

        User user = new User(fullName, email, password, img);
        userRepo.updateUser(user);
        return "redirect:/";
    }

}

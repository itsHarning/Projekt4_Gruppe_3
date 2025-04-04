package org.example.projekt4_gruppe_3.Controller;

import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/getDeleteUser")
    public String getDeleteUser(Model model, int id) {
        userRepo.deleteUserById(id);

        return "redirect:/";
    }

    @PostMapping("/getCreateUser")
    public String getCreateUser(@RequestParam String email,
                              @RequestParam String fullName,
                              @RequestParam String password,
                              @RequestParam String img) {

        User user = new User (email,  fullName,  password,  img);
        userRepo.saveUser(user);

    return "redirect:/";
    }

    @GetMapping("/getUpdateUser")
    public String getUpdateUser(@RequestParam ("id") int id, Model model) {
        User user = (User) userRepo.getUserById(id);
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

}

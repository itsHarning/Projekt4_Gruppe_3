package org.example.projekt4_gruppe_3.Controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;

@Controller
public class WishController {

    @Autowired
    DataSource dataSource;


    @GetMapping("/getCreateWish")
    public String getCreateWish(Model model) {
    return "createWish";
    }

    @GetMapping("/getDeleteWish")
    public String getDeleteWish(Model model) {
        return "deleteWish";
    }

    @GetMapping("/getShowCar")
    public String getShowCar(Model model) {
        return "showCar";
    }

    @PostMapping ("/saveCreateWish")
    public String saveWish(@RequestParam String wishName,
                           @RequestParam String description,
                           @RequestParam int price,
                           @RequestParam String image,
                           @RequestParam int priority) {


    }
}

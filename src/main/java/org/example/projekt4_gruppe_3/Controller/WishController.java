package org.example.projekt4_gruppe_3.Controller;

import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wish;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class WishController {

    @Autowired
    WishRepository wishRepo;

    @GetMapping("/getAllWishes")
    public String getAllWishes(Model model) {
    ArrayList<Wish> wishlist = wishRepo.getAllWishes();
    model.addAttribute("wishlist", wishlist);

    return "showWishes";
    }

    @GetMapping("/getWishById")
    public String getWishById(Model model, @RequestParam("id") int id) {
        Wish wish = wishRepo.getWishById(id);
        model.addAttribute("wish", wish);
        return "showWish";
    }

    @PostMapping ("/saveCreateWish")
    public String saveWish(@RequestParam String wish_name,
                           @RequestParam String wish_description,
                           @RequestParam int price,
                           @RequestParam int quantity,
                           @RequestParam String image,
                           @RequestParam String booked_by,
                           @RequestParam String booked_status,
                           @RequestParam int priority,
                           @RequestParam String link,
                           @RequestParam Wishlist wishlist,
                           Model model) throws SQLException {


        Wish wish = new Wish(wish_name,wish_description, price, quantity, image, booked_by, booked_status, priority, link, wishlist);
        wishRepo.saveWish(wish);
        model.addAttribute("wish", wish);

        return "redirect:/";
    }

    @GetMapping("/getDeleteWishById")
    public String getDeleteWish(Model model, int id) throws SQLException {
        wishRepo.deleteWishById(id);

        return "deleteWishById";
    }

    @GetMapping("/getDeleteWishByName")
    public String getDeleteWishByName(Model model, String wish_name) throws SQLException {
        wishRepo.deleteWishByName(wish_name);
        return "deleteWishByName";
    }

    @GetMapping("/getUpdateWish")
    public String getUpdateWish(Model model, int id) throws SQLException {
        Wish wish = wishRepo.getWishById(id);
        model.addAttribute("wish", wish);
        return "updateWish";
    }

    @PostMapping("/saveUpdateWish")
    public String saveUpdateWish(@RequestParam("wish_name") String wish_name,
                                 @RequestParam("wish_description") String wish_description,
                                 @RequestParam("price") int price,
                                 @RequestParam("quantity") int quantity,
                                 @RequestParam("wish_img") String img,
                                 @RequestParam("booked_by") String booked_by,
                                 @RequestParam("booked_status") String booked_status,
                                 @RequestParam("priority") int priority,
                                 @RequestParam("link") String link) throws SQLException {
        Wish wish = new Wish(wish_name, wish_description, price, quantity, img, booked_by, booked_status, priority, link);
        wishRepo.saveWish(wish);

        return "redirect:/";
    }

}

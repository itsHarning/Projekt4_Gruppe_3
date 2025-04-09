package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wish;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.WishRepository;
import org.example.projekt4_gruppe_3.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    DataSource dataSource;

    @Autowired
    WishRepository wishRepo;

    @Autowired
    WishlistRepository wishListRepo;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/terms")
    public String terms(){
        return "terms-and-conditions";
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/show-my-wishes-page")
    public String showMyWishesPage(@RequestParam("list_id") int list_id,
                                Model model){

        Wishlist wishList = wishListRepo.getWishlistById(list_id);
        ArrayList<Wish> wishes = wishRepo.getWishesByWishListID(list_id);
        wishes.sort((wish1, wish2) -> Integer.compare(wish2.getPriority(), wish1.getPriority()));

        model.addAttribute("wishList", wishList);
        model.addAttribute("wishes", wishes);

        return "show-my-wishes-page";
    }

    @GetMapping("/update-my-wishes-page")
    public String updateMyWishesPage(@RequestParam("list_id") int list_id,
                                   HttpSession session,
                                   Model model){

        if (!isUserLoggedIn(session)){
            return "redirect:/";
        }

        Wishlist wishList = wishListRepo.getWishlistById(list_id);
        ArrayList<Wish> wishes = wishRepo.getWishesByWishListID(list_id);
        wishes.sort((wish1, wish2) -> Integer.compare(wish2.getPriority(), wish1.getPriority()));

        model.addAttribute("wishList", wishList);
        model.addAttribute("wishes", wishes);

        return "wishlist";
    }

    boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }
}

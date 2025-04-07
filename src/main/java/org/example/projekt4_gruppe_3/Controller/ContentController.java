package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wish;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.example.projekt4_gruppe_3.Repository.WishRepository;
import org.example.projekt4_gruppe_3.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ContentController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepo;

    @Autowired
    WishRepository wishRepo;

    @Autowired
    WishlistRepository wishListRepo;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("login-email") String email,
            @RequestParam("login-password") String password,
            HttpSession session,
            org.springframework.ui.Model model) {

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
                         user.setProfilePicture("profile_picture");

                         session.setAttribute("loggedInUser", user);

                         return "redirect:/Profile";
                     } else {
                        model.addAttribute("error", "Ugyldig email eller kode");
                        return "login";
                     }
                 } else {
                     model.addAttribute("error", "Ugyldig email eller kode");
                     return "login";
                 }
                 }
             }

            catch (SQLException e){
                e.printStackTrace();
                model.addAttribute("error", "Database fejl:" +e.getMessage());
                return "login";
            }
        }

    @GetMapping("/register")
    public String register(){
        return "registration";
    }

    @GetMapping("/")
    public String homePage(){
        return "home-page";
    }

    @GetMapping("/ShowMyWishesPage")
    public String showMyWishesPage(@RequestParam("list_id") int list_id,
                                Model model){

        Wishlist wishList = wishListRepo.getWishlistById(list_id);
        ArrayList<Wish> wishes = wishRepo.getWishesByWishListID(list_id);

        model.addAttribute("wishList", wishList);
        model.addAttribute("wishes", wishes);

        return "show-my-wishes-page";
    }

    @GetMapping("/UpdateMyWishesPage")
    public String updateMyWishesPage(@RequestParam("list_id") int list_id,
                                   HttpSession session,
                                   Model model){

        if (!isUserLoggedIn(session)){
            return "redirect:/login";
        }

        Wishlist wishList = wishListRepo.getWishlistById(list_id);
        ArrayList<Wish> wishes = wishRepo.getWishesByWishListID(list_id);

        model.addAttribute("wishList", wishList);
        model.addAttribute("wishes", wishes);

        return "update-my-wishes-page";
    }

    @PostMapping("/saveUpdateMyWishes")
    public String postUpdateMyWishes(
            @RequestParam("list_id") int listID,
            @RequestParam("wish_name") String wishName,
            @RequestParam("price") int price,
            @RequestParam("wish_description") String description,
            @RequestParam("quantity") int quantity,
            @RequestParam("priority") int priority,
            @RequestParam("wish_image") String image,
            @RequestParam("link") String link) {


        Wish wish = new Wish(wishName, description, price,
         quantity,
         image,
         "null",
         0,
         priority,
         link,
         listID);
        wishRepo.saveWish(wish);

        return "redirect:/UpdateMyWishesPage?list_id="+listID;
    }

    @GetMapping("wishlists")
    public String WishlistsPage(){return "WishlistsPage";}

    boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }
}

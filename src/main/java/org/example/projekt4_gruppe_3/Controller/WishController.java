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
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WishController {

    @Autowired
    WishRepository wishRepo;

    @Autowired
    WishlistRepository wishListRepo;

    @PostMapping ("/saveCreateWish")
    public String saveWish(@RequestParam String wish_name,
                           @RequestParam String wish_description,
                           @RequestParam int price,
                           @RequestParam int quantity,
                           @RequestParam String image,
                           @RequestParam String booked_by,
                           @RequestParam int booked_status,
                           @RequestParam int priority,
                           @RequestParam String link,
                           Model model) throws SQLException {


        Wish wish = new Wish(wish_name,wish_description, price, quantity, image, booked_by, booked_status, priority, link);
        wishRepo.saveWish(wish);
        model.addAttribute("wish", wish);

        return "redirect:/";
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
                                 @RequestParam("booked_status") int booked_status,
                                 @RequestParam("priority") int priority,
                                 @RequestParam("link") String link) throws SQLException {
        Wish wish = new Wish(wish_name, wish_description, price, quantity, img, booked_by, booked_status, priority, link);
        wishRepo.saveWish(wish);

        return "redirect:/";
    }

    @PostMapping("/reserveWish")
    public String reserveWish(@RequestParam("wish_id") int wishId,
                              @RequestParam("list_id") int listID,
                              @RequestParam("booked_by") String bookedBy,
                              Model model) throws SQLException {

        Wish wish = wishRepo.getWishById(wishId);
        Wishlist wishList = wishListRepo.getWishlistById(listID);

        wish.setBookedStatus(1);
        wish.setBookedBy(bookedBy);

        wishRepo.updateWish(wish);

        model.addAttribute("wishList", wishList);

        return "redirect:/show-my-wishes-page?list_id="+listID;
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

        return "redirect:/update-my-wishes-page?list_id="+listID;
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam("wish_id") int wishID,
                             @RequestParam("list_id") int listID,
                             HttpSession session) throws SQLException {

        wishRepo.deleteWishById(wishID);

        return "redirect:/update-my-wishes-page?list_id="+listID;
    }
    //Response Entity is an extension of the HTTP class.
    @GetMapping("/get-wish-details")
    public ResponseEntity<Map<String, Object>> getWishDetails(@RequestParam("wish_id") int wishID,
                                                              @RequestParam("list_id") int listID,
                                                              HttpSession session) {
        if (!isUserLoggedIn(session)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Wishlist wishList = wishListRepo.getWishlistById(listID);
        Wish wish = wishRepo.getWishById(wishID);

        //Had to create a map to retrieve the information, due to the information comming in via. a js.
        //Notice the "fetch" in the js. line 190
        Map<String, Object> wishDetails = new HashMap<>();
        wishDetails.put("wishId", wish.getWishId());
        wishDetails.put("wishName", wish.getWishName());
        wishDetails.put("price", wish.getPrice());
        wishDetails.put("description", wish.getDescription());
        wishDetails.put("quantity", wish.getQuantity());
        wishDetails.put("priority", wish.getPriority());
        wishDetails.put("image", wish.getImage());
        wishDetails.put("link", wish.getLink());

        return ResponseEntity.ok(wishDetails);
    }

    @PostMapping("/saveEditWish")
    public String postEditWish(
            @RequestParam("list_id") int listID,
            @RequestParam("wish_id") int wishID,
            @RequestParam("wish_name") String wishName,
            @RequestParam("price") int price,
            @RequestParam("wish_description") String description,
            @RequestParam("quantity") int quantity,
            @RequestParam("priority") int priority,
            @RequestParam("booked_by") String bookedBy,
            @RequestParam("booked_status") int bookedStatus,
            @RequestParam("wish_image") String image,
            @RequestParam("link") String link) throws SQLException {

        Wish wish = new Wish(wishID, wishName, description, price, quantity, image, null, 0, priority, link, listID);
        wishRepo.updateWish(wish);
        return "redirect:/update-my-wishes-page?list_id=" + listID;
    }

    boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }


}

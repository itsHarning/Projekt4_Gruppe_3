package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wish;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.example.projekt4_gruppe_3.Repository.WishlistRepository;
import org.example.projekt4_gruppe_3.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepo;

    @Autowired
    WishlistService wishlistService;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/profile")
    public String getAllWishlists(Model model, HttpSession session) throws SQLException {

        if (!isUserLoggedIn(session)){
            return "redirect:/";
        }

        ArrayList<Wishlist> wishlists;

        Object user = session.getAttribute("loggedInUser");

        User userObj = (User) user;
        wishlists = wishlistRepo.getWishlistsByUserId(userObj.getUserId());

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("profilePicture",loggedInUser.getProfilePicture());
        model.addAttribute("username", loggedInUser.getFullName());
        model.addAttribute("wishlists", wishlists);

        return "profile";
    }

    boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }

    @GetMapping("/getWishlist")
    public String getWishlist(@RequestParam("list_id") int id, Model model, HttpSession session) {

        if (!isUserLoggedIn(session)){
            return "redirect:/";


        }

        Wishlist wishList = wishlistRepo.getWishlistById(id);
        model.addAttribute("wishList", wishList);
        return "redirect:/update-my-wishes-page?list_id="+id;
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(@RequestParam("id") int id, HttpSession session) {

        if (!isUserLoggedIn(session)){
            return "redirect:/";
        }

        wishlistRepo.deleteWishlistById(id);
        return "redirect:/profile";
    }


    @PostMapping("/saveUpdateWishlist")
    public String updateWishlist(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 //Line 93 is used because the Data.java.util is different from the Date.java.sql (which is used in database)
                                 @RequestParam("updatedAt") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) java.util.Date updatedAt,
                                 HttpSession session) {

        java.util.Date convert=wishlistService.dateFormatter(updatedAt);

        //Same with this line. We need to convert from java.util.date to java.sql.date
        java.sql.Date sqlDate=new java.sql.Date(convert.getTime());


        Object user = session.getAttribute("loggedInUser");

        Wishlist wishlist = new Wishlist(name, description, sqlDate, (User) user);
        wishlistRepo.createWishlist(wishlist);
        return "redirect:/profile";
    }

    @PostMapping("/saveEditWishList")
    public String postEditWishList(
            @RequestParam("list_id") int listID,
            @RequestParam("list_name") String listName,
            @RequestParam("list_description") String listDescription,
            @RequestParam("list_image") String listImage,
            @RequestParam("updated_at") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) java.util.Date updatedAt,
            HttpSession session) {

        Object user = session.getAttribute("loggedInUser");
        java.util.Date convert=wishlistService.dateFormatter(updatedAt);
        java.sql.Date sqlDate=new java.sql.Date(convert.getTime());

        Wishlist wishlist = new Wishlist(listID, listName, listDescription, sqlDate, listImage, (User) user);
        wishlistRepo.updateWishList(wishlist);

        return "redirect:/profile";
    }

    @GetMapping("/get-wishlist-details")
    public ResponseEntity<Map<String, Object>> getWishListDetails(@RequestParam("list_id") int listID,
                                                              HttpSession session) {
        if (!isUserLoggedIn(session)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Object user = session.getAttribute("loggedInUser");

        Wishlist wishList = wishlistRepo.getWishlistById(listID);

        //Had to create a map to retrieve the information, due to the information comming in via. a js.
        //Notice the "fetch" in the js. line 190
        Map<String, Object> wishListDetails = new HashMap<>();
        wishListDetails.put("list_id", wishList.getListId());
        wishListDetails.put("list_name", wishList.getName());
        wishListDetails.put("list_description", wishList.getDescription());
        wishListDetails.put("last_updated", wishList.getLastUpdated());
        wishListDetails.put("list_image", wishList.getImage());
        wishListDetails.put("user_id", ((User) user).getUserId());


        return ResponseEntity.ok(wishListDetails);
    }

}

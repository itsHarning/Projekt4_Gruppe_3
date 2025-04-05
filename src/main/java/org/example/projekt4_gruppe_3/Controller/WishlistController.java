package org.example.projekt4_gruppe_3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.example.projekt4_gruppe_3.Repository.WishlistRepository;
import org.example.projekt4_gruppe_3.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    ContentController contentControl;

    @Autowired
    WishlistService wishlistService;

    @GetMapping("/Profile")
    public String getAllWishlists(Model model, HttpSession session) throws SQLException {

        if (!isUserLoggedIn(session)){
            return "redirect:/login";
        }

        ArrayList<Wishlist> wishlists = new ArrayList<>();

        Object user = session.getAttribute("loggedInUser");

        User userObj = (User) user;
        wishlists = wishlistRepo.getWhishlistsByUserId(userObj.getUserId());

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("username", loggedInUser.getFullName());
        model.addAttribute("wishlists", wishlists);

        return "Profile";
    }

    boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }

    @GetMapping("/getWishlist")
    public String getWishlist(@RequestParam("id") int id, Model model, HttpSession session) {

        if (!isUserLoggedIn(session)){
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistRepo.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "showWishlist";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(@RequestParam("id") int id, HttpSession session) {

        if (!isUserLoggedIn(session)){
            return "redirect:/login";
        }

        wishlistRepo.deleteWishlistById(id);
        return "redirect:/";
    }

    @GetMapping("getUpdateWishlist")
    public String getUpdateWishlist(@RequestParam("id") int id, Model model, HttpSession session) {

        if (!isUserLoggedIn(session)){
            return "redirect:/login";
        }

        Wishlist wishlist = wishlistRepo.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "updateWishlist";
    }

    @PostMapping("/saveUpdateWishList")
    public String updateWishlist(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("updatedAt") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) java.util.Date updatedAt,
                                 @RequestParam("img") String img,
                                 HttpSession session) {

        java.util.Date convert=wishlistService.dateFormatter(updatedAt);
        java.sql.Date sqlDate=new java.sql.Date(convert.getTime());

        Object user = session.getAttribute("loggedInUser");

        Wishlist wishlist = new Wishlist(name, description, sqlDate, img, (User) user);
        wishlistRepo.createWishlist(wishlist);
        return "redirect:/Profile";
    }


}

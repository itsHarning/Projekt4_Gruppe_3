package org.example.projekt4_gruppe_3.Controller;

import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.example.projekt4_gruppe_3.Repository.UserRepository;
import org.example.projekt4_gruppe_3.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WishListController {

    @Autowired
    WishlistRepository wishlistRepo;

    @GetMapping("/getAllWishLists")
    public String getAllwishLists(@RequestParam("id") int id, Model model) {
        ArrayList<Wishlist> wishlists = wishlistRepo.getAllWishlists();
        model.addAttribute("wishlists", wishlists);

        return "showAllWishLists";
    }

    @GetMapping("/getWishList")
    public String getWishlist(@RequestParam("id") int id, Model model) {
        Wishlist wishlist = wishlistRepo.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "showWishlist";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(@RequestParam("id") int id) {
        wishlistRepo.deleteWishlistById(id);
        return "redirect:/";
    }

    @GetMapping("getUpdateWishList")
    public String getUpdateWishList(@RequestParam("id") int id, Model model) {
        Wishlist wishlist = wishlistRepo.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "updateWishList";
    }

    @PostMapping("/saveUpdateWishList")
    public String updateWishlist(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("createdAt") int createdAt,
                                 @RequestParam("img") String img,
                                 @RequestParam("user") User user) {
        Wishlist wishlist = new Wishlist(name, description, createdAt, img, user);
        wishlistRepo.updateWishlist(wishlist);
        return "redirect:/";
    }


}

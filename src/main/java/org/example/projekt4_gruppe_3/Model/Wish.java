package org.example.projekt4_gruppe_3.Model;

public class Wish {
    private int wishID;
    private String wishName;
    private String description;
    private int price;
    private int quantity;
    private String image;
    private String bookedBy;



    private int bookedStatus;
    private int priority;
    private String link;
    private Wishlist wishList;
    private int listID;

    public Wish(String wishName,
                String description,
                int price,
                int quantity,
                String image,
                String bookedBy,
                int bookedStatus,
                int priority,
                String link,
                int listID) {
        this.wishName = wishName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;
        this.link=link;
        this.listID = listID;
    }

    public Wish(int wishID,
                String wishName,
                String description,
                int price,
                int quantity,
                String image,
                String bookedBy,
                int bookedStatus,
                int priority,
                String link,
                Wishlist wishList) {
        this.wishName = wishName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;
        this.wishList = wishList;
        this.link=link;
    }

    public Wish() {
    }

    public Wish(String wishName, String wishDescription, int price, int quantity, String img, String bookedBy, int bookedStatus, int priority) {
        this.wishName = wishName;
        this.description = wishDescription;
        this.price = price;
        this.quantity = quantity;
        this.image = img;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;

    }

    public Wish(String wishName, String wishDescription, int price, int quantity, String img, String bookedBy, int bookedStatus, int priority, String link) {
        this.wishName = wishName;
        this.description = wishDescription;
        this.price = price;
        this.quantity = quantity;
        this.image = img;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;
        this.link=link;


    }

    public Wish(String wishName, int price, String description, int quantity, int priority, String image, String link) {
        this.wishName = wishName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.priority = priority;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getWishId() {
        return wishID;
    }

    public void setWishId(int wishId) {
        this.wishID = wishId;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public int getBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(int bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getListID(){
        return listID;
    }

    public Wishlist getWishList() {
        return wishList;
    }

    public void setWishList(Wishlist wishList) {
        this.wishList = wishList;
    }
}

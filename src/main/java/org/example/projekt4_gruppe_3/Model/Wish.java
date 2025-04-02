package org.example.projekt4_gruppe_3.Model;

public class Wish {
    private int wishId;
    private String wishName;
    private String description;
    private int price;
    private int quantity;
    private String image;
    private String bookedBy;
    private String bookedStatus;
    private String priority;
    private int wishlistId;

    public Wish(int wishId,
                String wishName,
                String description,
                int price,
                int quantity,
                String image,
                String bookedBy,
                String bookedStatus,
                String priority,
                int wishlistId) {
        this.wishId = wishId;
        this.wishName = wishName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;
        this.wishlistId = wishlistId;
    }

    public Wish(String wishName,
                String description,
                int price,
                int quantity,
                String image,
                String bookedBy,
                String bookedStatus,
                String priority,
                int wishlistId) {
        this.wishName = wishName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.bookedBy = bookedBy;
        this.bookedStatus = bookedStatus;
        this.priority = priority;
        this.wishlistId = wishlistId;
    }

    public Wish() {
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
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

    public String getBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(String bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getWishList() {
        return wishlistId;
    }

    public void setWishList(int wishlist_id) {
        this.wishlistId = wishlist_id;
    }
}

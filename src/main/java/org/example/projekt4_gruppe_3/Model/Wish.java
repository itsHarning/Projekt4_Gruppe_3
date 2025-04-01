package org.example.projekt4_gruppe_3.Model;

public class Wish {
    private int wishId;
    private String wishName;
    private String wishDescription;
    private int wishPrice;
    private int wishQuantity;
    private String wishImg;
    private String wishBookedBy;
    private String wishBookedStatus;
    private String wishPriority;
    private WishList wishList;

    public Wish(int wishId,
                String wishName,
                String wishDescription,
                int wishPrice,
                int wishQuantity,
                String wishImg,
                String wishBookedBy,
                String wishBookedStatus,
                String wishPriority,
                WishList wishList) {
        this.wishId = wishId;
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.wishPrice = wishPrice;
        this.wishQuantity = wishQuantity;
        this.wishImg = wishImg;
        this.wishBookedBy = wishBookedBy;
        this.wishBookedStatus = wishBookedStatus;
        this.wishPriority = wishPriority;
        this.wishList = wishList;
    }

    public Wish(String wishName,
                String wishDescription,
                int wishPrice,
                int wishQuantity,
                String wishImg,
                String wishBookedBy,
                String wishBookedStatus,
                String wishPriority,
                WishList wishList) {
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.wishPrice = wishPrice;
        this.wishQuantity = wishQuantity;
        this.wishImg = wishImg;
        this.wishBookedBy = wishBookedBy;
        this.wishBookedStatus = wishBookedStatus;
        this.wishPriority = wishPriority;
        this.wishList = wishList;
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

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public int getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(int wishPrice) {
        this.wishPrice = wishPrice;
    }

    public int getWishQuantity() {
        return wishQuantity;
    }

    public void setWishQuantity(int wishQuantity) {
        this.wishQuantity = wishQuantity;
    }

    public String getWishImg() {
        return wishImg;
    }

    public void setWishImg(String wishImg) {
        this.wishImg = wishImg;
    }

    public String getWishBookedBy() {
        return wishBookedBy;
    }

    public void setWishBookedBy(String wishBookedBy) {
        this.wishBookedBy = wishBookedBy;
    }

    public String getWishBookedStatus() {
        return wishBookedStatus;
    }

    public void setWishBookedStatus(String wishBookedStatus) {
        this.wishBookedStatus = wishBookedStatus;
    }

    public String getWishPriority() {
        return wishPriority;
    }

    public void setWishPriority(String wishPriority) {
        this.wishPriority = wishPriority;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }
}

package org.example.projekt4_gruppe_3.Model;

import java.util.ArrayList;

public class Wishlist {
    private int listId;
    private String name;
    private String description;
    private Long lastUpdated;
    private User user;
    private String image;
    private ArrayList<Wish> wishes = new ArrayList<>();

    public Wishlist(int listId, String name, String description, Long lastUpdated, String image, User user) {
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
        this.image = image;
        this.user = user;
    }

    public Wishlist(String name, String description, Long lastUpdated, String image, User user) {
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
        this.image = image;
        this.user = user;
    }

    public Wishlist(int listId, String name, String description, Long lastUpdated, String image) {
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
        this.image = image;
    }

    public Wishlist() {
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
    }
}

package org.example.projekt4_gruppe_3.Model;

import java.util.ArrayList;

public class Wishlist {
    private int listId;
    private String name;
    private String description;
    private int createdAt;
    private int userId;
    private String image;
    private ArrayList<Wish> wishes = new ArrayList<>();

    public Wishlist(int listId, String name, String description, int createdAt, String image, int userId) {
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.image = image;
        this.userId = userId;
    }

    public Wishlist(String name, String description, int createdAt, String image, int userId) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.image = image;
        this.userId = userId;
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

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

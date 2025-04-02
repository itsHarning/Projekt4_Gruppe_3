package org.example.projekt4_gruppe_3.Model;

import java.util.ArrayList;

public class Wishlist {
    private int list_id;
    private String name;
    private String description;
    private int created_at;
    private User user;
    private String image;
    public ArrayList<Wish> wishes = new ArrayList<>();

    public Wishlist(int list_id, String name, String description, int created_at, User user) {
        this.list_id = list_id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.user = user;
    }

    public Wishlist(String name, String description, int created_at, User user, String image) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.user = user;
        this.image = image;
    }

    public Wishlist(int list_id, String name, String description, int created_at, String image) {
        this.list_id = list_id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.image = image;
    }

    public Wishlist() {
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
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
}

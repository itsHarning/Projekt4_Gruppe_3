package org.example.projekt4_gruppe_3.Model;

import java.util.ArrayList;

public class WishList {
    private int list_id;
    private String name;
    private Long created_at;
    private User user;
    private String image;
    public ArrayList<Wish> wishes = new ArrayList<>();

    public WishList(int list_id, String name, Long created_at, User user) {
        this.list_id = list_id;
        this.name = name;
        this.created_at = created_at;
        this.user = user;
    }

    public WishList(String name, Long created_at, User user, String image) {
        this.name = name;
        this.created_at = created_at;
        this.user = user;
        this.image = image;
    }

    public WishList() {
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

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
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

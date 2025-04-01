package org.example.projekt4_gruppe_3.Model;

public class WishList {
    int list_id;
    String name;
    Long created_at;
    User user_id;
    String image;

    public WishList(int list_id, String name, Long created_at, User user_id) {
        this.list_id = list_id;
        this.name = name;
        this.created_at = created_at;
        this.user_id = user_id;
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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}

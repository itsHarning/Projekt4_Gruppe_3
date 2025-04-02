package org.example.projekt4_gruppe_3.Model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String email;
    private String fullName;
    private String password;
    private String profilePicture;
    public ArrayList<WishList> wishLists = new ArrayList<>();

    public User(int userId, String user_email, String user_full_name, String password, String profilePicture) {
        this.userId = userId;
        this.email = user_email;
        this.fullName = user_full_name;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public User(String email, String fullName, String password, String profilePicture) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

package org.example.projekt4_gruppe_3.Model;

public class User {
    private int userId;
    private String email;
    private String fullName;
    private String password;
    private String profilePicture;

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

package org.example.projekt4_gruppe_3.Model;

public class User {
    int user_id;
    String email;
    String full_name;
    String password;

    public User(int user_id, String user_email, String user_full_name, String password) {
        this.user_id = user_id;
        this.email = user_email;
        this.full_name = user_full_name;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

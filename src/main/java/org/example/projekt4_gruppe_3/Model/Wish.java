package org.example.projekt4_gruppe_3.Model;

public class Wish {
    private int wish_id;
    private String wish_name;
    private String wish_description;
    private int wish_price;
    private int wish_quantity;
    private String wish_img;
    private String wish_booked_by;
    private String wish_booked_status;
    private String wish_priority;
    private String wish_link;


    public Wish(int product_id,
                String product_name,
                String product_description,
                int product_price,
                int product_quantity,
                String product_priority,
                String product_booked_by,
                String product_booked_status,
                String product_img,
                String product_link) {

        this.wish_id = product_id;
        this.wish_name = product_name;
        this.wish_description = product_description;
        this.wish_price = product_price;
        this.wish_quantity = product_quantity;
        this.wish_priority = product_priority;
        this.wish_booked_by = product_booked_by;
        this.wish_booked_status = product_booked_status;
        this.wish_img = product_img;
        this.wish_link = product_link;
    }

    public Wish(String product_name,
                String product_description,
                int product_price,
                int product_quantity,
                String product_img,
                String product_booked_by,
                String product_booked_status,
                String product_priority,
                String product_link) {

        this.wish_name = product_name;
        this.wish_description = product_description;
        this.wish_price = product_price;
        this.wish_quantity = product_quantity;
        this.wish_img = product_img;
        this.wish_booked_by = product_booked_by;
        this.wish_booked_status = product_booked_status;
        this.wish_priority = product_priority;
        this.wish_link = product_link;
    }

    public Wish(){

    }

    public int getWish_id() {
        return wish_id;
    }

    public void setWish_id(int wish_id) {
        this.wish_id = wish_id;
    }

    public String getWish_name() {
        return wish_name;
    }

    public void setWish_name(String wish_name) {
        this.wish_name = wish_name;
    }

    public String getWish_description() {
        return wish_description;
    }

    public void setWish_description(String wish_description) {
        this.wish_description = wish_description;
    }

    public int getWish_price() {
        return wish_price;
    }

    public void setWish_price(int wish_price) {
        this.wish_price = wish_price;
    }

    public int getWish_quantity() {
        return wish_quantity;
    }

    public void setWish_quantity(int wish_quantity) {
        this.wish_quantity = wish_quantity;
    }

    public String getWish_img() {
        return wish_img;
    }

    public void setWish_img(String wish_img) {
        this.wish_img = wish_img;
    }

    public String getWish_booked_by() {
        return wish_booked_by;
    }

    public void setWish_booked_by(String wish_booked_by) {
        this.wish_booked_by = wish_booked_by;
    }

    public String getWish_booked_status() {
        return wish_booked_status;
    }

    public void setWish_booked_status(String wish_booked_status) {
        this.wish_booked_status = wish_booked_status;
    }

    public String getWish_priority() {
        return wish_priority;
    }

    public void setWish_priority(String wish_priority) {
        this.wish_priority = wish_priority;
    }

    public String getWish_link() {
        return wish_link;
    }

    public void setWish_link(String wish_link) {
        this.wish_link = wish_link;
    }
}

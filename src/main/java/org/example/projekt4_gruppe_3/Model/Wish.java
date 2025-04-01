package org.example.projekt4_gruppe_3.Model;

public class Wish {
    private int product_id;
    private String product_name;
    private String product_description;
    private int product_price;
    private int product_quantity;
    private String product_img;
    private String product_booked_by;
    private String product_booked_status;
    private String product_priority;
    private String product_link;

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

        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_priority = product_priority;
        this.product_booked_by = product_booked_by;
        this.product_booked_status = product_booked_status;
        this.product_img = product_img;
        this.product_link = product_link;
    }


}

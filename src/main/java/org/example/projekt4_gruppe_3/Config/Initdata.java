package org.example.projekt4_gruppe_3.Config;

import org.example.projekt4_gruppe_3.Model.Wish;

import java.util.ArrayList;

public class Initdata {

    public ArrayList<Wish> wishlist = new ArrayList<Wish>();

    public Initdata() {
    wishlist.add(new Wish());
    }
}

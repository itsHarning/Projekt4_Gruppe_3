package org.example.projekt4_gruppe_3.Repository;

import org.example.projekt4_gruppe_3.Model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class WishRepository {

    @Autowired
    DataSource dataSource;

//    public ArrayList<Wish> getAllWishes () {
//
//    }
}

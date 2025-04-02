package org.example.projekt4_gruppe_3.Repository;

import org.example.projekt4_gruppe_3.Model.User;
import org.example.projekt4_gruppe_3.Model.Wish;
import org.example.projekt4_gruppe_3.Model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WishlistRepository {

    @Autowired
    DataSource dataSource;

    public ArrayList<Wishlist> getAllWishlists() {
        ArrayList<Wishlist> wishlistsList = new ArrayList<>();
        String sql = "SELECT * FROM ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())  {

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist(
                        resultSet.getInt("list_id"),
                        resultSet.getString("list_name"),
                        resultSet.getString("list_description"),
                        resultSet.getInt("created_at"),
                        resultSet.getString("list_image"));
                wishlistsList.add(wishlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlistsList;
    }

}

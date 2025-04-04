package org.example.projekt4_gruppe_3.Repository;

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
        String sql = "SELECT * FROM wishlist";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())  {

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist(
                        resultSet.getInt("list_id"),
                        resultSet.getString("list_name"),
                        resultSet.getString("list_description"),
                        resultSet.getLong("created_at"),
                        resultSet.getString("list_image"));
                wishlist.setUser(new UserRepository().getUserById(resultSet.getInt("user_id")));
                wishlistsList.add(wishlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlistsList;
    }

    public Wishlist getWishlistById (int id) {
        Wishlist wishlist = new Wishlist();
        String sql = "SELECT * FROM wishlist WHERE list_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    wishlist.setListId(resultSet.getInt("list_id"));
                    wishlist.setName(resultSet.getString("list_name"));
                    wishlist.setDescription(resultSet.getString("list_description"));
                    wishlist.setLastUpdated(resultSet.getLong("created_at"));
                    wishlist.setImage(resultSet.getString("list_image"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlist;
    }

    public void deleteWishlistById (int id) {
        String sql = "DELETE FROM wishlist WHERE user_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWishlist (Wishlist wishlist) {
        String sql = "UPDATE user SET list_name = ?, list_description = ?, last_updated = ?, list_image = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, wishlist.getName());
            statement.setString(2, wishlist.getDescription());
            statement.setLong(3, wishlist.getLastUpdated());
            statement.setString(4, wishlist.getImage());
            statement.setInt(5, wishlist.getUser().getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Wishlist> getWhishlistsByUserId (int userId) throws SQLException {
        ArrayList<Wishlist> wishlists =new ArrayList<>();

        String sql = "SELECT * FROM wishlist WHERE user_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Wishlist wishlist = new Wishlist();
                    wishlist.setListId(resultSet.getInt("list_id"));
                    wishlist.setName(resultSet.getString("list_name"));
                    wishlist.setDescription(resultSet.getString("list_description"));
                    wishlist.setLastUpdated(resultSet.getLong("created_at"));
                    wishlist.setImage(resultSet.getString("list_image"));
                    wishlist.setUser(new UserRepository().getUserById(resultSet.getInt("user_id")));

                    wishlists.add(wishlist);

                }
            }
    }catch (SQLException e) {
        e.printStackTrace();}
    return wishlists;
    }
}

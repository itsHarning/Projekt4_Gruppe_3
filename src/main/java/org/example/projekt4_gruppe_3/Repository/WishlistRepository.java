package org.example.projekt4_gruppe_3.Repository;

import org.example.projekt4_gruppe_3.Model.User;
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

    @Autowired
    UserRepository userRepo;

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
                    wishlist.setLastUpdated(resultSet.getDate("last_updated"));
                    wishlist.setImage(resultSet.getString("list_image"));
                    //Line 74
                    wishlist.setUser(userRepo.getUserById(resultSet.getInt("user_id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlist;
    }

    public void deleteWishlistById (int id) {
        String sql = "DELETE FROM wishlist WHERE list_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* Måske ikke nødvendig
    public void updateWishlist (Wishlist wishlist) {
        String sql = "UPDATE wishlist SET list_name = ?, list_description = ?, last_updated = ?, list_image = ? WHERE list_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, wishlist.getName());
            statement.setString(2, wishlist.getDescription());
            statement.setDate(3, wishlist.getLastUpdated());
            statement.setString(4, wishlist.getImage());
            statement.setInt(5, wishlist.getListId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    public void createWishlist (Wishlist wishlist) {
        String sql = "INSERT INTO wishlist (list_name, list_description, last_updated, user_id) VALUES (?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, wishlist.getName());
            statement.setString(2, wishlist.getDescription());
            statement.setDate(3, wishlist.getLastUpdated());
            statement.setInt(4, wishlist.getUser().getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Wishlist> getWishlistsByUserId(int userId) throws SQLException {
        ArrayList<Wishlist> wishlists =new ArrayList<>();
        String sql = "SELECT w.list_id, w.list_name, w.list_description, w.last_updated, w.user_id AS u_user_id, u.email, u.full_name, u.password, u.profile_picture FROM wishlist w JOIN user u ON w.user_id = u.user_id WHERE w.user_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt("u_user_id"));
                    user.setEmail(resultSet.getString("email"));
                    user.setFullName(resultSet.getString("full_name"));
                    user.setPassword(resultSet.getString("password"));
                    user.setProfilePicture(resultSet.getString("profile_picture"));
                    if (user.getProfilePicture() == null || user.getProfilePicture().isEmpty()) {
                        user.setProfilePicture("default-profile-picture.png");
                    }

                    Wishlist wishlist = new Wishlist(
                            resultSet.getInt("list_id"),
                            resultSet.getString("list_name"),
                            resultSet.getString("list_description"),
                            resultSet.getDate("last_updated"));
                            wishlists.add(wishlist);

                }
            }
    }catch (SQLException e) {
        e.printStackTrace();}
    return wishlists;
    }
}

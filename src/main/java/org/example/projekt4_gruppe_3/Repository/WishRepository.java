    package org.example.projekt4_gruppe_3.Repository;

    import org.example.projekt4_gruppe_3.Model.Wish;
    import org.example.projekt4_gruppe_3.Model.Wishlist;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;

    import javax.sql.DataSource;
    import java.sql.*;
    import java.util.ArrayList;

    @Repository
    public class WishRepository {

        @Autowired
        DataSource dataSource;


        public ArrayList<Wish> getAllWishes() {
            ArrayList<Wish> wishes = new ArrayList<>();
            String sql = "SELECT * FROM wish";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int wishId = resultSet.getInt("wish_id");
                    String wishName = resultSet.getString("wish_name");
                    String description = resultSet.getString("wish_description");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String image = resultSet.getString("wish_image");
                    String bookedBy = resultSet.getString("booked_by");
                    String bookedStatus = resultSet.getString("booked_status");
                    int priority = resultSet.getInt("priority");
                    int wishlistId = resultSet.getInt("wishlist_id");

                    Wishlist wishlist = new WishlistRepository().getWishlistById(wishlistId);

                    Wish wish = new Wish(
                            wishId, wishName, description, price, quantity, image,
                            bookedBy, bookedStatus, priority, wishlist);

                    wishes.add(wish);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return wishes;
        }


        public Wish getWishById(int id) {
            Wish wish = null;
            String sql = "SELECT * FROM wish WHERE wish_id = ?";


            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        wish = new Wish();
                        wish.setWishId(resultSet.getInt("wish_id"));
                        wish.setWishName(resultSet.getString("wish_name"));
                        wish.setDescription(resultSet.getString("wish_description"));
                        wish.setPrice(resultSet.getInt("price"));
                        wish.setQuantity(resultSet.getInt("quantity"));
                        wish.setImage(resultSet.getString("wish_image"));
                        wish.setBookedBy(resultSet.getString("booked_by"));
                        wish.setBookedStatus(resultSet.getString("booked_status"));
                        wish.setPriority(resultSet.getInt("priority"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return wish;
        }

        public void saveWish(Wish wish) throws SQLException {
            String sql = "INSERT INTO wish (wish_name, wish_description, price, quantity, wish_image, booked_by, booked_status, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setString(1, wish.getWishName());
                statement.setString(2, wish.getDescription());
                statement.setInt(3, wish.getPrice());
                statement.setInt(4, wish.getQuantity());
                statement.setString(5, wish.getImage());
                statement.setString(6, wish.getBookedBy());
                statement.setString(7, wish.getBookedStatus());
                statement.setInt(8, wish.getPriority());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteWishById(int id) throws SQLException {
            String sql = "DELETE FROM wish WHERE wish_id = ?";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteWishByName(String name) throws SQLException {
            String sql = "DELETE FROM wish WHERE wish_name = ?";

            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateWish(Wish wish) throws SQLException {
            String sql ="UPDATE wish SET wish_name, wish_description, price, quantity, wish_image, booked_by, booked_status, priority VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement(sql)){
                statement.setString(1, wish.getWishName());
                statement.setString(2, wish.getDescription());
                statement.setInt(3, wish.getPrice());
                statement.setInt(4, wish.getQuantity());
                statement.setString(5, wish.getImage());
                statement.setString(6, wish.getBookedBy());
                statement.setString(7, wish.getBookedStatus());
                statement.setInt(8, wish.getPriority());

                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
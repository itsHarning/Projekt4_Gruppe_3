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

        public ArrayList<Wish> getWishesByWishListID(int id){
            Wish wish;
            ArrayList<Wish> wishList = new ArrayList<>();

            String sql = "SELECT * FROM wish WHERE list_id = ?";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        wish = new Wish();
                        wish.setWishId(resultSet.getInt("wish_id"));
                        wish.setWishName(resultSet.getString("wish_name"));
                        wish.setDescription(resultSet.getString("wish_description"));
                        wish.setPrice(resultSet.getInt("price"));
                        wish.setQuantity(resultSet.getInt("quantity"));
                        wish.setImage(resultSet.getString("wish_image"));
                        wish.setBookedBy(resultSet.getString("booked_by"));
                        wish.setBookedStatus(resultSet.getInt("booked_status"));
                        wish.setPriority(resultSet.getInt("priority"));
                        wishList.add(wish);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return wishList;
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
                        wish.setBookedStatus(resultSet.getInt("booked_status"));
                        wish.setPriority(resultSet.getInt("priority"));
                        wish.setLink(resultSet.getString("link"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return wish;
        }

        public void saveWish(Wish wish) {
            String sql = "INSERT INTO wish (wish_name, wish_description, price, quantity, wish_image, booked_by, booked_status, priority, link, list_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setString(1, wish.getWishName());
                statement.setString(2, wish.getDescription());
                statement.setInt(3, wish.getPrice());
                statement.setInt(4, wish.getQuantity());
                statement.setString(5, wish.getImage());
                statement.setString(6, wish.getBookedBy());
                statement.setInt(7, wish.getBookedStatus());
                statement.setInt(8, wish.getPriority());
                statement.setString(9, wish.getLink());
                statement.setInt(10, wish.getListID());
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

        public void updateWish(Wish wish) throws SQLException {
            String sql ="UPDATE wish SET wish_name = ?, wish_description = ?, price = ?, quantity = ?, " +
                    "wish_image = ?, booked_by = ?, booked_status = ?, priority = ?, link = ? WHERE wish_id = ?";

            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement =connection.prepareStatement(sql)){
                statement.setString(1, wish.getWishName());
                statement.setString(2, wish.getDescription());
                statement.setInt(3, wish.getPrice());
                statement.setInt(4, wish.getQuantity());
                statement.setString(5, wish.getImage());
                statement.setString(6, wish.getBookedBy());
                statement.setInt(7, wish.getBookedStatus());
                statement.setInt(8, wish.getPriority());
                statement.setString(9, wish.getLink());
                statement.setInt(10, wish.getWishId());

                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
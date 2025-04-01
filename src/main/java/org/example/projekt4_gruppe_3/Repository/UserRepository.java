package org.example.projekt4_gruppe_3.Repository;

import org.example.projekt4_gruppe_3.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    DataSource dataSource;

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())  {

            while (resultSet.next()) {
                User car = new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("full_name"),
                        resultSet.getString("password"),
                        resultSet.getString("profile_picture"));
                userList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

}

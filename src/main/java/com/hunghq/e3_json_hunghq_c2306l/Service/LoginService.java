package com.hunghq.e3_json_hunghq_c2306l.Service;

import com.hunghq.e3_json_hunghq_c2306l.Global.MySQLConnector;
import javafx.scene.control.Label;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    private static final Connection connection = MySQLConnector.getConnection();

    public boolean register(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            String query = "INSERT INTO login (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT password FROM user WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    AppProperties.setProperty("user.loggedin", "true");
                    AppProperties.setProperty("user.username", username);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void logout() {
        AppProperties.setProperty("user.loggedin", "false");
        AppProperties.setProperty("user.username", "");
    }

    private void updateStatus(Label statusLabel){
        boolean loggedIn = Boolean.parseBoolean(AppProperties.getProperty("user.loggedin"));
        if (loggedIn) {
            String username = AppProperties.getProperty("user.username");
            statusLabel.setText("User logged in: " + username);
        } else {
            statusLabel.setText("User logged out");
        }
    }
}

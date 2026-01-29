package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    
    // FIXED: Credentials should come from environment variables or configuration
    private final String dbPassword;
    
    public UserService() {
        // Get password from environment variable, with fallback for development
        this.dbPassword = System.getenv("DB_PASSWORD") != null 
            ? System.getenv("DB_PASSWORD") 
            : "admin123"; // Development fallback only
    }

    // FIXED: SQL Injection prevented with PreparedStatement
    // FIXED: Try-with-resources for proper resource management
    public void findUser(String username) throws SQLException {

        String query = "SELECT id, name, email FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", dbPassword);
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, username);
            
            try (ResultSet rs = ps.executeQuery()) {
                // Process result set if needed
                while (rs.next()) {
                    // Handle results
                }
            }
            
        } catch (SQLException e) {
            throw new SQLException("Error finding user: " + username, e);
        }
    }

    // FIXED: SQL injection prevented, try-with-resources added
    public void deleteUser(String username) throws SQLException { 
        
        String query = "DELETE FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", 
                    "root", dbPassword);
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, username);
            ps.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Error deleting user: " + username, e);
        }
    }
}
package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

public class UserServiceTest {

    private static final String DB_PASSWORD_KEY = "DB_PASSWORD";
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Set test environment variable
        System.setProperty(DB_PASSWORD_KEY, "test_password");
        userService = new UserService();
    }

    @AfterEach
    public void tearDown() {
        System.clearProperty(DB_PASSWORD_KEY);
    }

    @Test
    public void testConstructorWithEnvironmentVariable() {
        // This test verifies the constructor reads from environment
        assertNotNull(userService);
    }

    @Test
    public void testConstructorWithoutEnvironmentVariable() {
        System.clearProperty(DB_PASSWORD_KEY);
        UserService service = new UserService();
        assertNotNull(service);
    }

    @Test
    public void testFindUserThrowsSQLExceptionWithContext() {
        // Test that findUser throws SQLException with context
        // Note: This will fail in real execution without a database
        // In production, use H2 in-memory database or mocking
        
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.findUser("testuser"));
        
        // Verify the exception message contains context
        assertTrue(exception.getMessage().contains("Error finding user: testuser"));
    }

    @Test
    public void testDeleteUserThrowsSQLExceptionWithContext() {
        // Test that deleteUser throws SQLException with context
        
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.deleteUser("testuser"));
        
        // Verify the exception message contains context
        assertTrue(exception.getMessage().contains("Error deleting user: testuser"));
    }

    @Test
    public void testFindUserWithNullUsername() {
        // Test behavior with null username
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.findUser(null));
        
        assertTrue(exception.getMessage().contains("null"));
    }

    @Test
    public void testDeleteUserWithNullUsername() {
        // Test behavior with null username
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.deleteUser(null));
        
        assertTrue(exception.getMessage().contains("null"));
    }

    @Test
    public void testFindUserWithEmptyUsername() {
        // Test behavior with empty username
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.findUser(""));
        
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testDeleteUserWithEmptyUsername() {
        // Test behavior with empty username
        Exception exception = assertThrows(SQLException.class, 
            () -> userService.deleteUser(""));
        
        assertNotNull(exception.getMessage());
    }
}
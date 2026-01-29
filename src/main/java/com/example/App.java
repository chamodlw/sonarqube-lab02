package main.java.com.example;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // FIXED: Using logger instead of System.out
        int result = calc.calculate(10, 5, "add");
        logger.log(Level.INFO, "Calculation result: {0}", result);

        UserService service = new UserService();
        
        try {
            service.findUser("admin");
            service.deleteUser("admin");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database operation failed", e);
        }
    }
}
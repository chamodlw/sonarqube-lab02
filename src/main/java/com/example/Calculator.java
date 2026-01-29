package main.java.com.example;

public class Calculator {

    // FIXED: Simplified and removed duplication
    public int calculate(int a, int b, String op) { 
 
        switch(op) {
            case "add", "add-again":
                return a + b;
                
            case "sub", "sub-again":
                return a - b;
                
            case "mul":
                return a * b;
                
            case "div":
                if(b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return a / b;
                
            case "mod":
                if(b == 0) {
                    throw new IllegalArgumentException("Modulo by zero");
                }
                return a % b;
                
            case "pow":
                return power(a, b);
                
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
    
    // FIXED: Extracted power calculation to separate method
    private int power(int base, int exponent) {
        int result = 1;
        for(int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }
}
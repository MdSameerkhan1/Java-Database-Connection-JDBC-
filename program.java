package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/khan";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for customer details
            System.out.print("Enter Customer ID: ");
            int cusid = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            System.out.print("Enter Customer Name: ");
            String name = scanner.next();

            System.out.print("Enter Customer Mobile: ");
            int mobile = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter Customer Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Customer Address: ");
            String address = scanner.nextLine();

            // SQL query to insert data
            String insertSQL = "INSERT INTO emp (cusid, name, mobile, email, address) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, cusid);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, mobile);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, address);

                // Execute the insert statement
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Data insertion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

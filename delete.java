package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {

    public static void main(String[] args) {

        // Declare variable to store user input
        int customer_id;

        // Create a Scanner object to read user input
        Scanner din = new Scanner(System.in);

        // Prompt the user to enter customer ID for deletion
        System.out.println("Enter Customer Id To Delete");
        customer_id = din.nextInt();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/khan", "root", "1234");

            // Define the SQL query for deleting customer data
            String sql = "delete from customer where cid='" + customer_id + "'";

            // Create a prepared statement to execute the delete query
            PreparedStatement ps = con.prepareStatement(sql);

            // Execute the delete query and get the number of affected rows
            int i = ps.executeUpdate();

            // Check if the deletion was successful
            if (i == 1) {
                System.out.println("Customer data deleted");
            } else {
                System.out.println("Customer data is not deleted");
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur during database interaction
            e.printStackTrace();
        } finally {
            // Close the Scanner
            din.close();
        }
    }
}


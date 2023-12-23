package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {

    public static void main(String[] args) {

        // Declare variables to store user input
        int customer_id;
        String customer_email;

        // Create a Scanner object to read user input
        Scanner din = new Scanner(System.in);

        // Prompt the user to enter customer ID
        System.out.println("Enter Customer id");
        customer_id = din.nextInt();

        // Prompt the user to enter new customer email
        System.out.println("Enter Customer Email To change");
        customer_email = din.next();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/khan", "root", "1234");

            // Define the SQL query for updating customer email
            String sql = "update customer set cemail='" + customer_email + "' where cid='" + customer_id + "'";

            // Create a prepared statement to execute the update query
            PreparedStatement ps = con.prepareStatement(sql);

            // Execute the update query and get the number of affected rows
            int i = ps.executeUpdate();

            // Check if the update was successful
            if (i == 1) {
                System.out.println("Customer Information Updated Successfully");
            } else {
                System.out.println("Updation Failed");
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

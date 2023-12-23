package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class read {

    public static void main(String[] args) {

        // Declare variables to store customer information
        int customer_id;
        String customer_name;
        String customer_email;
        String customer_mobile;
        String customer_address;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/khan", "root", "1234");

            // Define the SQL query to select all records from the "customer" table
            String query = "select * from customer";

            // Create a statement to execute the query
            Statement st = con.createStatement();

            // Execute the query and get the result set
            ResultSet rs = st.executeQuery(query);

            // Iterate through the result set and print customer information
            while (rs.next()) {
                // Retrieve customer information from the result set
                customer_id = rs.getInt(1);
                customer_name = rs.getString(2);
                customer_email = rs.getString(3);
                customer_mobile = rs.getString(4);
                customer_address = rs.getString(5);

                // Print customer information to the console
                System.out.println(customer_id + "\t" + customer_name + "\t" + customer_email + "\t" + customer_mobile + "\t" + customer_address);
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur during database interaction
            e.printStackTrace();
        } finally {
            // This block will always be executed, ensuring proper resource cleanup
            System.out.println("Program End");
        }
    }
}

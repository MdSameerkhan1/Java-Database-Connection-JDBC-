package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class create {

	public static void main(String[] args) {
		
		int customer_id;
		String customer_name;
		String customer_email;
		String customer_mobile;
		String customer_address;
		Scanner din = new Scanner(System.in);
		System.out.println("Enter Customer Id");
		customer_id = din.nextInt();
		System.out.println("Enter Customer Name");
		customer_name = din.next();
		System.out.println("Enter Customer Email");
		customer_email = din.next();
		System.out.println("Enter Customer Mobile");
		customer_mobile = din.next();
		System.out.println("Enter Customer Address");
		customer_address = din.next();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/khan", "root","1234");
			//String sql="insert into customer values(?,?,?,?,?)";
			String sql="insert into customer values('"+customer_id+"','"+customer_name+"','"+customer_email+"','"+customer_mobile+"','"+customer_address+"')";
			//String sql="welcome";
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, customer_id);
//			ps.setString(2,customer_name);
//			ps.setString(3, customer_email);
//			ps.setString(4, customer_mobile);
//			ps.setString(5, customer_address);
			int i=ps.executeUpdate(); //  1 [successful] or 0 [failure]
			if(i==1)
			{
				System.out.println("Customer data saved Success");
			}
			else
			{
				System.out.println("Customer data is not saved");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

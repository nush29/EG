package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	 //A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		 //Provide the correct details: DBServer/DBName, username, password
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Kmss@shehan55");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		
		public String insertUser(String name, String address, String email, String phone, String accountnumber, String password)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 // create a prepared statement
		 String query = " insert into customer(`id`,`name`,`address`,`email`,`phone`,`accountnumber`,`password`)"
		 + " values (?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, address);
		 preparedStmt.setString(4, email);
		 preparedStmt.setString(5, phone);
		 preparedStmt.setString(6, accountnumber);
		 preparedStmt.setString(7, password);
		 // execute the statement
		 
		 preparedStmt.execute();
		 con.close();
		 output = "Inserted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		public String readUserDetails()
		
		{
			 String output = "";
			try
			 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for reading.";
			 }
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Name</th>"
			 +"<th>Address</th><th>Email</th>"
			 + "<th>phone</th>"
			 + "<th>accountnumber</th>"
			 + "<th>Password</th>";
			 String query = "select * from customer";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
				 String id = Integer.toString(rs.getInt("id"));
				 String name = rs.getString("name");
				 String address = rs.getString("address");
				 String email = rs.getString("email");
				 String phone = rs.getString("phone");
				 String accountnumber = rs.getString("accountnumber");
				 String password = rs.getString("password");
				 // Add a row into the html table
				 output += "<tr><td>" + name + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + phone + "</td>"; 
				 output += "<td>" + accountnumber + "</td>";
				 output += "<td>" + password + "</td>";
				 // buttons
				 output += "<input name='user_id' type='hidden' "
				 + " value='" + id + "'>"
				 + "</form></td></tr>";
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
			 }
			catch (Exception e)
			 {
				 output = "Error while reading the user details"
				 		+ ".";
				 System.err.println(e.getMessage());
			 }
			return output;
		}
		
		public String EditUserDetails(String id,String name,String address,String email, String phone, String accountnumber, String password)
		   {
			   String output = "";
			   try
				   {
				   Connection con = connect();
				   if (con == null)
				   {
					   return "Error while connecting to the database for updating"; 
				   }
				   // create a prepared statement
				   String query = "UPDATE customer SET name=?,address=?,email=?,phone=?,accountnumber=?,password=?WHERE id=?";
				   PreparedStatement preparedStmt = con.prepareStatement(query);
				   // binding values
				   preparedStmt.setString(1, name);
				   preparedStmt.setString(2, address);
				   preparedStmt.setString(3, email);
				   preparedStmt.setString(4, phone);
				   preparedStmt.setString(5, accountnumber);
				   preparedStmt.setString(6, password);
				   preparedStmt.setInt(7, Integer.parseInt(id));
				   // execute the statement
				   preparedStmt.execute();
				   con.close();
				   output = "Updated successfully";
				   }
			    catch (Exception e)
				{
				   output = "Error while updating the user";
				   System.err.println(e.getMessage());
				}
			    return output;
			    }
		
		public String deleteUser(String id)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{
		return "Error while connecting to the database for deleting.";
		}

		// create a prepared statement
		String query = "delete from customer where id=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);

		// binding values
		preparedStmt.setInt(1, Integer.parseInt(id));

		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Customer account Deleted successfully";
		}
		catch (Exception e)
		{
		output = e.toString();
		//System.err.println(e.getMessage());
		}
		return output;
		}
public String fetchUser(String id)
		
		{
			 String output = "";
			try
			 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for reading";
			 }
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Name</th>"
			 +"<th>Address</th><th>Email</th>"
			 + "<th>phone</th>"
			 + "<th>accountnumber</th>"
			 + "<th>Password</th></tr>";
			 String query = "select * from customer where id='"+id+"'";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 { 
				 String userid = Integer.toString(rs.getInt("id"));
				 String name = rs.getString("name");
				 String address = rs.getString("address");
				 String email = rs.getString("email");
				 String phone = rs.getString("phone");
				 String accountnumber = rs.getString("accountnumber");
				 String password = rs.getString("password");
				 // Add a row into the html table
				 
				 output += "<tr><td>" + name + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + email + "</td>"; 
				 output += "<td>" + phone + "</td>";
				 output += "<td>" + accountnumber + "</td>";
				 output += "<td>" + password + "</td></tr>";
				 // buttons
				 output += "<input name='itemID' type='hidden' "
				 + " value='" + id + "'>"
				 + "</form></td></tr>";
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
			 
			 }
			catch (Exception e)
			 {
//				 output = "Error while reading the user details";
				output=e.toString();
				 System.err.println(e.getMessage());
			 }
			return output;
		}
		
		
}

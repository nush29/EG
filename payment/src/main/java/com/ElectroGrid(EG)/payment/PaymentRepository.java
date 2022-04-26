package com.ElectroGrid(EG).payment;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentRepository {
	public Connection getConnection() {
		
		Connection con = null;
		
		String url = "Jdbc:mysql://localhost:3307/paymentapi";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Successful");
		return con;
	}
	
	
	List<Payment> payments;
	public PaymentRepository() {
		
		Connection con = getConnection();
			
		payments = new ArrayList<>();
		
		Payment p1 = new Payment();
		p1.setPaymentId(6);
		p1.setAmount(2000);
		p1.setPayDate("Cash");
		p1.setCardHolder("Aliws");
		p1.setAccount_Number("07897");
		p1.setCardNumber("4563 5678 2345 1234");
		p1.setReferenceNumber(2030);
		p1.setExpDate("04-22");
		p1.setCustmerId(14567);
		p1.setTime(5.30);
		p1.setUserId(7894);
		p1.setNameonCard();
		p1.setScurityCode(4561);
		p1.setPostCode(1020);
		p1.setPaymented();
		
		
		
		
		
		
	
		
		
		payments.add(p1);
	}
	
	public List<Payment> getAllPayment(){
		return payments;
	}
	
	public Payment createPayment(Payment p1) {
		
		String insertSql = "INSERT INTO `payment`(`paymentID`, `Amount`, `payDate`, `CardHolder`, `Account_Number`,`cardNumber`, `ReferenceNumber`, `expDate`, 'CustmerId', 'Time', 'UserId', 'NameonCard', 'ScurityCode', 'PostCode', 'Paymented') VALUES (?,?,?,?,?,?,?)";
		
		Connection con = getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(insertSql);
			pst.setInt(1, p1.paymentId);
			pst.setInt(2, p1.amount);
			pst.setString(3, p1.payDate);
			pst.setString(4, p1.CardHolder);
			pst.setString(5, p1.Account_Number);
			pst.setString(6, p1.cardNumber);
			pst.setInt(7, p1.ReferenceNumber);
			pst.setString(8, p1.expDate);
			pst.setInt(9, p1.CustmerId);
			pst.setdouble (10, p1.Time);
			pst.setInt(11, p1.UserId);
			pst.setString(12, p1.NameonCard);
			pst.setInt(13, p1.ScurityCode);
			pst.setInt(14, p1.PostCode);
			pst.setInt(15, p1.Paymente);
			
			
			pst.executeUpdate();
			
			//String output = "Inserted Successfully";
			
		}catch (Exception e) {
			System.out.println(e);
		}
		payments.add(p1);
		System.out.println(payments);
		return p1;
	}
	
	public Payment getpaymentId(int paymentId) {
		String getsql = "SELECT * FROM `payment` WHERE paymentID = '"+paymentId+"'";
		Payment pd = new Payment();
		Connection con = getConnection();
		
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(getsql);
			
			while(rs.next()) {
				
				pd.setPaymentId(rs.getInt(1));
				pd.setAmount(rs.getInt(2));
				pd.setPayDate(rs.getString(3));
				pd.setCardHolder(rs.getString(4));
				pd.setAccount_Number(rs.getString(5));
				pd.setCardNumber(rs.getString(6));
				pd.setReferenceNumber(rs.getInt(7));
				pd.setExpDate(rs.getString(8));
				pd.setCustmerId(rs.getInt(9));
				pd.setTime(rs.getInt(10));
				pd.setUserId(rs.getInt(11));
				pd.setNameonCard(rs.getString(12));
				pd.setScurityCode(rs.getInt(13));
				pd.setPostCode(rs.getInt(14));
				pd.setPaymente(rs.getInt(15));
				
				
				
							
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}
	
	public String deletePayment(int paymentId) {
		
		String output = "";
		
		try {
			Connection con = getConnection();
			
			String deletePayment = "DELETE FROM `payment` WHERE paymentID = '"+paymentId+"' ";
			PreparedStatement pst = con.prepareStatement(deletePayment);
			pst.execute();
			
			output = "Successfully Deleted";
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String updatePayment(Payment payment) {
		
		String output = "";
		try {
			Connection con = getConnection();
			
			String updatePayment = "UPDATE `payment` SET `paymentID`='"+payment.getPaymentId()+"',`Amount`='"+payment.getAmount()+"',`payDate`='"+payment.getPayDate()+"',`Account_Number`='"+payment.getAccount_Number()+"',`cardNumber`='"+payment.getCardNumber()+"',`ReferenceNumber`='"+payment.getReferenceNumber()+"',`expDate`='"+payment.getExpDate()+"' WHERE paymentID = '"+payment.getPaymentId()+"'WHERE CustmerId = '"+payment.getCustmerId()+"';
			PreparedStatement st = con.prepareStatement(updatePayment);
			
			st.executeUpdate();
			
			output = "Updated Successfully";
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String readPayment() {
		
		String output = "";
		
		try {
			Connection con = getConnection();  //DB Connection
			
			if(con == null) 
			{return "Error while connecting to the database for reading.";}
			
				output = "<table border='1'><tr><th>Payment ID</th><th>Amount</th><th>PayDate</th><th>Account_Number</th><th>Card Number</th><th>ReferenceNumber</th><th>Exp Date</th><th>CustmerId</th><th>Time</th></><thth>UserId</th></><thth>NameonCard</th></><thth>ScurityCode</th></><thth>PostCode</th></><thth>Paymente</th></" +
						"<th>Update</th><th>Remove</th></tr>";	
				String query = "SELECT * FROM `payment`";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				//move through the rows in the table
				while (rs.next()) {
					String paymentId = Integer.toString(rs.getInt("paymentID"));
					String amount = Integer.toString(rs.getInt("Amount"));
					String payDate = rs.getString("payDate");
					String CardHolder = rs.getString("CardHolder");
					String Account_Number = rs.getString("Account_Number");
					String cardNumber = rs.getString("cardNumber");
					String ReferenceNumber= Integer.toString(rs.getInt("ReferenceNumber"));
					String expDate = rs.getString("expDate");
					String  CustmerId= rs.getString("CustmerId");
					String  Time= rs.getString("Time");
					String  UserId= rs.getString("UserId");
					String   NameonCard= rs.getString("NameonCard");
					String  ScurityCode= rs.getString("ScurityCode");
					String  PostCode= rs.getString("PostCode");
					String  Paymente= rs.getString("Paymente");
					
					// adding to table
					output += "<tr><td>" + paymentId + "</td>";
					output += "<td>" + amount + "</td>";
					output += "<td>" + payDate + "</td>";
					output += "<td>" + CardHolder + "</td>";
					output += "<td>" +Account_Number + "</td>";
					output += "<td>" + cardNumber + "</td>";
					output += "<td>" + ReferenceNumber + "</td>";
					output += "<td>" + expDate + "</td>";
					output += "<td>" + CustmerId + "</td>";
					output += "<td>" + Time + "</td>";
					output += "<td>" + UserId + "</td>";
					output += "<td>" + NameonCard + "</td>";
					output += "<td>" + ScurityCode + "</td>";
					output += "<td>" + PostCode + "</td>";
					output += "<td>" + Paymente + "</td>";
					
					
					//buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
							+ "<td><form method='post' action='items.jsp'>"	
							+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							+ "<input name='itemID' type='hidden' value='" + paymentId + "'>" + "</form></td></tr>";
						
					
					
					}
				output += "</table>";
				
			
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	} 
}

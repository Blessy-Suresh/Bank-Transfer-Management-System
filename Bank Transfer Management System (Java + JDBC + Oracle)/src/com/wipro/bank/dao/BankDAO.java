package com.wipro.bank.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;
public class BankDAO {
   public int generateSequenceNumber() {
	   Connection connection =DBUtil.getDBConnection();
	   String query="select transactionId_seq1.NEXTVAL from dual";
	   try {
	   PreparedStatement ps = connection.prepareStatement(query);
	   ResultSet rs=ps.executeQuery();
	   rs.next();
	  int seqNumber=rs.getInt(1);
	  return seqNumber;
	   
	   }catch(SQLException e) {
		   e.printStackTrace();
		   return 0;
	   }
   }
   public boolean validateAccount(String accountNumber) {
	   Connection connection =DBUtil.getDBConnection();
	   String query="select * from Account_TBL where Account_Number=?";
	   try {
	   PreparedStatement ps=connection.prepareStatement(query);
	   ps.setString(1, accountNumber);
	   ResultSet rs=ps.executeQuery();
	   if(rs.next()) {
		   return true;
	   }
	   return false;
	   }catch(SQLException e) {
		   e.printStackTrace();
		   return false;
	   }
   }
	public float findBalance (String accountNumber) {
		if(validateAccount(accountNumber)) {
			Connection connection =DBUtil.getDBConnection();
			String query="select balance from Account_TBL"+" where Account_Number=?";
			try {
				PreparedStatement ps=connection.prepareStatement(query);
				ps.setString(1, accountNumber);
				ResultSet rs=ps.executeQuery();
				rs.next();
				float balance=rs.getFloat(1);
				return balance;		
		}
			catch(SQLException e) {
				   return -1;
			   }
		}
		return 0;
	}

	 public boolean updateBalance(String accountNumber, float newBalance) {
	        Connection connection = DBUtil.getDBConnection();
	        String query = "UPDATE Account_TBL SET Balance=?"+" Where Account_Number=?";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setFloat(1, newBalance);
	            ps.setString(2, accountNumber);
	            int rows = ps.executeUpdate();
	            if(rows > 0) {
	            	return true;
	            }
	            else {
	            return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }

	 public boolean transferMoney(TransferBean transferBean) {
		    transferBean.setTransactionID(generateSequenceNumber());
		    Connection connection = DBUtil.getDBConnection();
		    String query = "INSERT INTO TRANSFER_TBL VALUES(?,?,?,?,?)";
		    try {
		        PreparedStatement ps = connection.prepareStatement(query);
		        ps.setInt(1, transferBean.getTransactionID());
		        ps.setString(2, transferBean.getFromAccountNumber());
		        ps.setString(3, transferBean.getToAccountNumber());
		        Date d = new Date(transferBean.getDateOFTransaction().getTime());
		        ps.setDate(4, d);
		        ps.setFloat(5, transferBean.getAmount());
		        ps.executeUpdate();
		        return true;   
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}

		 
	 }
	
  
		   
	
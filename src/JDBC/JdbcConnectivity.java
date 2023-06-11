package JDBC;
import java.sql.Connection;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JdbcConnectivity{
	static Connection conn=null;
	public JdbcConnectivity() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String pass = "pass123";
			conn = DriverManager.getConnection(url,userName,pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createDataBase(String databaseName) {
		try {
			Statement stm = conn.createStatement();
			String query = "create database "+databaseName;
			boolean bool = stm.execute(query);
			if(bool) {
				System.out.println("Successfully Created:");
			}
			else {
				System.out.println("Successfully Created:");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteDataBase(String databaseName) {
		try {
			Statement stm = conn.createStatement();
			String query = "drop database "+databaseName;
			boolean bool = stm.execute(query);
			if(bool) {
				System.out.println("Successfully Created:");
			}
			else {
				System.out.println("Successfully Created:");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String takePassword(String userName){
		String userPass = null;
		try {
			Statement stm = conn.createStatement();
			String query = "select password from login where username='"+userName+"'";
			
			ResultSet rs = stm.executeQuery(query);
			
			
			while(rs.next()) {
				userPass = rs.getString(1);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userPass;
	}
	public int addItem(int itemId,String itemName,String portionSize,int itemDiscount,int itemPrice,int totalQty) {
		int flag = 0;
		try {
			Statement stm = conn.createStatement();
			String query = "use CMSData";
			stm.execute(query);
			query = SqlQuery.addStockQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,itemId);
			preparedStatement.setString(2,itemName);
			preparedStatement.setString(3,portionSize);
			preparedStatement.setInt(4,itemDiscount);
			preparedStatement.setInt(5,itemPrice);
			preparedStatement.setInt(6,totalQty);
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int AddEmpDetails(int ID,String First_Name,String Last_Name,long Phone_No,String Email_Id,String Password) {
		int flag = 0;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addEmpDetailsQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			preparedStatement.setString(2,First_Name);
			preparedStatement.setString(3,Last_Name);
			preparedStatement.setLong(4,Phone_No);
			preparedStatement.setString(5,Email_Id);
			preparedStatement.setString(6,Password);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public String FetchPassword(int ID) {
		
		String pass = null;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.fetchPassQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				pass = rs.getString(1);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return pass;
	}
	public int DeleteEmpAccount(int ID) {
		int flag = 0;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.deleteEmpAccountQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,ID);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		catch(Exception e) {
		
			e.printStackTrace();
		}
		return flag;
		
	}
	public int AddStockDetails(int id,String name,String portionSize,int discount,int price,int totalQty) {
		int flag =1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addStockQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,portionSize);
			preparedStatement.setInt(4,discount);
			preparedStatement.setInt(5,price);
			preparedStatement.setInt(6,totalQty);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	public int DeleteIteam(String productName,String portionSize) {
		int flag = 1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.deleteItemQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1,productName);
			preparedStatement.setString(2,portionSize);
			
			flag = preparedStatement.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int UpdateTotalStock(String productName,String selectedPortionSize,int TOTAL_STOCK) {
		int flag=1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addToatlStockQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,TOTAL_STOCK);
			preparedStatement.setString(2,productName);
			preparedStatement.setString(3,selectedPortionSize);
			
			flag = preparedStatement.executeUpdate();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public int UpdateMRP(String productName,String selectedPortionSize,int MRP) {
		int flag=1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.modifyPriceQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,MRP);
			preparedStatement.setString(2,productName);
			preparedStatement.setString(3,selectedPortionSize);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
public int UpdateDiscount(String productName,String selectedPortionSize,int discount) {
		int flag =1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.modifyDiscountQuery;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1,discount);
			preparedStatement.setString(2,productName);
			preparedStatement.setString(3,selectedPortionSize);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
public int[] fetchStatistics() {
	int arr[]= new int[12];
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.fetchTodayDataQuery;
		
		
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[0]=rs.getInt(1);
			arr[1]=rs.getInt(2);
			arr[2]=rs.getInt(3);
		}
		query = SqlQuery.fetchWeekDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[3]=rs.getInt(1);
			arr[4]=rs.getInt(2);
			arr[5]=rs.getInt(3);
		}
		
		query = SqlQuery.fetchHalfYearDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[6]=rs.getInt(1);
			arr[7]=rs.getInt(2);
			arr[8]=rs.getInt(3);
		}
		
		query = SqlQuery.fetchYearDataQuery;
		
		
		rs = stm.executeQuery(query);
		while(rs.next()) {
			arr[9]=rs.getInt(1);
			arr[10]=rs.getInt(2);
			arr[11]=rs.getInt(3);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return arr;
}
public String[] fetchProductDetails(String productName,String portionSize) {
	String []str= new String[6];
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.fetchProductDetailsQuery;
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,productName);
		preparedStatement.setString(2,portionSize);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			str[0]=Integer.toString(rs.getInt(1));
			str[1]=rs.getString(2);
			str[2]=rs.getString(3);
			str[3]=Integer.toString(rs.getInt(4));
			str[4]=Integer.toString(rs.getInt(5));
			str[5]=Integer.toString(rs.getInt(6));
		}
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return str;
}
public int updatePortionSize(String productName,String selectedPortionSize,String portionSize) {
	int flag =1;
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.modifyPortionSizeQuery;
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,portionSize);
		preparedStatement.setString(2,productName);
		preparedStatement.setString(3,selectedPortionSize);
		
		flag = preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return flag;
}
public int updateProductId(String productName,String selectedPortionSize,int productId) {
	int flag =1;
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.modifyItemIdQuery;
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setInt(1,productId);
		preparedStatement.setString(2,productName);
		preparedStatement.setString(3,selectedPortionSize);
		
		flag = preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return flag;
}
public void addCustomerDetails(String custFirstName,String custLastName,long custPhoneNo,int totalAmount,int totalDiscount,int amountAfterDiscount) {
	
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.addCustomerQuery;
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1,custFirstName);
		preparedStatement.setString(2,custLastName);
		preparedStatement.setLong(3,custPhoneNo);
		preparedStatement.setInt(4,totalAmount);
		preparedStatement.setInt(5,totalDiscount);
		preparedStatement.setInt(6,amountAfterDiscount);
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
}
	public Object [][] fethAllProductDetails() {
		Object [][] rec=null;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.fetchTotalProduct;
			

			ResultSet rs = stm.executeQuery(query);
			int count = 0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
			query = SqlQuery.fetchProductDetailsForOrderQuery;
			rs = stm.executeQuery(query);
			
			rec = new Object[count][5];
			int i=0;
			while(rs.next()) {
				
				rec[i][0] = rs.getString(2);
				rec[i][1] = rs.getString(3);
				rec[i][2] = Integer.toString(rs.getInt(4));
				rec[i][3] = Integer.toString(rs.getInt(5));
				rec[i][4] = Integer.toString(rs.getInt(6));
				i++;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return rec;
	}
	public Object [][] fethAllPurchasedDetails() {
		Object [][] rec=null;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.fetchtTotalPurchesedDetails;
			

			ResultSet rs = stm.executeQuery(query);
			int count = 0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
			query = SqlQuery.fetchPurchesedDetails;
			rs = stm.executeQuery(query);
			
			rec = new Object[count][5];
			int i=0;
			while(rs.next()) {
				rec[i][0] = rs.getString(1);
				rec[i][1] = rs.getString(2);
				rec[i][2] = Integer.toString(rs.getInt(3));
				rec[i][3] = Integer.toString(rs.getInt(4));
				rec[i][4] = Integer.toString(rs.getInt(5));
				i++;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return rec;
	}
	public void truncateTablePurchased() {
		
		String pass = null;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.deleteTableContentData;
			stm.execute(query);
			stm.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String[] fethAllAddProductDetails(String productName,String portionSize) {
	String []str= new String[5];
	try {
		Statement stm = conn.createStatement();
		
		String query = "use CMSData";
		stm.execute(query);
		
		
		query = SqlQuery.fetchStockDetailsWhereNameQtyQuery;
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,productName);
		preparedStatement.setString(2,portionSize);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			str[0]=rs.getString(2);
			str[1]=rs.getString(3);
			str[2]=Integer.toString(rs.getInt(4));
			str[3]=Integer.toString(rs.getInt(5));
			str[4]=Integer.toString(rs.getInt(6));
		}
		preparedStatement.close();
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return str;
	}
	public int AddPurchasedDetails(String name,String portionSize,int discount,int price,int qty){
		int flag =1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.addPurchasedData;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,portionSize);
			preparedStatement.setInt(3,discount);
			preparedStatement.setInt(4,price);
			preparedStatement.setInt(5,qty);
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	public int decrementQTY(String productName,String portionSize,int qty) {
		int flag =1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.decreaceQtyQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,qty);
			preparedStatement.setString(2,productName);
			preparedStatement.setString(3,portionSize);
			
			
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	public int CheckAvailableInStockOrNot(String productName,String portionSize) {
		int flag =0;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.checkAvailableInStock;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1,productName);
			preparedStatement.setString(2,portionSize);
			ResultSet rs =  preparedStatement.executeQuery();
			while(rs.next()) {
				flag = rs.getInt(1);
			}
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	public int checkAvailable(String productName,String portionSize) {
		int flag = 1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.checkAvailableInStock;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1,productName);
			preparedStatement.setString(2,portionSize);
			ResultSet rs =  preparedStatement.executeQuery();
			while(rs.next()) {
				flag = rs.getInt(1);
			}
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	public int checkProductIdPresent(int productId) {
		int flag = 1;
		try {
			Statement stm = conn.createStatement();
			
			String query = "use CMSData";
			stm.execute(query);
			
			
			query = SqlQuery.checkProductIdPresentQuery;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1,productId);
			
			ResultSet rs =  preparedStatement.executeQuery();
			while(rs.next()) {
				flag = rs.getInt(1);
			}
			preparedStatement.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
}

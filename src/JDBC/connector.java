package JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	public class connector {
	    public static void main(String[] args) {
	        try {
	        	
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmsdata", "root", "root123");
	            System.out.println(con);
	            
	        }
	        catch(Exception e){
	        	System.out.println("Error in connection");
	            e.printStackTrace();
	        }
	        System.out.println("Successfully connectedh");
	    }
	}


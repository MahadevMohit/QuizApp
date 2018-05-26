
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{ 
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		
	    static final String DB_URL = "jdbc:mysql://localhost:3306/quizapp?verifyServerCertificate=false&useSSL=true";

	    public static String success="database_cnt_error.Proceeding in Offline Mode";
	   
	    static final String USER = "" ;
	    static final String PASS = "";
	   
	    public static void main(String[] args) 
	    {
	    	Connection conn = null;
	    	try 
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		System.out.println("Connecting to database...");
	    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    		success="Connected to database successfully";
	    		System.out.println("Connected to database successfully...");	    	
                }
	    	catch(SQLException se)
	    	{
	    		se.printStackTrace();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	finally 
	    	{
	    		try  
	    		{
	    			if(conn!=null)
	    			conn.close(); 
	    		}
	    		catch(SQLException se)
	    		{
	    			se.printStackTrace();
	    		}
	    	}
	    }
}

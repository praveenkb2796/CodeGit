package jdbcconcheck;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdot.util.DbConnection;

public class Studentdatabase 
  {
	static Connection con=DbConnection.getConnection();
    static PreparedStatement pstmt=null;
       
	public static void main(String[] args) 
	  {
		
		 try
	     {
	con.setAutoCommit(false);
	pstmt=con.prepareStatement("INSERT INTO student(rno,name,gender,standard,sec,email,mobile,city) VALUES(?,?,?,?,?,?,?,?)");
	pstmt.setInt(1,2);
	pstmt.setString(2,"pavan");
	pstmt.setString(3,"m");
	pstmt.setInt(4,9);
	pstmt.setString(5,"B");
	pstmt.setString(6,"pavan123@gmail.com");
	pstmt.setString(7,"8095132395");
	pstmt.setString(8,"Mumbai");
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	System.out.println("Student details are successfuly regitered in database");
	     }
	 catch(SQLException e)
     {
    	e.printStackTrace();
    	System.out.println("Student details not regitered in database ");
     }  
	
		 //Student database mangement 
	System.out.println("This is Student database mangement");	 
	
	 //Student database mangement 
	System.out.println("This is Student database mangement");
	
	//Student database mangement 
		System.out.println("American Architect commit");
		
	
 } 

}	
		
		
		

	



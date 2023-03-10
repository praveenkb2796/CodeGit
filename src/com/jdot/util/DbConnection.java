package com.jdot.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
  {
   public static Connection getConnection()
	  {
		Connection con=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msql","root","root" );
	   
		}
		 catch(ClassNotFoundException cnfe)
	   {
	     cnfe.printStackTrace();
	    }

	    catch(SQLException sqle)
	    {
	     sqle.printStackTrace();
	     }
		return con;
	   }
	}




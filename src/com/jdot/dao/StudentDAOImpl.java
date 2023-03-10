package com.jdot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdot.util.DbConnection;

public class StudentDAOImpl implements StudentDAO
{
	   static Connection con=DbConnection.getConnection();
	   Statement stmt=null;
	   ResultSet rs=null;
	   PreparedStatement pstmt=null; 
	   Scanner in =new Scanner(System.in); 	
     
	   public void create(Student s)
	   {
		  
		 try
		     {
		pstmt=con.prepareStatement("INSERT INTO student(rno,name,gender,standard,sec,email,mobile,city) VALUES(?,?,?,?,?,?,?,?)");
		pstmt.setInt(1,s.getRollno());
		pstmt.setString(2,s.getName());
		pstmt.setString(3,s.getGender());
		pstmt.setInt(4,s.getStandard());
		pstmt.setString(5,s.getSec());
		pstmt.setString(6,s.getEmail());
		pstmt.setString(7,s.getMobile());
		pstmt.setString(8,s.getCity());
		pstmt.executeUpdate();
		System.out.println("Student details are successfuly regitered in database");
		pstmt.close();		
		    }
		 catch(SQLException e)
	     {
	    	e.printStackTrace();
	    	System.out.println("Student details not regitered in database ");
	     }   
	 } 

	   public Student getStudentById(int rno)
		{
	     
		   Student sid = null; 
		   
	     try
	     {
		
		pstmt=con.prepareStatement("SELECT * FROM student WHERE rno=?");
		pstmt.setInt(1,rno);
		rs=pstmt.executeQuery();
		
		
		while(rs.next())
		{
	
  sid=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			
		 }
		 pstmt.close();
		 
	   }
	     
	   catch(SQLException s)
	     {
	    	s.printStackTrace(); 
	     }   
	      
		return sid;
	 }
		
	   public List<Student> getStudents()
	    {
		   Student sid = null; 
		   List<Student> studentlist=new ArrayList<Student>();
		     try
		     {
			
			pstmt=con.prepareStatement("SELECT * FROM student ");
			rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
		
	  sid=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
	  studentlist.add(sid);	
            	
			 }
			 pstmt.close();
			 
		   }
		     
		   catch(SQLException s)
		     {
		    	s.printStackTrace(); 
		     }
		   return studentlist;

		  }
	   public void update(int rno,Student s)
	    {
		   Student upstu=null;
		   
		     try
		     {   
		    	 System.out.println("Enter the email id:");
		    	 String email=in.next();
		    	 System.out.println("Enter the mobile no:");
		    	 String mobile=in.next(); 
			    pstmt=con.prepareStatement("UPDATE student SET email=?,mobile=? WHERE rno=?");
		    	pstmt.setString(1,email);
		    	pstmt.setString(2,mobile);
		    	pstmt.setInt(3,rno);
		    	int count = pstmt.executeUpdate();
		    	
		    	pstmt=con.prepareStatement("SELECT * FROM student WHERE rno=? ");
		    	pstmt.setInt(1,rno);
				rs=pstmt.executeQuery();
				System.out.println("\n"+"The updated row is :"+count+"\n");
				System.out.println("The previous student details are :"+s);
				
				while(rs.next())
				{
upstu=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
		  	            	
				 }
		System.out.println("The updated student details are :"+upstu);
		pstmt.close();
			 
		   }
		     
		catch(SQLException e)
		     {
		    	e.printStackTrace(); 
		     }   
    	  }
	   
	   public void delete(int rno)
		{
		  try {
			  	pstmt=con.prepareStatement("DELETE FROM student WHERE rno=?");
		        pstmt.setInt(1,rno);
			    int delcount= pstmt.executeUpdate();
			    if(delcount>0)
			    {
			    	System.out.println("\n"+delcount+"  record is deleted Succesfully");
			    }
			    else
			    {
			    	System.out.println("\n"+delcount+"  record  not deleted ");
			    }
		      }
		  catch (SQLException e) 
		    {
				
				e.printStackTrace();
			}
		  }
	}
package com.jdot.dao;

import java.util.DuplicateFormatFlagsException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement 
 {
      static StudentDAOImpl sdb=new StudentDAOImpl();
   public static void process()
     {
	       Scanner in =new Scanner(System.in); 	    
		   int expression=0;
		   Student studetails=null;
		  List<Student> studentlist=null;

		    
			do
		    {
				System.out.println("1)Register Student");
				System.out.println("2)View Student By ID");
				System.out.println("3) View All Students");
				System.out.println("4) Update Student");
				System.out.println("5) Delete Student");
				System.out.println("6) Exit ");
				System.out.println("\n"+"Select any one :");
				 expression=in.nextInt();
								
				if((expression<1) || (expression>6) )
				{
					System.out.println("Invalid entry "+"\n");
					
				}
								
				switch(expression)
		        {
				  case 1 :
					  Student  studentObj=userInput();
			          sdb.create(studentObj);
			          System.out.println("Do you want to continue press 'y/n' ");
			          String select=in.next();
			        do
			        {	
			          if(select.equalsIgnoreCase("y"))
			          {
			        	 studentObj=userInput();
			        	 sdb.create(studentObj);
			        	 System.out.println("Do you want to continue press 'y/n' ");
			        	 select=in.next();
			          }
			          else
			          {
			        	  break;
			        	  
			          }
			        }
			      while(true);    
		            break;

				  case 2:
					 System.out.println("Enter the Rollno:");  
					 int rollno=in.nextInt();  
					   studetails = sdb.getStudentById(rollno);
					  System.out.println(studetails);
					  getById();
					   break;

				  case 3:
					   studentlist = sdb.getStudents();
					  System.out.println(studentlist+"\n");
		               break;

				  case 4:
					     System.out.println("Enter the Rollno:");  
						 int rno=in.nextInt(); 
						 studetails = sdb.getStudentById(rno);
				       sdb.update(rno,studetails); 
				       updrecall();
		               break;

		          case 5:
		        	  System.out.println("Enter the Rollno:");  
					  int delrno=in.nextInt(); 
				      sdb.delete(delrno);
				      delrecall();
		               break;

		         case 6:
		        	  System.out.println("\n"+"Select below options"+"\n");
		        	  break;  
		        } 
		    }while(true);
		 }
   
   public static Student userInput()
   {
	   Scanner in = new Scanner(System.in);
	   int rollno;
	   String name;
	   String gender;
	   int standard;
	   String sec;
	   String email;
	   String mobile;
	   String city;
	   System.out.println("Register student :");
       
    try {	
		System.out.println("Roll no:   " );
		rollno=in.nextInt();
        }
    catch(InputMismatchException ime )
    {
 	 System.out.println("Enter valid Rollno");
 	 System.out.println("Roll no:   " );
		 rollno=in.nextInt();
    }
    catch(DuplicateFormatFlagsException dke) 
    {
 	 System.out.println("Enter valid Rollno");
 	 System.out.println("Roll no:   " );
		 rollno=in.nextInt();
    }
    
    
		System.out.println("name:   " );
		name=in.nextLine();
		boolean verifyname = Pattern.matches("[a-zA-Z]+",name);      
        
		if(verifyname==false)
		{
		  System.out.println("Enter valid name");
		  System.out.println("name:   " );
		  name=in.nextLine();
		}
    
		System.out.println("gender:   " );	
		gender=in.next();
		boolean verifygender = Pattern.matches("[m,f,M,F]+",gender);
		
		if(verifygender==false)
		{
		  System.out.println("Enter valid gender");
		  System.out.println("gender:   " );
		  name=in.next();
		}
		
		System.out.println("standard:   " );
		standard=in.nextInt();
		 String stringstd = Integer.toString(standard);
		 
		 if(!Pattern.matches("^[1-12]+$",stringstd))
		  {
			 System.out.println("Enter valid Standard ");
			 System.out.println("standard:   " );
			 standard=in.nextInt();
			 
		  }
		
		System.out.println("sec:   " );		
		sec=in.next();
boolean verifysec = Pattern.matches("[a-zA-Z]+",sec);      
        
		if(!verifysec)
		{
		  System.out.println("Enter valid sec");
			System.out.println("sec:   " );		
			sec=in.next();
		}
		
				
		System.out.println("email:   " );
		email=in.next();
	String	emailregex= "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]*@"+"(?/:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	 Pattern pattern = Pattern.compile(emailregex);  
	if(!pattern.matcher(email).matches())
	{
		System.out.println("Enter valid email");
		System.out.println("email:   " );
		email=in.next();
	}	
		
		
		
	 
		System.out.println("mobile:   " );
		mobile=in.next();
		String mobregex="\\d{10}";
		if(!Pattern.matches(mobregex, mobile))
		{
			System.out.println("Enter valid mobile no");
			System.out.println("mobile:   " );
			mobile=in.next();
			
		}
		
	 	System.out.println("city:   " );	
	 	city=in.nextLine();
boolean verifycity= Pattern.matches("[a-zA-Z]+",city);      
        
		if(!verifycity)
		{
		  System.out.println("Enter valid City Name");
		  System.out.println("city:   " );
		  name=in.nextLine();
		}
    
	 	Student sobj=new Student(rollno,name,gender,standard,sec,email,mobile,city);
	 	System.out.println(sobj);
	 	return sobj;
   }
   
     static void getById()
     {
    	
    	Student sid1 = null;
    	Scanner in=new Scanner(System.in);
    	
		 do
	        {
			  System.out.println("Do you want to continue press 'y/n' ");
			  String option=in.next();
	          if(option.equalsIgnoreCase("y"))
	          {
	        	 System.out.println("Enter the Rollno:");  
				 int rollno=in.nextInt(); 
				 sid1 = sdb.getStudentById(rollno);
				 System.out.println(sid1);	        	 	        	 
	          }
	          else
	          {
	        	  return;
	        	  
	          }
	        }
	      while(true);
    	    	 
         }
     
     static void updrecall()
     {  
      	 Scanner in = new Scanner(System.in);
         do
	        {	
               
			  System.out.println("Do you want to continue press 'y/n' ");
			  String up=in.next();
	        
	          if(up.equalsIgnoreCase("y"))
	          {
	        	  System.out.println("Enter the Rollno:");  
				  int rno=in.nextInt(); 
				  Student studetails = sdb.getStudentById(rno);
			      sdb.update(rno,studetails);
	        		        	 
	          }
	          else
	          {
	        	  break;
	        	  
	          }
	        }while(true);  
         }
     
     static void delrecall()
     {  
      	 Scanner in = new Scanner(System.in);
         do
	        {	
               
			  System.out.println("Do you want to continue press 'y/n' ");
			  String del=in.next();
	        
	          if(del.equalsIgnoreCase("y"))
	          {
	        	  System.out.println("Enter the Rollno:");  
				  int delrno=in.nextInt(); 
				  sdb.delete(delrno); 
			            		        	 
	          }
	          else
	          {
	        	  break;
	        	  
	          }
	        }while(true);  
         }
      }
		
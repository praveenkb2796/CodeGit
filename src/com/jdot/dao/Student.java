/*Using Setters and getters methods to initialize the student class data members      */

package com.jdot.dao;


public class Student 
 {
	private int rollno;
	private String name;
	private String  gender;
	private int standard;
	private String  sec;
	private String email;
	private String mobile;
	private String city;

		
	Student(int rollno,String name,String  gender,int standard,String  sec,String email,String mobile,String city)
		{
			this.rollno=rollno;
	        this.name=name;
	        this.gender=gender;
			this.standard=standard;
			this.sec=sec;
			this.email=email;
			this.mobile=mobile;
			this.city=city;
		 }
	
	

	public void setRollno(int rollno) 
	 {
		this.rollno=rollno; 
	 }

	public void  setName(String name) 
	{ 
		this.name=name;
	}

	public void setGender(String gender) 
	{  
		this.gender=gender; 
	}

	public void setStandard(int standard) 
	{ 
		this.standard=standard; 
	}

	public void setSec(String sec) 
	{ 
		this.sec=sec; 
	}

	public void setEmail(String email) 
	{
		this.email=email; 
	}

	public void setMobile(String mobile) 
	{ 
		this.mobile=mobile; 
	}

	public void setCity(String city) 
	{ 
		this.city=city; 
	}
	

		
public int getRollno() 
{ 
	return rollno; 
}

public String getName() 
{ 
	return name;
}

public String getGender()
{ 
	return gender;
}

public int getStandard()
{ 
	return standard;
}

public String getSec()
{ 
	return sec; 
}

public String getEmail()
{ 
	return email; 
}

public String getMobile()
{ 
	return mobile;
}

public String getCity()
{ 
	return city; 
}


@Override
public String toString() 
 {
	return "Student [rollno=" + rollno + "\n"+
					"name=" + name + "\n"+ 
					"gender=" + gender +"\n"+ 
					"standard=" + standard +"\n"+
					"sec=" + sec + "\n"+ 
					"email=" + email + "\n"+
					"mobile=" + mobile + "\n"+
					"city=" + city +"]"+"\n\n";
 }

}
		



package com.jdot.dao;

import java.util.List;

public interface StudentDAO
  {
	   public void create(Student s);
	   public Student getStudentById(int rno);
	   public List<Student> getStudents();
	   public void update(int rno,Student s);
	   public void delete(int rno);
	}
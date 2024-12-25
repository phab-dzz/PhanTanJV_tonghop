/*
 * @ (#) Main.java	1.0	Apr 1, 2024
 * 
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import java.util.List;

import dao.CourseDAO;
import dao.StudentDAO;
import dao.impl.CourseImpl;
import dao.impl.StudentImpl;
import entity.Course;
import entity.OnlineCourse;

public class Main {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
//		EntityManager em = emf.createEntityManager();
//		
//		EntityTransaction tx = em.getTransaction();
//		
//		tx.begin();
//		tx.commit();
		
		CourseDAO courseDAO = new CourseImpl();
		StudentDAO studentDAO = new StudentImpl();
//		List<Course> courses = courseDAO.findBytitle("ph");
//		courses.forEach(x -> System.out.println(x));
		
//		Course course = courseDAO.findBytitle2("Physics");
//		System.out.println(course);
		Course c= new OnlineCourse("Lập trình java",20, "w3school.com");
		if(courseDAO.add(c))
			System.out.println("Them Course thanh cong.");
		else
			System.out.println("That bai!");
		
//		studentDAO.findStudentsEnrolledInCourse("po").forEach(x -> System.out.println(x));
//		studentDAO.findStudentsEnrolledInYear(2005).forEach(x -> System.out.println(x));
	}
}

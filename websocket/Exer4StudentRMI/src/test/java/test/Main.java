/*
 * @ (#) Main.java	1.0	Apr 1, 2024
 * 
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import java.rmi.RemoteException;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) throws RemoteException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mariadb");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		tx.commit();
		em.close();
//		
//		CourseDAO courseDAO = new CourseImpl();
//		StudentDAO studentDAO = new StudentImpl();
//		DepartmentDAO departmentDAO = new DepartmentImpl();
////		
//		departmentDAO.findDepartmentNotOwnerCourse().forEach(x -> System.out.println(x));
//		
//		studentDAO.findStudentMaxGPAs(2003)
//		.entrySet()
//		.forEach(entry -> {
//			System.out.println("Student: " + entry.getKey());
//			System.out.println("GPA: " + entry.getValue());
//		});
		
//		List<Course> courses = courseDAO.findBytitle("ph");
//		courses.forEach(x -> System.out.println(x));
		
//		Course course = courseDAO.findBytitle2("Physics");
//		System.out.println(course);
		
//		studentDAO.findStudentsEnrolledInCourse("po").forEach(x -> System.out.println(x));
//		studentDAO.findStudentsEnrolledInYear(2005).forEach(x -> System.out.println(x));
	}
}

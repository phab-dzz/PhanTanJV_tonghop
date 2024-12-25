package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import dao.StudentDAO;
import dao.impl.StudentImpl;
import entity.Student;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.RemoteException;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Studenttest {
	private StudentDAO studo;
	private EntityManager em;
	
	@BeforeAll
	void setup() throws RemoteException {
		studo = new StudentImpl();
		em = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
	}
//	private EntityManager em;
//	
//	public EntityManagerFactory  entityManagerFactory() {
//        return Persistence.createEntityManagerFactory("jpa-mssql");
//    }
//	
//	@Test
//	void testAddStudent() {
//        doInJPA(this::entityManagerFactory, entityManager -> {
//            Student student = new Student("phan", "duong",LocalDate.of(2000, 1, 1));
//            entityManager.persist(student); // Create
//        });
//	}
	@Test
	void testAddstudent() throws RemoteException {
		Student student = new Student("hau", "duong", LocalDate.of(2000, 1, 1));
		studo.add(student);
		Student stu=em.find(Student.class, student.getId());
		assertNotNull(stu);
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-mssql");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		Student student = new Student("phan", "duong", LocalDate.of(2000, 1, 1));
//		entityManager.persist(student);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		entityManagerFactory.close();
		
	}
	@AfterAll
	void tearDown() {
		studo = null;
		
		em.close();
	}

	
	

}

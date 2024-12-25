package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Testmain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mariadb");
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction tx = em.getTransaction();
	
	tx.begin();
	tx.commit();
	em.close();
}
}

package dao.impl;

import java.util.List;

import dao.CourseDAO;
import entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;

public class CourseImpl implements CourseDAO{
	
	private EntityManager em;
	
	public CourseImpl() {
		em = Persistence.createEntityManagerFactory("jpa-mssql")
				.createEntityManager();
	}
//	@NamedQueries({ //JPQL
//        @NamedQuery(name = "Course.findAll", query = "select c from Course c"),
//        @NamedQuery(name = "Course.findByTitle", query = "select c from Course c where c.title like :title"),
//        @NamedQuery(name = "Course.existsById", query = "select (count(c) > 0) from Course c where c.id = :id"),
//        @NamedQuery(name="Course.findCoursesWithMaxCredits", query = "select c from Course c where c.credits = (select max(credits) from Course)")
//})

	@Override
	public boolean add(Course course) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.persist(course);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Course course) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.merge(course);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Course course = em.find(Course.class, id);
			em.remove(course);
			
			tx.commit();
			
			return true;
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		return em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<Course> findBytitle(String title) {
		return em.createNamedQuery("Course.findByTitle", Course.class)
				.setParameter("title", "%"+title+"%")
				.getResultList();
	}

	@Override
	public Course findBytitle2(String title) {
		return em.createQuery("select c from Course c where c.title = :title", Course.class)
				.setParameter("title", title)
//				.getSingleResult();
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

}

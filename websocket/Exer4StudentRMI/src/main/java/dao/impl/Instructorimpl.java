package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.InstructorDAO;
import entity.Instructor;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Instructorimpl extends UnicastRemoteObject implements InstructorDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6102882217158298576L;
private EntityManager em;
	
	 public Instructorimpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("jpa-mssql")
				.createEntityManager();
	}
//	@Override
//	public boolean updatIns(int id, String firstname) throws RemoteException {
//		EntityTransaction tx = em.getTransaction();
//		try {
//			
//			tx.begin();
//			em.createQuery("update Instructor i set i.firstName=:name where i.id =:id",Instructor.class)
//			.setParameter("id",id)
//			.setParameter("name", firstname)
//			.executeUpdate();
//		
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exceptio
//		return false;
//		}


//	public static void main(String[] args) throws RemoteException {
//		Instructorimpl dao = new Instructorimpl();
//		
//		boolean b=dao.updatIns(4, "hau");
//		if(b)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//	}
	@Override
	public boolean updatIns(int id, String firstname) throws RemoteException {
		 EntityTransaction tx = em.getTransaction();
	     try {
	         tx.begin();
	         em.createQuery("UPDATE Instructor i SET i.firstName = :name WHERE i.id = :id")
	           .setParameter("id", id)
	           .setParameter("name", firstname)
	           .executeUpdate();
	         tx.commit();
	         return true;
	     } catch (Exception e) {
	         if (tx != null && tx.isActive()) {
	             tx.rollback();
	         }
	         e.printStackTrace(); // In ra lỗi để kiểm tra và sửa đổi nếu cần thiết
	         return false;
	     }
	}


	@Override
	public Map<Integer, String> findIns() throws RemoteException {
Map<Integer, String> map = new LinkedHashMap<>();
//		
//		String query = "SELECT s.id, AVG(sg.grade) as avg "
//				+ "FROM Student s Inner JOIN s.studentGrades sg "
//				+ "where year(enrollmentDate) =: year "
//				+ "GROUP BY s.id "
//				+ "order by avg desc"
String query="select s.id,s.firstName\r\n"
		+ "from Instructor s \r\n"
		+ "where s.lastName like '%a%'";
		List<?> list = em.createQuery(query)
				
				.getResultList();
		
		list.stream()
		.map(o -> (Object[])o)
		.forEach(a -> {
			int studentID = (int)a[0];
		String avg = (String) a[1];
//			Student student = em.find(Student.class, studentID);
			
			map.put(studentID, avg);
		});
		
		return map;
	}
	public static void main(String[] args) throws RemoteException {
		Instructorimpl dao = new Instructorimpl();
		
//		boolean b=dao.updatIns(4, "hau");
//		if(b)
//			System.out.println("success");
//		else
//			System.out.println("fail");
//		dao.findIns().entrySet()
//		.forEach(entry->{
//		System.out.println("Id :"+entry.getKey());
//		System.out.println("firstName"+entry.getValue());
		dao.findIns(System.out::println);
	

}}

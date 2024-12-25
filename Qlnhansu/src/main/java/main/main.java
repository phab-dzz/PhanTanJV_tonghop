package main;

import java.rmi.RemoteException;

import DAO.PositionDAO;
import DAO.Impl.CandidateImpl;
import DAO.Impl.PositionImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class main {
	public static void main(String[] args) throws RemoteException {
//		EntityManager entityManager = Persistence.createEntityManagerFactory("Qlnhansu").createEntityManager();
//		
//		entityManager.close();
		
		PositionDAO positionDAO = new PositionImpl();
		
//		positionDAO.listPosition("phan", 2, 5).forEach(p -> {
//			System.out.println(p);
//		});
		CandidateImpl candao= new CandidateImpl();
		candao.ListAllSkill().forEach(p -> {
			System.out.println(p);
		});
		candao.listCandidateByCompanies().entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
//			entry.getValue().forEach(System.
		});
	}

}

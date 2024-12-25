package dao.test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.PositionDAO;
import DAO.Impl.CandidateImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Positontest {
	private EntityManager em;
	private PositionDAO positionDAO;
	private CandidateImpl candao;
	@Before
	void setUp() throws RemoteException {
		candao= new CandidateImpl();
        em = Persistence.createEntityManagerFactory("Qlnhansu").createEntityManager();
	}
	@Test
	void testListPosition() throws RemoteException {
		candao.ListAllSkill().forEach(p -> {
			System.out.println(p);
		});
		assertEquals(7, candao.ListAllSkill().size());
	}
	
	@After
	void tearDown() {
		
		candao = null;
		em.close();
	}
	

}

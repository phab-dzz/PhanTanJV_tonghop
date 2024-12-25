package DAO.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.CandidateDAO;
import entity.Candidate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CandidateImpl extends UnicastRemoteObject implements CandidateDAO  {
	
	private EntityManager em;

	public CandidateImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("Qlnhansu").createEntityManager();
	}

//	@Override
//	public Map<Candidate, Long> listCandidateByCompanies() throws RemoteException {
//	 Map<Candidate, Long> result = null;
//	   String Query = "SELECT DISTINCT c.id, COUNT( e.companyName)" +
//               "FROM Candidate c " +
//               "JOIN c.experiences e " +
//               "GROUP BY c.id";
//	   
//	   List<?> resultList = em.createQuery(Query).getResultList();
//	   resultList.stream()
//	   .map(o -> (Object[]) o)
//	   .forEach(a ->{
//		   String id = (String) a[0];
//		   Long count = (Long) a[1];
//		   Candidate c = em.find(Candidate.class, id);
//		   result.put(c, count);
//	   });
//	   return result;
//	}
	@Override
	public Map<Candidate, Long> listCandidateByCompanies() throws RemoteException {
	    Map<Candidate, Long> result = new HashMap<>();
	    String query = "SELECT c, COUNT(e.companyName) " +
	                   "FROM Candidate c " +
	                   "JOIN c.experiences e " +
	                   "GROUP BY c";

	    List<Object[]> resultList = em.createQuery(query).getResultList();
	    resultList.stream()
	    .map(o -> (Object[]) o)
	    .forEach(a -> {
	        Candidate candidate = (Candidate) a[0];
	        Long count = (Long) a[1];
	        result.put(candidate, count);
	    });
	    return result;
	}


	@Override
	public Map<Candidate, Position> listCandidatesWithLongestWorking() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> ListAllSkill() throws RemoteException {
	return em.createQuery("SELECT DISTINCT s.id from Candidate s",String.class).getResultList();
    }
	}



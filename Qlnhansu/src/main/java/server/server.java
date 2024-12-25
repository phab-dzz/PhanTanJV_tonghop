package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import DAO.CandidateDAO;
import DAO.PositionDAO;
import DAO.Impl.CandidateImpl;
import DAO.Impl.PositionImpl;

public class server {
	private static final String url = "rmi://WINDOWS-10:7878/";
	
	public static void main(String[] args) throws NamingException {
		
		
		try {
			Context context = new InitialContext();
			CandidateDAO candidateDAO = new CandidateImpl();
			PositionDAO positionDAO = new PositionImpl();
			
			LocateRegistry.createRegistry(7878);
			context.bind(url + "candidateDAO", candidateDAO);
			context.bind(url + "positionDAO", positionDAO);
			
			System.out.println("Server is running...");
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

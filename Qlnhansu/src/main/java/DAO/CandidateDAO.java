package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.Candidate;
import entity.Position;

public interface CandidateDAO  extends Remote{
	public Map<Candidate,Long> listCandidateByCompanies() throws RemoteException;
	public List<String> ListAllSkill() throws RemoteException;
	public Map<Candidate,Position> listCandidatesWithLongestWorking() throws RemoteException;

}

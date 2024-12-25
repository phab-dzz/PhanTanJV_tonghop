package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import entity.Student;

public interface InstructorDAO extends Remote{
	
	public boolean updatIns(int id, String firstname) throws RemoteException;
	public Map<Integer ,String> findIns() throws RemoteException;
}

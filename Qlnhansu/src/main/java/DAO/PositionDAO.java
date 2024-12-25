package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entity.Position;

public interface PositionDAO  extends Remote{
	
	public  List<Position> listPosition(String name, double salaryFrom,double  salaryTo) throws RemoteException;
	

}

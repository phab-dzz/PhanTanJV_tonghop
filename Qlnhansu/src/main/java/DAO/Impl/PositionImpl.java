package DAO.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DAO.PositionDAO;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PositionImpl extends UnicastRemoteObject implements PositionDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3422118138202745221L;
	private EntityManager emf;

	public PositionImpl() throws RemoteException {
		emf = Persistence.createEntityManagerFactory("Qlnhansu").createEntityManager();
	}

	@Override
	public List<Position> listPosition(String name, double salaryFrom, double salaryTo) throws RemoteException {
		return  emf.createQuery(
				"SELECT p FROM Position p WHERE p.name LIKE :name AND p.salary >= :salaryFrom AND p.salary <= :salaryTo")
				.setParameter("name", "%" + name + "%").setParameter("salaryFrom", salaryFrom)
				.setParameter("salaryTo", salaryTo).getResultList();
	}

	
	
	

}

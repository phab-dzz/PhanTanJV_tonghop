package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.CourseDAO;
import dao.DepartmentDAO;
import dao.StudentDAO;
import dao.impl.CourseImpl;
import dao.impl.DepartmentImpl;
import dao.impl.StudentImpl;

public class servertemp {
	private static final String Url="rmi://WINDOWS-10:/7878/";
	public static void main(String[] args) {
		
		try {
			Context con= new InitialContext();
			CourseDAO CourseDAO= new CourseImpl();
			StudentDAO StudentDAO= new StudentImpl();
			DepartmentDAO departDAO= new DepartmentImpl();
			
			LocateRegistry.createRegistry(7878);
			con.bind(Url+"departDAO",departDAO);
			con.bind(Url + "CourseDAO", CourseDAO);
			con.bind(Url + "StudentDAO", StudentDAO);
			
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

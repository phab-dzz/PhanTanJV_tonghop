package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import dao.StudentDAO;
import dao.impl.StudentImpl;
import entity.Student;

public class Server1 {

		public static void main(String[] args) throws IOException {
			try(ServerSocket  server= new ServerSocket(7878)){
				System.out.println("Server is listening on port 7878");
				
				while(true) {
					Socket socket=server.accept();
					System.out.println("Client connected");
					System.out.println("Client address:"+socket.getInetAddress().getHostName());
					
					Thread t = new Thread(new ClientHandler1(socket));
							t.start();
					
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
}
class ClientHandler1 implements Runnable{
	private Socket socket;
	private StudentDAO studentDAO;
	public ClientHandler1(Socket socket) {
		super();
		this.socket=socket;
		studentDAO= new StudentImpl();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			int choice=0;
			List<Student> students;
			while(true) {
				choice=in.readInt();
				switch (choice) {
				case 1: 
					String title=in.readUTF();
					students=studentDAO.findStudentsEnrolledInCourse(title);
					out.writeObject(students);
					break;
					
				
				case 2:
					int year=in.readInt();
					System.out.println("Year :"+year);
					students= studentDAO.findStudentsEnrolledInYear(year);
					
					students.forEach(System.out::println);
					out.writeObject(students);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + true);
				
			}
		}
		
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}


package Logico;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;


public class Flujo extends Thread{
	private static Socket cliente;
	private static DataInputStream entradadatos;
	private static DataOutputStream salidadatos;
	
	public Flujo(Socket socket) {
		cliente = socket;
		
		try {
			entradadatos = new DataInputStream(cliente.getInputStream());
			salidadatos = new DataOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException(Flujo): " + e);
		}
		
	}
	
	public void run() {
		
		while (true) {
			try {
				String username = entradadatos.readUTF();
				String password = entradadatos.readUTF();
				if (Aplicacion.getInstance().confirmLogin(username, password)) {
					salidadatos.writeBoolean(true);
				} else {
					salidadatos.writeBoolean(false);
				}
				salidadatos.flush();	
			} catch (EOFException e) {
				System.out.println("Informacion procesada y enviada correctamente");
				break;
			} catch (IOException ioe) {
				System.out.println("Error(Run): " + ioe );
				break;
			}
		}
		try {
			entradadatos.close();
			salidadatos.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

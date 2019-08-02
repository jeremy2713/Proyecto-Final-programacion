package Logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{

	private static ServerSocket servidor;
	private static Socket cliente;
	private static Flujo flujo;
	private static Thread hilo;

	public static void main(String[] args){
		loadArchivo();
		
		try {
			servidor = new ServerSocket(7000);
		} catch (IOException e) {
			System.out.println("Error al intentar abrir el socket del servidor:" + e);
			System.exit(-1);
		}

		

			try {
				cliente = servidor.accept();
				System.out.println("El cliente:" + cliente.getInetAddress() + " se a conectado correctamente por el puerto:" + cliente.getPort());
				System.out.println("Procesando informacion...");
				flujo = new Flujo(cliente);
				hilo = new Thread(flujo);
				hilo.start();
			} catch (IOException e) {
				System.out.println("Se a producido un error:" + e);
				e.printStackTrace();
			}
		

	}

	private static void loadArchivo() {
		System.out.println("Iniciando sistema...");

		try {	//se intenta leer el archivo usuarios.dat
			File archivo = new File("electronica.dat");
			FileInputStream userBin = new FileInputStream(archivo);
			ObjectInputStream user = new ObjectInputStream(userBin);
			System.out.println("Cargando informacion de usuario...");
			
			user.close();
			userBin.close();
		} catch (FileNotFoundException e2) {
			try {
				File archivo = new File("electronica.dat");
				FileOutputStream userBin = new FileOutputStream(archivo);
				ObjectOutputStream user = new ObjectOutputStream(userBin);
				System.out.println("Creando archivos y usuario por defecto...");
				User usuario = new User("administrador", "Admin", "Admin");
				Aplicacion.getInstance().regUser(usuario);
				user.writeObject(Aplicacion.getInstance()); 
				user.close();
				userBin.close();
			} catch (FileNotFoundException e1) {} catch (IOException e1) {}
		} catch (IOException e) {};
	}
}















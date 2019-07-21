package Logico;

public class Registrarusuario {

	private String contrasena;
	private String username;
	public Registrarusuario() {
		
		
	}
	public Registrarusuario(String contrasena, String username) {
		super();
		this.contrasena = contrasena;
		this.username = username;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}

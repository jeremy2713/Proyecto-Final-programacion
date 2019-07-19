package Logico;

public class Registrocliente extends Cliente {

	private int fechanacimiento;
	private String contrasena;
	
	public Registrocliente(String nombre, String codigo, float credito, String direccion, String contrasena,int fechanacimiento) {
		super(nombre, codigo, credito, direccion);
		
		this.fechanacimiento=fechanacimiento;
		this.contrasena=contrasena;
	
		
	}
	

	public int getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(int fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}


public class Cliente {
	String nombre;
	String codigo;
	Float credito;
	String direccion;
	
	public Cliente(String nombre, String codigo, Float credito, String direccion) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.credito = credito;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Float getCredito() {
		return credito;
	}

	public void setCredito(Float credito) {
		this.credito = credito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

	
}

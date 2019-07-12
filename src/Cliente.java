
public class Cliente {
	
	private String nombre;
	private String codigo;
	private float credito;
	private String direccion;
	
	public Cliente(String nombre, String codigo, float credito, String direccion) {
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

	public float getCredito() {
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

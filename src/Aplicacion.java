import java.util.ArrayList;

public class Aplicacion {
	private static Aplicacion aplicacion=null;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Componente> componentes;
	
	public Aplicacion(ArrayList<Cliente> clientes, ArrayList<Factura> facturas, ArrayList<Componente> componentes) {
		super();
		this.clientes = new ArrayList<>();
		this.facturas = new ArrayList<>();
		this.componentes = new ArrayList<>();
	}

	public static Aplicacion getAplicacion() {
		return aplicacion;
	}

	public static void setAplicacion(Aplicacion aplicacion) {
		Aplicacion.aplicacion = aplicacion;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	
	
	

}

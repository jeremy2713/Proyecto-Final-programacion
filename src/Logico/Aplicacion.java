package Logico;
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

	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente BuscarClientePorCodigo(String codigo) {
		Cliente client = null;
		int i = 0;
		while(i < clientes.size()) {
			if(clientes.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				client = clientes.get(i);
				break;
			}
			i++;
		}
		return client;
			
	}
	public Factura BuscarFacturaPorCodigo(String codigo) {
		Factura factura = null;
		int i = 0;
		while(i < facturas.size()) {
			if(facturas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				factura = facturas.get(i);
				break;
			}
			i++;
		}
		return factura;
			
	}
	
	public ArrayList<Factura> BuscarFacturaByCliente(String codigo) {
    	ArrayList<Factura> lasFacturas= new ArrayList();
    	for (Factura aux : facturas) {
			if (aux.getElcliente().getCodigo().equalsIgnoreCase(codigo)){
				lasFacturas.add(aux);
			}
		}
    	return lasFacturas;
    }
	
	public Componente BuscarComponentePorCodigo(String codigo) {
		Componente component = null;
		int i = 0;
		while(i < componentes.size()) {
			if(componentes.get(i).getBarcode().equalsIgnoreCase(codigo)) {
				component = componentes.get(i);
				break;
			}
			i++;
		}
		return component;
			
	}
	
	
	
	

}

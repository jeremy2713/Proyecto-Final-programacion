package Logico;
import java.util.ArrayList;



public class Aplicacion {
	private static Aplicacion aplicacion=null;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Componente> componentes;
	private ArrayList<Combo> combos;
	private static Aplicacion miAplicacion;
//////////////////////////////////////////////////////////////////
/////Aqui empiezan las variables para el login//////
	private ArrayList<User> misUsers;
	private static User loginUser;
	private static boolean firstTime;
///////////////////////////////////////////////////////////////////	
	private Aplicacion() {
		super();
		this.clientes = new ArrayList<>();
		this.facturas = new ArrayList<>();
		this.componentes = new ArrayList<>();
		this.combos = new ArrayList<>();
		this.misUsers= new ArrayList<User>();
	}
	public static Aplicacion getInstance() {
		if(miAplicacion == null) {
			miAplicacion = new Aplicacion();
		}
		return miAplicacion;
	}
	public static void setInstance(Aplicacion aplicacion) {
		if(miAplicacion == null) {
			miAplicacion = aplicacion;
		}
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void agregarCombo(Combo combo) {
		combos.add(combo);
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
	
	public Cliente buscarClientePorCodigo(String codigo) {
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
	public Factura buscarFacturaPorCodigo(String codigo) {
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
	
	public ArrayList<Factura> buscarFacturasByCliente(String codigo) {
    	ArrayList<Factura> facturas= null;
    	for(Cliente aux : clientes) {
    		if(aux.getCodigo().equalsIgnoreCase(codigo)) {
    			facturas = aux.getFacturas();
    			break;
    		}
    	}
    	return facturas;
    }
	
	public Componente buscarComponentePorCodigo(String codigo) {
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
	public Combo buscarComboPorCodigo(String codigo) {
		Combo combo = null;
		int i = 0;
		while(i < combos.size()) {
			if(combos.get(i).getCodigoCombo().equalsIgnoreCase(codigo)) {
				combo = combos.get(i);
				break;
			}
			i++;
		}
		
		return combo;
	}
	//////////////////////////////////////////////////////////////////////////
	//aqui empieza las funciones para el login del usuario ///
	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Aplicacion.loginUser = loginUser;
	}

	public void regUser(User user) {/////metodo para anadir usuario
		misUsers.add(user);
		
	}

	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (User user : misUsers) {
			if(user.getUserName().equals(text)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	
	

}

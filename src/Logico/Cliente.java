package Logico;

import java.util.ArrayList;

public class Cliente {
	
	protected String nombre;
	protected String codigo;
	protected float credito;
	protected String direccion;
	protected ArrayList<Factura> facturas;
	
	public Cliente(String nombre, String codigo, float credito, String direccion) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.credito = credito;
		this.direccion = direccion;
		this.facturas = new ArrayList<>();
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
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	
	

	
}

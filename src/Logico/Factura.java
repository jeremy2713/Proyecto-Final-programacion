package Logico;
import java.util.ArrayList;

public class Factura {
	private String codigo;
	private float preciototal;
	private ArrayList<Componente> miscomponentes;
	private Cliente elcliente;
	
	public Factura(String codigo, float preciototal, ArrayList<Componente> miscomponentes, Cliente elcliente) {
		super();
		this.codigo = codigo;
		this.preciototal = preciototal;
		this.miscomponentes = miscomponentes;
		this.elcliente = elcliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}

	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}

	public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
		this.miscomponentes = miscomponentes;
	}

	public Cliente getElcliente() {
		return elcliente;
	}

	public void setElcliente(Cliente elcliente) {
		this.elcliente = elcliente;
	}
	
	
	
	
}

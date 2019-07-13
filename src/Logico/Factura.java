package Logico;
import java.util.ArrayList;

public class Factura {
	private String codigo;
	private float preciototal;
	private ArrayList<Componente> miscomponentes;
	private Cliente elcliente;
	private Float creditorestente;//cuando el cliente compre algo en esta variable sale el credito que le queda
	
	public Factura(String codigo, float preciototal, ArrayList<Componente> miscomponentes, Cliente elcliente,
			Float creditorestente) {
		super();
		this.codigo = codigo;
		this.preciototal = preciototal;
		this.miscomponentes = miscomponentes;
		this.elcliente = elcliente;
		this.creditorestente = creditorestente;
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

	public Float getCreditorestente() {
		return creditorestente;
	}

	public void setCreditorestente(Float creditorestente) {
		this.creditorestente = creditorestente;
	}
	

	
	
	
	
	
}

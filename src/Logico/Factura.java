package Logico;
import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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


	public float getPreciototal() {
		return preciototal;
	}


	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}

	public void agregarComponente(Componente componente) {
		miscomponentes.add(componente);
	}

	public Cliente getElcliente() {
		return elcliente;
	}

	public void setElcliente(Cliente elcliente) {
		this.elcliente = elcliente;
	}

	
}

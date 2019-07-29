package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Componente Componente = null;
	private String codigoCombo;
	private Memoriaram memoriaRAM;
	private Discoduro discoDuro;
	private Microprocesadores cpu;
	private Tarjetamadre motherBoard;
	private float precioTotal;
	private ArrayList<Componente>componente;

	public Combo(String codigoCombo,Memoriaram memoriaRAM, Discoduro discoDuro, Microprocesadores cpu, Tarjetamadre motherBoard) {
		this.codigoCombo = codigoCombo;
		this.memoriaRAM = memoriaRAM;
		this.discoDuro = discoDuro;
		this.cpu = cpu;
		this.motherBoard = motherBoard;
		precioTotal = (float) ((memoriaRAM.getPrecio() + discoDuro.getPrecio() + cpu.getPrecio() + motherBoard.getPrecio()) * 0.30);
	}
	public String getCodigoCombo() {
		return codigoCombo;
	}
	public Memoriaram getMemoriaRAM() {
		return memoriaRAM;
	}

	public Discoduro getDiscoDuro() {
		return discoDuro;
	}

	public Microprocesadores getCpu() {
		return cpu;
	}


	public Tarjetamadre getMotherBoard() {
		return motherBoard;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}
	public Combo(ArrayList<Componente> componente) {
		super();
		this.componente = componente;
	}
	public ArrayList<Componente> getComponente() {
		return componente;
	}
	public void agregarcomponente(ArrayList<Componente> componente) {
		this.componente.add(Componente);
	}



	
	
	

}

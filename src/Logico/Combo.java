package Logico;

import java.io.Serializable;

public class Combo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoCombo;
	private Memoriaram memoriaRAM;
	private Discoduro discoDuro;
	private Microprocesadores cpu;
	private Tarjetamadre motherBoard;
	private float precioTotal;

	public Combo(String codigoCombo,Memoriaram memoriaRAM, Discoduro discoDuro, Microprocesadores cpu, Tarjetamadre motherBoard) {
		this.codigoCombo = codigoCombo;
		this.memoriaRAM = memoriaRAM;
		this.discoDuro = discoDuro;
		this.cpu = cpu;
		this.motherBoard = motherBoard;
		precioTotal = (float) ((memoriaRAM.getPrecio() + discoDuro.getPrecio() + cpu.getPrecio() + motherBoard.getPrecio()) * 0.80);
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



	
	
	

}

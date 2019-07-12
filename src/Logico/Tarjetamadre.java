package Logico;

public class Tarjetamadre extends Componente {

	
	private String conectormicro;
	private String tiporam;
	private String conectordiscoduro;
	
	
	
	
	public Tarjetamadre(float precio, int cantidad_disponible, String barcode, String marca, String modelo, String conectormicro, String tiporam, String conectordiscoduro) {
		super(precio, cantidad_disponible, barcode, marca, modelo);
		this.conectormicro=conectormicro;
		this.tiporam=tiporam;
		this.conectordiscoduro=conectordiscoduro;
		
		// TODO Auto-generated constructor stub
	}

	public String getConectormicro() {
		return conectormicro;
	}

	public void setConectormicro(String conectormicro) {
		this.conectormicro = conectormicro;
	}

	public String getTiporam() {
		return tiporam;
	}

	public void setTiporam(String tiporam) {
		this.tiporam = tiporam;
	}

	public String getConectordiscoduro() {
		return conectordiscoduro;
	}

	public void setConectordiscoduro(String conectordiscoduro) {
		this.conectordiscoduro = conectordiscoduro;
	}

	
	
	
}

package Logico;

public class Combo_1 {
	private Memoriaram lamemoriaram;
	private Discoduro eldiscoduro;
	private Microprocesadores elmicro;
	private Tarjetamadre latarjetamadre;
	
	public Combo_1(Memoriaram lamemoriaram, Discoduro eldiscoduro, Microprocesadores elmicro,
			Tarjetamadre latarjetamadre) {
		super();
		this.lamemoriaram = lamemoriaram;
		this.eldiscoduro = eldiscoduro;
		this.elmicro = elmicro;
		this.latarjetamadre = latarjetamadre;
	}

	public Discoduro getEldiscoduro() {
		return eldiscoduro;
	}

	public void setEldiscoduro(Discoduro eldiscoduro) {
		this.eldiscoduro = eldiscoduro;
	}

	public Microprocesadores getElmicro() {
		return elmicro;
	}

	public void setElmicro(Microprocesadores elmicro) {
		this.elmicro = elmicro;
	}

	public Tarjetamadre getLatarjetamadre() {
		return latarjetamadre;
	}

	public void setLatarjetamadre(Tarjetamadre latarjetamadre) {
		this.latarjetamadre = latarjetamadre;
	}
	public Memoriaram getLamemoriaram() {
		return lamemoriaram;
	}
	public void setLamemoriaram(Memoriaram lamemoriaram) {
		this.lamemoriaram = lamemoriaram;
	}
	
	public float PrecioDelCombo_1(){
		float total=0;
		total=(float) ((lamemoriaram.getPrecio()+latarjetamadre.getPrecio()+eldiscoduro.getPrecio()+elmicro.getPrecio())*0.20);
		return total;
	}
	
	
	
	

}


public class Memoriaram extends Componente {

	private int cantmemoria;
	private String tipomemoria;
	
	public Memoriaram(float precio, int cantidad_disponible, String barcode, String marca, String modelo, int cantmemoria, String tipomemoria) {
		super(precio, cantidad_disponible, barcode, marca, modelo);
		this.cantmemoria=cantmemoria;
		this.tipomemoria=tipomemoria;
	}

	public int getCantmemoria() {
		return cantmemoria;
	}

	public void setCantmemoria(int cantmemoria) {
		this.cantmemoria = cantmemoria;
	}

	public String getTipomemoria() {
		return tipomemoria;
	}

	public void setTipomemoria(String tipomemoria) {
		this.tipomemoria = tipomemoria;
	}

	
	
}

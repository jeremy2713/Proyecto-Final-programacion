
public class Componente {
	protected float precio;
	protected int cantidad_disponible;
	//"barcode" es el que dice numero de serie
	protected String barcode;
	protected String marca;
	protected String modelo;
	
	public Componente(float precio, int cantidad_disponible, String barcode, String marca, String modelo) {
		super();
		this.precio = precio;
		this.cantidad_disponible = cantidad_disponible;
		this.barcode = barcode;
		this.marca = marca;
		this.modelo = modelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	

}

package Logico;

public class Discoduro extends Componente {

	
	private float almacenamiento;
	private String conexiondiscoduro;
	
	public Discoduro(float precio, int cantidad_disponible, String barcode, String marca, String modelo, float almacenamiento, String conexiondiscoduro) {
		super(precio, cantidad_disponible, barcode, marca, modelo);
		this.almacenamiento=almacenamiento;
		this.conexiondiscoduro=conexiondiscoduro;
	}

	public float getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(float almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getConexiondiscoduro() {
		return conexiondiscoduro;
	}

	public void setConexiondiscoduro(String conexiondiscoduro) {
		this.conexiondiscoduro = conexiondiscoduro;
	}

}

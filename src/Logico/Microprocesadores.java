package Logico;

public class Microprocesadores extends Componente {

private String tipoconexion;
private float velocidadprocesado;

	
	public Microprocesadores(float precio, int cantidad_disponible, String barcode, String marca, String modelo, String tipoconexion, float velocidadprocesado) {
		super(precio, cantidad_disponible, barcode, marca, modelo);
		this.tipoconexion=tipoconexion;
		this.velocidadprocesado=velocidadprocesado;
		
	}


	public String getTipoconexion() {
		return tipoconexion;
	}


	public void setTipoconexion(String tipoconexion) {
		this.tipoconexion = tipoconexion;
	}


	public float getVelocidadprocesado() {
		return velocidadprocesado;
	}


	public void setVelocidadprocesado(float velocidadprocesado) {
		this.velocidadprocesado = velocidadprocesado;
	}

	
	
}

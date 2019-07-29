package Logico;

public class Combocomponente {

	private int codigoCombo;
private Componente componente;

public Combocomponente(int codigoCombo, Componente componente) {
	super();
	this.codigoCombo = codigoCombo;
	this.componente = componente;
}

public int  getCodigoCombo() {
	return codigoCombo;
}

public void setCodigoCombo(int codigoCombo) {
	this.codigoCombo = codigoCombo;
}

public Componente getComponente() {
	return componente;
}

public void setComponente(Componente componente) {
	this.componente = componente;
}




}



package img;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fondologin extends JFrame {

	/**
	 * 
	 */
	ImageIcon imagen;
	String nombre;
	
	public Fondologin(String nombre) {
		this.nombre = nombre;
	}
	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height,null);
		super.paint(g);
	}

}

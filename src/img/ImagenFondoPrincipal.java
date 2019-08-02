package img;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenFondoPrincipal extends JPanel {

	ImageIcon imagenlogin;
	String nombre;
	
	public ImagenFondoPrincipal(String nombre) {
		this.nombre = nombre;
	}
	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagenlogin = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagenlogin.getImage(), 0, 0, tamanio.width, tamanio.height,null);
		setOpaque(false);
		super.paint(g);
	}

}

package gui;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabbedPane() {
		LekoviTab lekovi = new LekoviTab();
		this.addTab("", lekovi);
		ImageIcon image1 = new ImageIcon(getClass().getResource("/slike/01_lekovi.jpg"));
		this.setIconAt(0, image1);

		KorisniciTab korisnici = new KorisniciTab();
		this.addTab("", korisnici);
		ImageIcon image2 = new ImageIcon(getClass().getResource("/slike/03_korisnik.jpg"));
		this.setIconAt(1, image2);	
	}
}

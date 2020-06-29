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

		ReceptiTab recepti = new ReceptiTab();
		this.addTab("", recepti);
		ImageIcon image3 = new ImageIcon(getClass().getResource("/slike/02_recepti.jpg"));
		this.setIconAt(2, image3);
		
		ProdavnicaTab prodavnica = new ProdavnicaTab();
		this.addTab("", prodavnica);
		ImageIcon image4 = new ImageIcon(getClass().getResource("/slike/05_korpa.jpg"));
		this.setIconAt(3, image4);		
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ListaKorisnika;
import model.ListaLekova;
import model.ListaProdavnica;
import model.ListaRecepata;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		int screenHeight = 768;
		int screenWidth = 1024;
		setSize(screenWidth, screenHeight * 2 / 3);
		setTitle("NemaLekaApoteka");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// MenuBar menu = new MenuBar();
		// setJMenuBar(menu);

		// StatusBar st=new StatusBar();
		// getContentPane().add(st,BorderLayout.SOUTH);

		final TabbedPane tabbedPane = new TabbedPane();
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		final ToolBarLek lekToolbar = new ToolBarLek();
		getContentPane().add(lekToolbar, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lekToolbar.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));

		final ToolBarKorisnik korisnikToolbar = new ToolBarKorisnik();
		JLabel lblNewLabel2 = new JLabel("");
		korisnikToolbar.add(lblNewLabel2);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));

		final ToolBarRecept receptToolbar = new ToolBarRecept();
		JLabel lblNewLabel3 = new JLabel("");
		receptToolbar.add(lblNewLabel3);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel3.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));
		
		final ToolBarProdavnica prodavnicaToolbar = new ToolBarProdavnica();
		JLabel lblNewLabel4 = new JLabel("");
		prodavnicaToolbar.add(lblNewLabel4);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));		

		tabbedPane.addChangeListener(new ChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void stateChanged(ChangeEvent arg0) {

				// TODO Auto-generated method stub
				int i = tabbedPane.getSelectedIndex();

				Global.setVar(i);
				if (i == 0) {
					getContentPane().add(lekToolbar, BorderLayout.NORTH);
					lekToolbar.show();
					korisnikToolbar.hide();
					receptToolbar.hide();
					prodavnicaToolbar.hide();
				} else if (i == 1) {
					getContentPane().add(korisnikToolbar, BorderLayout.NORTH);
					lekToolbar.hide();
					korisnikToolbar.show();
					receptToolbar.hide();
					prodavnicaToolbar.hide();
				} else if (i == 2) {
					getContentPane().add(receptToolbar, BorderLayout.NORTH);
					lekToolbar.hide();
					korisnikToolbar.hide();
					receptToolbar.show();
					prodavnicaToolbar.hide();
				} else if (i == 3) {
					getContentPane().add(prodavnicaToolbar, BorderLayout.NORTH);
					lekToolbar.hide();
					korisnikToolbar.hide();
					receptToolbar.hide();
					prodavnicaToolbar.show();
				}
			}

		});
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				ListaLekova.getInstance().serijalizacijaLekova();
				ListaKorisnika.getInstance().serijalizacijaKorisnika();
				ListaRecepata.getInstance().serijalizacijaRecepta();
				try {
					ListaProdavnica.getInstance().serijalizacijaProdavnica();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				ListaLekova.getInstance().deserijalizacijaLekova();
				ListaRecepata.getInstance().deserijalizacijaRecepta();
				try {
					ListaProdavnica.getInstance().deserijalizacijaProdavnica();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Global.getGlobalTipKorisnika());
				if (Global.getGlobalTipKorisnika().equals("Administrator")) {
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setEnabledAt(1, true);
					tabbedPane.setEnabledAt(2, false);
					tabbedPane.setEnabledAt(3, true);
					tabbedPane.setSelectedIndex(1);
				} else {
					tabbedPane.setEnabledAt(1, false);
					tabbedPane.setEnabledAt(0, true);
					tabbedPane.setEnabledAt(2, true);
					tabbedPane.setEnabledAt(3, true);
					tabbedPane.setSelectedIndex(0);
				}

			}

		});

	}

}
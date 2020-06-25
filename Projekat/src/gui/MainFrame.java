package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ListaKorisnika;

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));

		final ToolBarKorisnik korisnikToolbar = new ToolBarKorisnik();
		JLabel lblNewLabel2 = new JLabel("");
		korisnikToolbar.add(lblNewLabel2);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));

		getContentPane().add(korisnikToolbar, BorderLayout.NORTH);
		korisnikToolbar.show();

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
				ListaKorisnika.getInstance().serijalizacijaKorisnika();
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
				System.out.println(Global.getGlobalTipKorisnika());
				if (Global.getGlobalTipKorisnika().equals("Administrator")) {
					tabbedPane.setEnabledAt(0, true);
					tabbedPane.setSelectedIndex(0);
				} else {
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setSelectedIndex(0);
				}

			}

		});

	}

}
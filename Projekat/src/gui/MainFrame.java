package gui;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.listaKorisnika;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		int screenHeight = 768;
		int screenWidth = 1024;
		setSize(screenWidth,screenHeight*2/3);
		setTitle("NemaLekaApoteka");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	
		final TabbedPane tabbedPane=new TabbedPane();
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setFont(new Font("Arial",Font.PLAIN,30));
		getContentPane().add(tabbedPane,BorderLayout.CENTER);
		
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));
	
		final ToolBarKorisnik  korisnikToolbar = new ToolBarKorisnik();
		JLabel lblNewLabel2 = new JLabel("");
		korisnikToolbar.add(lblNewLabel2);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setIcon(new ImageIcon(MainFrame.class.getResource("/slike/imelaLogo.jpg")));
		
		tabbedPane.addChangeListener(new ChangeListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				// TODO Auto-generated method stub
				int i=tabbedPane.getSelectedIndex();
				
				Global.setVar(i);
				if(i==0) {

					korisnikToolbar.hide();
				}else if(i==1) {
					getContentPane().add(korisnikToolbar, BorderLayout.NORTH);

					korisnikToolbar.show();
				}else {
		
				}
			
			}
			
			
		});

			
	}
	
	
}
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import model.Korisnik;
import model.ListaKorisnika;

public class DodajKorisnika extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField username;
	private JTextField password;
	private JTextField ime;
	private JTextField prezime;
	private String izabranTip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodajKorisnika dialog = new DodajKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DodajKorisnika() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 35, 62, 170, 30 };
		gbl_contentPanel.rowHeights = new int[] { 20, 30, 14, 14, 0, 0, 0, 0, 30, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(DodajKorisnika.class.getResource("/slike/imelaLogo.jpg")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Dodavanje korisnika");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("username");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			username = new JTextField();
			GridBagConstraints gbc_username = new GridBagConstraints();
			gbc_username.insets = new Insets(0, 0, 5, 5);
			gbc_username.fill = GridBagConstraints.HORIZONTAL;
			gbc_username.gridx = 2;
			gbc_username.gridy = 3;
			contentPanel.add(username, gbc_username);
			username.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("password");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			password = new JPasswordField();
			GridBagConstraints gbc_password = new GridBagConstraints();
			gbc_password.insets = new Insets(0, 0, 5, 5);
			gbc_password.fill = GridBagConstraints.HORIZONTAL;
			gbc_password.gridx = 2;
			gbc_password.gridy = 4;
			contentPanel.add(password, gbc_password);
			password.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Ime");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			ime = new JTextField();
			GridBagConstraints gbc_ime = new GridBagConstraints();
			gbc_ime.insets = new Insets(0, 0, 5, 5);
			gbc_ime.fill = GridBagConstraints.HORIZONTAL;
			gbc_ime.gridx = 2;
			gbc_ime.gridy = 5;
			contentPanel.add(ime, gbc_ime);
			ime.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Prezime");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			prezime = new JTextField();
			GridBagConstraints gbc_prezime = new GridBagConstraints();
			gbc_prezime.insets = new Insets(0, 0, 5, 5);
			gbc_prezime.fill = GridBagConstraints.HORIZONTAL;
			gbc_prezime.gridx = 2;
			gbc_prezime.gridy = 6;
			contentPanel.add(prezime, gbc_prezime);
			prezime.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Tip");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 7;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			JComboBox<String> tip = new JComboBox<String>();
			tip.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					izabranTip = (String) tip.getSelectedItem();
					// System.out.println("Izabran tip: " + izabranTip);
				}
			});
			tip.addItem("Administrator");
			tip.addItem("Lekar");
			tip.addItem("Apotekar");
			tip.setSelectedIndex(0);
			GridBagConstraints gbc_tip = new GridBagConstraints();
			gbc_tip.insets = new Insets(0, 0, 5, 5);
			gbc_tip.fill = GridBagConstraints.HORIZONTAL;
			gbc_tip.gridx = 2;
			gbc_tip.gridy = 7;
			contentPanel.add(tip, gbc_tip);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						for (Korisnik k : ListaKorisnika.getInstance().getKorisnici()) {

							if (username.getText().equals(k.getUsername())) {
								JOptionPane.showMessageDialog(null,
										"Vec postoji korisnik sa username " + username.getText(), "Greska",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						KorisniciController.getInstance().dodajKorisnika(username.getText(), password.getText(),
								ime.getText(), prezime.getText(), izabranTip);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Odustani");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

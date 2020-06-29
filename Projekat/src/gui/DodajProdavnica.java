package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controller.ProdavnicaController;
import model.ListaProdavnica;
import model.Prodavnica;

public class DodajProdavnica extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField lekar;
	private JTextField jmbg;
	private JTextField datum;
	private JTextField ukCena;
	private JTextField sifra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodajProdavnica dialog = new DodajProdavnica();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DodajProdavnica() {
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
			lblNewLabel.setIcon(new ImageIcon(DodajProdavnica.class.getResource("/slike/imelaLogo.jpg")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Dodavanje korpe");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u0160ifra");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			sifra = new JTextField();
			sifra.setEditable(false);
			GridBagConstraints gbc_sifra = new GridBagConstraints();
			gbc_sifra.insets = new Insets(0, 0, 5, 5);
			gbc_sifra.fill = GridBagConstraints.HORIZONTAL;
			gbc_sifra.gridx = 2;
			gbc_sifra.gridy = 3;
			contentPanel.add(sifra, gbc_sifra);
			sifra.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Lekar");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			lekar = new JTextField();
			lekar.setColumns(10);
			GridBagConstraints gbc_lekar = new GridBagConstraints();
			gbc_lekar.insets = new Insets(0, 0, 5, 5);
			gbc_lekar.fill = GridBagConstraints.HORIZONTAL;
			gbc_lekar.gridx = 2;
			gbc_lekar.gridy = 4;
			contentPanel.add(lekar, gbc_lekar);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("JMBG");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jmbg = new JTextField();
			jmbg.setColumns(10);
			GridBagConstraints gbc_jmbg = new GridBagConstraints();
			gbc_jmbg.insets = new Insets(0, 0, 5, 5);
			gbc_jmbg.fill = GridBagConstraints.HORIZONTAL;
			gbc_jmbg.gridx = 2;
			gbc_jmbg.gridy = 5;
			contentPanel.add(jmbg, gbc_jmbg);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Datum");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);			
		}
		{
			datum = new JTextField();
			datum.setColumns(10);
			GridBagConstraints gbc_datum = new GridBagConstraints();
			gbc_datum.insets = new Insets(0, 0, 5, 5);
			gbc_datum.fill = GridBagConstraints.HORIZONTAL;
			gbc_datum.gridx = 2;
			gbc_datum.gridy = 6;
			contentPanel.add(datum, gbc_datum);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
            String strDate = dateFormat.format(Calendar.getInstance().getTime()); 
			datum.setText(strDate);			
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Cena");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 7;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			ukCena = new JTextField();
			ukCena.setEditable(false);
			ukCena.setColumns(10);
			GridBagConstraints gbc_ukCena = new GridBagConstraints();
			gbc_ukCena.insets = new Insets(0, 0, 5, 5);
			gbc_ukCena.fill = GridBagConstraints.HORIZONTAL;
			gbc_ukCena.gridx = 2;
			gbc_ukCena.gridy = 7;
			contentPanel.add(ukCena, gbc_ukCena);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							for (Prodavnica p : ListaProdavnica.getInstance().getProdavnica()) {

								if (sifra.getText().equals(p.getSifra())) {
									JOptionPane.showMessageDialog(null, "Vec postoji korpa sa sifrom " + sifra.getText(),
											"Greska", JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						//final float ukcenaf = Float.parseFloat(ukCena.getText());
						final float ukcenaf = 0;
						try {
							sifra.setText(String.valueOf(Prodavnica.getMaxSifra() + 1));
							ProdavnicaController.getInstance().dodajProdavnica(sifra.getText(), lekar.getText(),
									jmbg.getText(), new SimpleDateFormat("dd.MM.yyyy").parse(datum.getText()), ukcenaf);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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

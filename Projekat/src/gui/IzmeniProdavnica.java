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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ProdavnicaController;
import model.Lek;
import model.Prodavnica;

import javax.swing.JTextArea;
import model.ListaLekova;
import model.ListaProdavnica;

public class IzmeniProdavnica extends JDialog {

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
	 * Create the dialog.
	 */
	public IzmeniProdavnica(Prodavnica prodavnica) {
		Prodavnica p = prodavnica;
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 35, 62, 170, 30 };
		gbl_contentPanel.rowHeights = new int[] { 20, 30, 14, 14, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(IzmeniProdavnica.class.getResource("/slike/imelaLogo.jpg")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Izmena korpe");
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
			sifra.setText(p.getSifra());
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
			lekar.setText(p.getLekar());
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
			jmbg.setText(p.getJmbg());
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
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			datum.setText(dateFormat.format(p.getDatum()));
			contentPanel.add(datum, gbc_datum);
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
			Float ukupno = (float) 0;
			for (String lista : p.getSpisakLekova()) {	
				for (Lek l : ListaLekova.getInstance().getLekovi()) {
					if (lista.equals(l.getSifra())) {
						ukupno = ukupno + (l.getCena());
						break;
					}
				}
			ukCena.setText(String.valueOf(ukupno));
			p.setUkCena(ukupno);
			}			
			//ukCena.setText(String.valueOf(r.getUkCena()));
			contentPanel.add(ukCena, gbc_ukCena);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.insets = new Insets(0, 0, 5, 5);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 2;
			gbc_textArea.gridy = 10;
			
			for (String lista : p.getSpisakLekova()) {
				//textArea.append(lista);	
				for (Lek l : ListaLekova.getInstance().getLekovi()) {
					if (lista.equals(l.getSifra())) {
						textArea.append(l.getNaziv());
						break;
					}
				}
			textArea.append("\n");
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Lista lekova");
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 2;
				gbc_lblNewLabel_6.gridy = 9;
				contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
			}
			contentPanel.add(textArea, gbc_textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Izmeni");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!ProdavnicaJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int row = ProdavnicaJTable.getInstance().convertRowIndexToModel(ProdavnicaJTable.getInstance().getSelectedRow());
							Prodavnica p = ListaProdavnica.getInstance().getRow(row);
							//if(ukCena.getText() != null && !ukCena.getText().isEmpty()){
							//		ukCena.setText("0.0");
							//}
							float ukcenaf;
							try {
								ukcenaf = Float.parseFloat(ukCena.getText());
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								//e2.printStackTrace();
								ukcenaf = 0;
							}
							try {
								ProdavnicaController.getInstance().IzmeniProdavnica(sifra.getText(), lekar.getText(),
										jmbg.getText(), new SimpleDateFormat("dd.MM.yyyy").parse(datum.getText()),
										ukcenaf, p);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Potrebno je izabrati korpu koji želite da menjate ", "Greška!",
									JOptionPane.ERROR_MESSAGE);
						}
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

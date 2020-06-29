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
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LekoviController;
import model.Lek;
import model.ListaLekova;

public class IzmeniLek extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField sifra;
	private JTextField naziv;
	private JTextField proizvodjac;
	private JTextField cena;
	private JCheckBox naRecept;

	/**
	 * Create the dialog.
	 */
	public IzmeniLek(Lek lek) {
		Lek l = lek;
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
			lblNewLabel.setIcon(new ImageIcon(IzmeniLek.class.getResource("/slike/imelaLogo.jpg")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Izmena leka");
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
			sifra.setText(l.getSifra());
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Naziv");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			naziv = new JTextField();
			GridBagConstraints gbc_naziv = new GridBagConstraints();
			gbc_naziv.insets = new Insets(0, 0, 5, 5);
			gbc_naziv.fill = GridBagConstraints.HORIZONTAL;
			gbc_naziv.gridx = 2;
			gbc_naziv.gridy = 4;
			contentPanel.add(naziv, gbc_naziv);
			naziv.setColumns(10);
			naziv.setText(l.getNaziv());
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Proizvo\u0111a\u010D");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			proizvodjac = new JTextField();
			GridBagConstraints gbc_proizvodjac = new GridBagConstraints();
			gbc_proizvodjac.insets = new Insets(0, 0, 5, 5);
			gbc_proizvodjac.fill = GridBagConstraints.HORIZONTAL;
			gbc_proizvodjac.gridx = 2;
			gbc_proizvodjac.gridy = 5;
			contentPanel.add(proizvodjac, gbc_proizvodjac);
			proizvodjac.setColumns(10);
			proizvodjac.setText(l.getProizvodjac());
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Na recept?");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			naRecept = new JCheckBox("");
			GridBagConstraints gbc_naRecept = new GridBagConstraints();
			gbc_naRecept.anchor = GridBagConstraints.WEST;
			gbc_naRecept.insets = new Insets(0, 0, 5, 5);
			gbc_naRecept.gridx = 2;
			gbc_naRecept.gridy = 6;
			contentPanel.add(naRecept, gbc_naRecept);
			if (l.getNaRecept()) {
				naRecept.setSelected(true);
			}
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
			cena = new JTextField();
			GridBagConstraints gbc_cena = new GridBagConstraints();
			gbc_cena.insets = new Insets(0, 0, 5, 5);
			gbc_cena.fill = GridBagConstraints.HORIZONTAL;
			gbc_cena.gridx = 2;
			gbc_cena.gridy = 7;
			contentPanel.add(cena, gbc_cena);
			cena.setColumns(10);
			cena.setText(l.getCena().toString());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Izmeni");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!LekoviJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int row = LekoviJTable.getInstance()
									.convertRowIndexToModel(LekoviJTable.getInstance().getSelectedRow());
							Lek l = ListaLekova.getInstance().getRow(row);
							final boolean naRec = naRecept.isSelected();
							final float cenaf = Float.parseFloat(cena.getText());
							LekoviController.getInstance().IzmeniLek(sifra.getText(), naziv.getText(),
									proizvodjac.getText(), naRec, cenaf, l);
							dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Potrebno je izabrati lek koji želite da obrišete ", "Greška!",
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

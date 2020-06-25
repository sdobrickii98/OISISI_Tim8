package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.KorisniciController;
import model.Korisnik;
import model.ListaKorisnika;

public class ToolBarKorisnik extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public ToolBarKorisnik() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JButton btnAdd = new JButton("");
		btnAdd.setToolTipText("Dodaj korisnika");
		btnAdd.setIcon(new ImageIcon(ToolBarKorisnik.class.getResource("/slike/korisnik_dodaj.jpg")));
		btnAdd.setMnemonic(KeyEvent.VK_A);
		panel.add(btnAdd);

		JButton btnInsert = new JButton("");
		btnInsert.setToolTipText("Izmeni korisnika");
		btnInsert.setIcon(new ImageIcon(ToolBarKorisnik.class.getResource("/slike/korisnik_izmeni.jpg")));
		btnInsert.setMnemonic(KeyEvent.VK_I);
		panel.add(btnInsert);

		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Brisanje korisnika");
		btnDelete.setIcon(new ImageIcon(ToolBarKorisnik.class.getResource("/slike/korisnik_obrisi.jpg")));
		btnDelete.setMnemonic(KeyEvent.VK_D);
		panel.add(btnDelete);

		JPanel panel1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		add(panel1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel1.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Pretraga korisnika");
		btnSearch.setIcon(new ImageIcon(ToolBarKorisnik.class.getResource("/slike/pretraga.jpg")));
		btnSearch.setMnemonic(KeyEvent.VK_S);
		panel1.add(btnSearch);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DodajKorisnika kor = new DodajKorisnika();
				kor.setVisible(true);
			}

		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!KorisniciJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = KorisniciJTable.getInstance()
							.convertRowIndexToModel(KorisniciJTable.getInstance().getSelectedRow());

					Korisnik korisnik = ListaKorisnika.getInstance().getRow(row);

					if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete korisnika?",
							"Brisanje Korisnika", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						KorisniciController.getInstance().izbrisiKorisnika(korisnik);
					} else {
						return;
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Potrebno je izabrati korisnika kojeg želite da obrišete ", "Greška!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!KorisniciJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = KorisniciJTable.getInstance()
							.convertRowIndexToModel(KorisniciJTable.getInstance().getSelectedRow());
					Korisnik k = ListaKorisnika.getInstance().getRow(row);

					IzmeniKorisnika izmena = new IzmeniKorisnika(k);
					izmena.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Potrebno je izabrati korisnika kojeg želite da izmenite ", "Greška!",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String query = textField.getText();
				KorisniciJTable.getInstance().search(query);
			}

		});

	}

}

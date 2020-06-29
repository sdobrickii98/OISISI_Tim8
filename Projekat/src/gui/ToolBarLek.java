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

import controller.LekoviController;
import model.Lek;
import model.ListaLekova;

public class ToolBarLek extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public ToolBarLek() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JButton btnAdd = new JButton("");
		btnAdd.setToolTipText("Dodaj lek");
		btnAdd.setIcon(new ImageIcon(ToolBarLek.class.getResource("/slike/lek_dodaj.jpg")));
		btnAdd.setMnemonic(KeyEvent.VK_A);
		panel.add(btnAdd);

		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!LekoviJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = LekoviJTable.getInstance()
							.convertRowIndexToModel(LekoviJTable.getInstance().getSelectedRow());
					Lek l = ListaLekova.getInstance().getRow(row);

					IzmeniLek izmena = new IzmeniLek(l);
					izmena.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati lek koji želite da izmenite",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEdit.setToolTipText("Izmena leka");
		btnEdit.setIcon(new ImageIcon(ToolBarLek.class.getResource("/slike/lek_izmeni.jpg")));
		btnEdit.setMnemonic(KeyEvent.VK_I);
		panel.add(btnEdit);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!LekoviJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = LekoviJTable.getInstance()
							.convertRowIndexToModel(LekoviJTable.getInstance().getSelectedRow());
					System.out.println("Izabrana vrsta: " + row);
					Lek l = ListaLekova.getInstance().getRow(row);

					if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete lek?",
							"Brisanje Leka", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						LekoviController.getInstance().izbrisiLek(l);
					} else {
						return;
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati lek koji želite da obrišete ",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setToolTipText("Brisanje leka");
		btnDelete.setIcon(new ImageIcon(ToolBarLek.class.getResource("/slike/lek_obrisi.jpg")));
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
		btnSearch.setToolTipText("Search subjects");
		btnSearch.setIcon(new ImageIcon(ToolBarLek.class.getResource("/slike/pretraga.jpg")));
		btnSearch.setMnemonic(KeyEvent.VK_S);
		panel1.add(btnSearch);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DodajLek dl = new DodajLek();
				dl.setVisible(true);
			}

		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String query = textField.getText();
				LekoviJTable.getInstance().search(query);
			}

		});

	}

}

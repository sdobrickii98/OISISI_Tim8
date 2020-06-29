package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JFrame;
import controller.ReceptiController;
import model.ListaRecepata;
import model.Recept;
//import gui.DodajLekNaRecept;

public class ToolBarRecept extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public ToolBarRecept() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JButton btnAdd = new JButton("");
		btnAdd.setToolTipText("Dodaj recept");
		btnAdd.setIcon(new ImageIcon(ToolBarRecept.class.getResource("/slike/DodajRecept.jpg")));
		btnAdd.setMnemonic(KeyEvent.VK_A);
		panel.add(btnAdd);

		JButton btnInsert = new JButton("");
		btnInsert.setToolTipText("Izmena recepta");
		btnInsert.setIcon(new ImageIcon(ToolBarRecept.class.getResource("/slike/IzmeniRecept.jpg")));
		btnInsert.setMnemonic(KeyEvent.VK_I);
		panel.add(btnInsert);

		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Brisanje Recepta");
		btnDelete.setIcon(new ImageIcon(ToolBarRecept.class.getResource("/slike/OduzmiRecept.jpg")));
		btnDelete.setMnemonic(KeyEvent.VK_D);
		panel.add(btnDelete);

		JButton addLekBtn = new JButton("");
		addLekBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!ReceptiJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = ReceptiJTable.getInstance()
							.convertRowIndexToModel(ReceptiJTable.getInstance().getSelectedRow());

					@SuppressWarnings("unused")
					Recept recept = ListaRecepata.getInstance().getRow(row);

					DodajLekNaRecept dlnr = new DodajLekNaRecept();
					dlnr.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Potrebno je izabrati recept na koji želite da dodate lek", "Greška!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addLekBtn.setIcon(new ImageIcon(ToolBarRecept.class.getResource("/slike/DodajLekNaRecept.jpg")));
		panel.add(addLekBtn);
		
		JButton removeLekBtn = new JButton("");
		removeLekBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ReceptiJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
//					int row = ReceptiJTable.getInstance().convertRowIndexToModel(ReceptiJTable.getInstance().getSelectedRow());
//					Recept recept = ListaRecepata.getInstance().getRow(row);
					IzbrisiLekSaRecepta ilsr = new IzbrisiLekSaRecepta();
					ilsr.setVisible(true);					
				}
			}
		});
		removeLekBtn.setIcon(new ImageIcon(ToolBarRecept.class.getResource("/slike/OduzmiLekNaRecept.jpg")));
		panel.add(removeLekBtn);

		JPanel panel1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		add(panel1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel1.add(textField);
		textField.setColumns(5);

		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Pretraga");
		ImageIcon image9 = new ImageIcon(getClass().getResource("/slike/pretraga.jpg"));
		btnSearch.setIcon(image9);
		btnSearch.setMnemonic(KeyEvent.VK_S);
		panel1.add(btnSearch);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DodajRecept rec = new DodajRecept();
				rec.setVisible(true);
			}

		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!ReceptiJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = ReceptiJTable.getInstance()
							.convertRowIndexToModel(ReceptiJTable.getInstance().getSelectedRow());
					System.out.println("Selected row: " + row);
					Recept recept = ListaRecepata.getInstance().getRow(row);

					if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete recept?",
							"Brisanje recepta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ReceptiController.getInstance().izbrisiRecept(recept);
					} else {
						return;
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati recept koji želite da obrišete ",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub
				if (!ReceptiJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = ReceptiJTable.getInstance()
							.convertRowIndexToModel(ReceptiJTable.getInstance().getSelectedRow());
					Recept recept = ListaRecepata.getInstance().getRow(row);
					// System.out.println(recept.getSifra());

					IzmeniRecept izmena = new IzmeniRecept(recept);
					izmena.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati recept koji želite da izmenite",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String query = textField.getText();
				ReceptiJTable.getInstance().search(query);
			}

		});

	}

}

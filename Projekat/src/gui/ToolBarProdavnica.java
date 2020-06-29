package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.ProdavnicaController;
import model.ListaProdavnica;
import model.Prodavnica;

public class ToolBarProdavnica extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public ToolBarProdavnica() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JButton btnAddKorpa = new JButton("");
		btnAddKorpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajProdavnica pro = new DodajProdavnica();
				pro.setVisible(true);
			}
		});
		btnAddKorpa.setToolTipText("Nova korpa");
		btnAddKorpa.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/DodajKorpu.jpg")));
		btnAddKorpa.setMnemonic(KeyEvent.VK_A);
		panel.add(btnAddKorpa);
		
		JButton btmIzmenaKorpe = new JButton("");
		btmIzmenaKorpe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!ProdavnicaJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = ProdavnicaJTable.getInstance()
							.convertRowIndexToModel(ProdavnicaJTable.getInstance().getSelectedRow());
					
					Prodavnica prodavnica = ListaProdavnica.getInstance().getRow(row);
					
					IzmeniProdavnica izmena = new IzmeniProdavnica(prodavnica);
					izmena.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati korpu koju želite da izmenite",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		btmIzmenaKorpe.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/IzmeniKorpu.jpg")));
		btmIzmenaKorpe.setToolTipText("Izmena korpe");
		btmIzmenaKorpe.setMnemonic(KeyEvent.VK_A);
		panel.add(btmIzmenaKorpe);		
		
		JButton btnBrisiKorpu = new JButton("");
		btnBrisiKorpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ProdavnicaJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int row = ProdavnicaJTable.getInstance()
							.convertRowIndexToModel(ProdavnicaJTable.getInstance().getSelectedRow());
					//System.out.println("Selected row: " + row);
					Prodavnica prodavnica = ListaProdavnica.getInstance().getRow(row);

					if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete korpu?",
							"Brisanje korpe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						try {
							ProdavnicaController.getInstance().izbrisiProdavnica(prodavnica);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						return;
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati korpu koji želite da obrišete ",
							"Greška!", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		btnBrisiKorpu.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/ObrisiKorpu.jpg")));
		btnBrisiKorpu.setToolTipText("Briši korpu");
		panel.add(btnBrisiKorpu);
		
		JButton btnAddLek = new JButton("");
		btnAddLek.setToolTipText("Dodaj lek");
		btnAddLek.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/lek_dodaj.jpg")));
		btnAddLek.setMnemonic(KeyEvent.VK_A);
		panel.add(btnAddLek);

		JButton btnAddRecept = new JButton("");
		btnAddRecept.setToolTipText("Dodaj recept");
		btnAddRecept.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/DodajRecept.jpg")));
		btnAddRecept.setMnemonic(KeyEvent.VK_I);
		panel.add(btnAddRecept);

		JPanel panel1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		add(panel1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel1.add(textField);
		textField.setColumns(5);

		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Pretraga prodaje");
		btnSearch.setIcon(new ImageIcon(ToolBarProdavnica.class.getResource("/slike/pretraga.jpg")));
		btnSearch.setMnemonic(KeyEvent.VK_S);
		panel1.add(btnSearch);

		btnAddLek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!ProdavnicaJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					DodajLekUKorpu dluk = new DodajLekUKorpu();
					dluk.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Potrebno je izabrati korpu na koji želite da dodate lek", "Greška!",
							JOptionPane.ERROR_MESSAGE);
				}				
			}

		});

		btnAddRecept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!ProdavnicaJTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					DodajReceptUKorpu druk = new DodajReceptUKorpu();
					druk.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Potrebno je izabrati korpu na koji želite da dodate recept", "Greška!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String query = textField.getText();
				ProdavnicaJTable.getInstance().search(query);
			}

		});

	}

}

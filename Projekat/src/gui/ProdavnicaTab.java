package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProdavnicaTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProdavnicaTab() {
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollProd = new JScrollPane();
		ProdavnicaJTable prodavnicaTabela = ProdavnicaJTable.getInstance();
		this.add(scrollProd, BorderLayout.CENTER);
		scrollProd.setViewportView(prodavnicaTabela);
	}
}

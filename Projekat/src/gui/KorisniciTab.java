package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class KorisniciTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public KorisniciTab() {
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollPred = new JScrollPane();
		KorisniciJTable korisniciTabela = KorisniciJTable.getInstance();
		this.add(scrollPred, BorderLayout.CENTER);
		scrollPred.setViewportView(korisniciTabela);
	}
}

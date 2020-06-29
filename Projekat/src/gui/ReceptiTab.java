package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReceptiTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public ReceptiTab() {
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollPred = new JScrollPane();
		ReceptiJTable receptiTabela = ReceptiJTable.getInstance();
		this.add(scrollPred, BorderLayout.CENTER);
		scrollPred.setViewportView(receptiTabela);
	}
}

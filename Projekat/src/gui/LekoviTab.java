package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LekoviTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public LekoviTab() {
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollPred = new JScrollPane();
		LekoviJTable lekoviTabela = LekoviJTable.getInstance();
		this.add(scrollPred, BorderLayout.CENTER);
		scrollPred.setViewportView(lekoviTabela);
	}
}

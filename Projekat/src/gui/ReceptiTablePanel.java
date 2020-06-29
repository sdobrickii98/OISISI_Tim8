package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ReceptiTablePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel leftPanel = new JPanel();

	private JPanel rightPanel = new JPanel();

	public ReceptiTablePanel() {
		super();
		this.setBackground(Color.WHITE);

	}

	public ReceptiTablePanel(java.awt.Component c) {
		setLayout(new BorderLayout());
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.setBackground(Color.WHITE);
		add(c);
	}

}

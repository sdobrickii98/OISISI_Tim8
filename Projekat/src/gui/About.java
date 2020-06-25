package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class About extends JDialog {

	private static final long serialVersionUID = 2420033596461581384L;

	GridBagLayout gb1;

	JPanel p0;

	GridBagConstraints gcp0;

	GridBagLayout gbp0;

	JTextArea text;

	GridBagConstraints gc1;

	public About() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		int screenHeight = 768 * 1 / 2;
		int screenWidth = 1366 * 1 / 2;
		setSize(screenWidth, screenHeight);
		setResizable(true);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setTitle("About");

		gb1 = new GridBagLayout();
		gb1.rowHeights = new int[] { 0 };
		gb1.rowWeights = new double[] { 1.0 };
		gb1.columnWidths = new int[] { 10 };
		gb1.columnWeights = new double[] { 1.0 };
		getContentPane().setLayout(gb1);

		p0 = new JPanel();
		gcp0 = new GridBagConstraints();
		gcp0.gridx = 0;
		gcp0.gridy = 0;
		getContentPane().add(p0, gcp0);
		gbp0 = new GridBagLayout();
		gbp0.columnWidths = new int[] { 0 };
		gbp0.rowHeights = new int[] { 0 };
		gbp0.columnWeights = new double[] { 0.0 };
		gbp0.rowWeights = new double[] { 0.0 };
		p0.setLayout(gbp0);

		text = new JTextArea("" + "Imela farmacija\n\n" + "Version: 0.1\n\n"
				+ "Student 1:\n        Stojan Dobrički,   AI5/2017\n\n"
				+ "Student 2:\n        Lenka Siriški,   AI11/2017\n\n"
				+ "Student 3:\n        Nikola Marković,   AI12/2017\n\n"
				+ "Student 4:\n        Ivana Rijavec,   AI48/2017\n\n" + "Svrha:\n  Softver za upravljanje apotekom. "
				+ "Omogućava uređivanje podataka o lekovima, lekarima, receptima.");
		text.setEditable(false);
		text.setSelectionColor(Color.MAGENTA);
		text.setFont(new Font("Arial", Font.PLAIN, 13));
		gc1 = new GridBagConstraints();
		gc1.gridx = 0;
		gc1.gridy = 0;
		p0.add(text, gc1);

	}
}
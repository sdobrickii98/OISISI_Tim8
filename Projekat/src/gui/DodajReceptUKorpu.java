package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LekoviController;
import model.Lek;
import model.ListaLekova;
import model.ListaProdavnica;
import model.ListaRecepata;
import model.Prodavnica;
import model.Recept;

import javax.swing.JComboBox;

public class DodajReceptUKorpu extends JDialog {

	private static final long serialVersionUID = -4993387552790893124L;

	GridBagLayout gb1;

	JComboBox<Object> tf1;

	JPanel p0;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel pb1;
	JPanel pb2;

	GridBagConstraints gcp0;
	GridBagConstraints gcp1;
	GridBagConstraints gcp2;
	GridBagConstraints gcp3;

	GridBagConstraints gc1;
	GridBagConstraints gc2;
	GridBagConstraints gc3;
	GridBagConstraints gc4;
	GridBagConstraints gc5;

	GridBagLayout gbp0;
	GridBagLayout gbp1;
	GridBagLayout gbp2;

	JLabel l0;
	JLabel title;
	JLabel indeksS;
	JLabel l;

	JButton b1;
	JButton b2;

	KeyListener myKeyListener;
	
	Recept r1;

	public DodajReceptUKorpu() {

			int screenHeight = 768 * 1 / 5;
			int screenWidth = 1366 * 9 / 20;
			setSize(screenWidth, screenHeight);
			setResizable(true);
			setModal(true);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			this.setUndecorated(true);

		gb1 = new GridBagLayout();
		gb1.rowHeights = new int[] { 0, 0, 0, 0 };
		gb1.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0 };
		gb1.columnWidths = new int[] { 10 };
		gb1.columnWeights = new double[] { 1.0 };
		getContentPane().setLayout(gb1);

		p0 = new JPanel();
		p0.setBackground(Color.LIGHT_GRAY);
		gcp0 = new GridBagConstraints();
		gcp0.fill = GridBagConstraints.BOTH;
		gcp0.insets = new Insets(0, 0, 7, 0);
		gcp0.gridx = 0;
		gcp0.gridy = 0;
		getContentPane().add(p0, gcp0);
		gbp0 = new GridBagLayout();
		gbp0.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbp0.rowHeights = new int[] { 0 };
		gbp0.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0 };
		gbp0.rowWeights = new double[] { 0.0 };
		p0.setLayout(gbp0);

		l0 = new JLabel(" ");
		l0.setFont(new Font("Arial", Font.PLAIN, 17));
		gc1 = new GridBagConstraints();
		gc1.gridx = 0;
		gc1.gridy = 0;
		p0.add(l0, gc1);

		title = new JLabel("Korpa - DodajRecept");
		title.setFont(new Font("Arial", Font.PLAIN, 13));
		gc2 = new GridBagConstraints();
		gc2.anchor = GridBagConstraints.WEST;
		gc2.gridx = 1;
		gc2.gridy = 0;
		p0.add(title, gc2);

		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		gcp1 = new GridBagConstraints();
		gcp1.fill = GridBagConstraints.BOTH;
		gcp1.insets = new Insets(7, 30, 7, 30);
		gcp1.gridx = 0;
		gcp1.gridy = 1;
		getContentPane().add(p1, gcp1);
		gbp1 = new GridBagLayout();
		gbp1.columnWidths = new int[] { 0, 0 };
		gbp1.rowHeights = new int[] { 0 };
		gbp1.columnWeights = new double[] { 0.0, 1.0 };
		gbp1.rowWeights = new double[] { 0.0 };
		p1.setLayout(gbp1);

		indeksS = new JLabel("\u0160ifra Recepta");
		indeksS.setFont(new Font("Arial", Font.PLAIN, 13));
		gc3 = new GridBagConstraints();
		gc3.insets = new Insets(10, 0, 15, 15);
		gc3.gridx = 0;
		gc3.gridy = 0;
		p1.add(indeksS, gc3);

		
		ArrayList<String> spisak = new ArrayList<String>();
		for (Recept r1 : ListaRecepata.getInstance().getRecepti()) {
			spisak.add(r1.getSifra());
			//System.out.println(r.getSifra());
		}
		String[] lista = spisak.toArray(new String[spisak.size()]);

		tf1 = new JComboBox<Object>(lista);
		tf1.setFont(new Font("Futura", Font.PLAIN, 13));
		gc4 = new GridBagConstraints();
		gc4.fill = GridBagConstraints.HORIZONTAL;
		gc4.gridx = 1;
		gc4.gridy = 0;
		p1.add(tf1, gc4);

		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		gcp2 = new GridBagConstraints();
		gcp2.insets = new Insets(7, 35, 5, 20);
		gcp2.anchor = GridBagConstraints.SOUTHEAST;
		gcp2.gridx = 0;
		gcp2.gridy = 3;
		getContentPane().add(p2, gcp2);

		b1 = new JButton("Odustani");
		b1.setFont(new Font("Arial", Font.PLAIN, 13));
		b1.setBackground(Color.WHITE);
		p2.add(b1);

		pb1 = new JPanel();
		pb1.setBackground(Color.WHITE);
		p2.add(pb1);

		pb2 = new JPanel();
		pb2.setBackground(Color.WHITE);
		p2.add(pb2);

		b2 = new JButton("Potvrda");
		b2.setFont(new Font("Arial", Font.PLAIN, 13));
		b2.setBackground(Color.WHITE);
		p2.add(b2);

		b1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		b2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowprod = ProdavnicaJTable.getInstance().convertRowIndexToModel(ProdavnicaJTable.getInstance().getSelectedRow());
				Prodavnica prodavnica = ListaProdavnica.getInstance().getRow(rowprod);
				String SifraRecepta = (String) tf1.getSelectedItem();
				Recept IzabraniRecept =ListaRecepata.getInstance().NadjiReceptPoSifri(SifraRecepta);
				System.out.println(IzabraniRecept.getSifra());
				for (String lista : IzabraniRecept.getSpisakLekova()) {
					System.out.println(lista);
					for (Lek l : ListaLekova.getInstance().getLekovi()) {
						if (lista.equals(l.getSifra())) {
							System.out.println(l.getSifra());
							LekoviController.getInstance().DodavanjeCelogReceptaUKorpu(prodavnica, l.getSifra());
							break;
						}
					}
				}
				dispose();
			}
			

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(51, 204, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b2.setBackground(Color.WHITE);
			}

		});

		p3 = new JPanel();
		p3.setBackground(Color.LIGHT_GRAY);
		gcp3 = new GridBagConstraints();
		gcp3.fill = GridBagConstraints.BOTH;
		gcp3.insets = new Insets(7, 0, 0, 0);
		gcp3.gridx = 0;
		gcp3.gridy = 4;
		getContentPane().add(p3, gcp3);
		gbp2 = new GridBagLayout();
		gbp2.columnWidths = new int[] { 0 };
		gbp2.rowHeights = new int[] { 0 };
		gbp2.columnWeights = new double[] { 1.0 };
		gbp2.rowWeights = new double[] { 0.0 };
		p3.setLayout(gbp2);

		l = new JLabel(" ");
		l.setFont(new Font("Arial", Font.PLAIN, 17));
		gc5 = new GridBagConstraints();
		gc5.gridx = 0;
		gc5.gridy = 0;
		p3.add(l, gc5);

	}
}

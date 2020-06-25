package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = -4993387552790893124L;

	public MenuBar() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");

		file.setFont(new Font("Arial", Font.PLAIN, 20));
		edit.setFont(new Font("Arial", Font.PLAIN, 20));
		help.setFont(new Font("Arial", Font.PLAIN, 20));

		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);

		ImageIcon icon1 = createImageIcon("/slike/iconfinder_add_134224.png");
		ImageIcon icon2 = createImageIcon("/slike/iconfinder_ic_close_48px_352270.png");
		ImageIcon icon3 = createImageIcon("/slike/iconfinder_081_Pen_183209.png");
		ImageIcon icon4 = createImageIcon("/slike/iconfinder_Streamline-70_185090.png");
		ImageIcon icon6 = createImageIcon("/slike/iconfinder_v-31_3162614.png");

		JMenuItem miNew = new JMenuItem("New", icon1);
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(this);

		JMenuItem miClose = new JMenuItem("Close", icon2);
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.addActionListener(this);

		JMenuItem miEdit = new JMenuItem("Edit", icon3);
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(this);

		JMenuItem miDelete = new JMenuItem("Delete", icon4);
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(this);

		JMenuItem miAbout = new JMenuItem("About", icon6);
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(this);

		add(file);
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);

		add(edit);
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);

		add(help);
		help.add(miAbout);

		this.setBackground(Color.WHITE);
		miClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				About a = new About();
				a.setVisible(true);
			}

		});

	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		if (source.getText().equals("Exit"))
			System.exit(0);
	}

	private ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MenuBar.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
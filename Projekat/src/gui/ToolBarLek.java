package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBarLek extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public ToolBarLek() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JPanel panel1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) panel1.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		add(panel1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel1.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Search subjects");
		btnSearch.setIcon(new ImageIcon(ToolBarLek.class.getResource("/slike/pretraga.jpg")));
		btnSearch.setMnemonic(KeyEvent.VK_S);
		panel1.add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String query = textField.getText();
				LekoviJTable.getInstance().search(query);
			}

		});

	}

}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = -4993387552790893124L;

	private JLabel name;
	private JLabel time;
	private JLabel date;

	public StatusBar() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		GridBagLayout gb = new GridBagLayout();
		this.setLayout(gb);

		GridBagConstraints gc1 = new GridBagConstraints();
		GridBagConstraints gc2 = new GridBagConstraints();
		GridBagConstraints gc3 = new GridBagConstraints();

		name = new JLabel("NemaLekaApoteka");
		name.setFont(new Font("Arial", Font.PLAIN, 20));

		time = new JLabel();
		final DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
		time.setFont(new Font("Arial", Font.PLAIN, 20));

		date = new JLabel();
		final DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		date.setFont(new Font("Arial", Font.PLAIN, 20));

		gc1.gridx = 0;
		gc1.gridy = 0;
		gc1.weightx = 30;
		gc1.anchor = GridBagConstraints.WEST;
		gc1.ipady = 5;
		gc1.insets.left = 7;

		gc2.gridx = 1;
		gc2.gridy = 0;
		gc2.anchor = GridBagConstraints.EAST;

		gc3.gridx = 2;
		gc3.gridy = 0;
		gc3.weightx = 1;
		gc3.anchor = GridBagConstraints.EAST;
		gc3.insets.right = 7;

		this.add(name, gc1);
		this.add(time, gc2);
		this.add(date, gc3);
		this.setBackground(Color.LIGHT_GRAY);

		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time.setText(LocalDateTime.now().format(formatTime));
				date.setText(LocalDateTime.now().format(formatDate));
			}
		});

		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
	}
}
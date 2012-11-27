package gui;

import javax.swing.JPanel;
import javax.swing.JList;

public class BehandlingPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public BehandlingPane() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(6, 6, 200, 288);
		add(list);

	}

}

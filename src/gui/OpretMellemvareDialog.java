package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OpretMellemvareDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList mellemvare_list;

	/**
	 * Create the dialog.
	 */
	public OpretMellemvareDialog(JList mellemvare_list) {
		this.mellemvare_list = mellemvare_list;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
	}

}

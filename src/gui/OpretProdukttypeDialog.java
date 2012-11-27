package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OpretProdukttypeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList produkttype_list;
	
	/**
	 * Create the dialog.
	 */
	public OpretProdukttypeDialog(JList produkttype_list) {
		this.produkttype_list = produkttype_list;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}

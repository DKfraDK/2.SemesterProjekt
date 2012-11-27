package gui;

import javax.swing.JList;
import javax.swing.JPanel;

import service.Service;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MellemvarePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public MellemvarePane() {
		setLayout(null);
		
		JList mellemvare_list = new JList();
		mellemvare_list.setBounds(6, 6, 200, 288);
		mellemvare_list.setListData(Service.getMellemvarer().toArray());
		add(mellemvare_list);
		
		JButton fjernMellemvare_btn = new JButton("Fjern mellemvare");
		fjernMellemvare_btn.setBounds(260, 6, 140, 29);
		add(fjernMellemvare_btn);
		
		JButton opretMellemvare_btn = new JButton("Opret mellemvare");
		opretMellemvare_btn.setBounds(260, 37, 140, 29);
		add(opretMellemvare_btn);
		
		JTextArea info_txtArea = new JTextArea();
		info_txtArea.setEditable(false);
		info_txtArea.setBounds(218, 102, 226, 192);
		add(info_txtArea);
		
		JLabel infoOmValgt_lbl = new JLabel("Info om valgt mellemvare");
		infoOmValgt_lbl.setBounds(252, 74, 160, 16);
		add(infoOmValgt_lbl);
		
	}
}

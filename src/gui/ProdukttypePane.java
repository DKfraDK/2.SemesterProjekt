package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import service.Service;

public class ProdukttypePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProdukttypePane() {
		setLayout(null);
		
		JList produkttype_list = new JList();
		produkttype_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		produkttype_list.setListData(Service.getProdukttyper().toArray());
		produkttype_list.setBounds(6, 6, 200, 288);
		add(produkttype_list);
	
		JButton fjernProdukttype_btn = new JButton("Fjern produkttype");
		fjernProdukttype_btn.setBounds(260, 6, 140, 29);
		add(fjernProdukttype_btn);
		
		JButton opretProdukttype_btn = new JButton("Opret produkttype");
		opretProdukttype_btn.setBounds(260, 37, 140, 29);
		add(opretProdukttype_btn);
		
		JTextArea info_txtArea = new JTextArea();
		info_txtArea.setEditable(false);
		info_txtArea.setBounds(218, 102, 226, 192);
		add(info_txtArea);
		
		JLabel infoOmValgt_lbl = new JLabel("Info om valgt produkttype");
		infoOmValgt_lbl.setBounds(239, 74, 177, 16);
		add(infoOmValgt_lbl);
	}

}

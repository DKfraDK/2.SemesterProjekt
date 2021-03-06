package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Delbehandling;
import service.Service;

public class DelbehandlingPane extends JPanel {

	private Controller controller = new Controller();
	private JList delbehandling_list;
	private JTextArea info_txtArea;
	private JButton fjernDelbehandling_btn, opretDelbehandling_btn;
	
	
	/**
	 * Create the panel.
	 */
	public DelbehandlingPane() {
		setLayout(null);
		
		delbehandling_list = new JList();
		delbehandling_list.setBounds(6, 6, 200, 288);
		delbehandling_list.setListData(Service.getDelbehandlinger().toArray());
		add(delbehandling_list);
		delbehandling_list.addListSelectionListener(controller);
		
		fjernDelbehandling_btn = new JButton("Fjern delbehandling");
		fjernDelbehandling_btn.setBounds(247, 6, 162, 29);
		add(fjernDelbehandling_btn);
		fjernDelbehandling_btn.addActionListener(controller);
		
		opretDelbehandling_btn = new JButton("Opret delbehandling");
		opretDelbehandling_btn.setBounds(247, 46, 162, 29);
		add(opretDelbehandling_btn);
		opretDelbehandling_btn.addActionListener(controller);
		
		info_txtArea = new JTextArea();
		info_txtArea.setEditable(false);
		info_txtArea.setBounds(218, 102, 226, 192);
		add(info_txtArea);
		
		JLabel infoOmValgt_lbl = new JLabel("Info om valgt delbehandling");
		infoOmValgt_lbl.setBounds(239, 74, 177, 16);
		add(infoOmValgt_lbl);
		

	}
	
	private class Controller implements ActionListener, ListSelectionListener{

		private Delbehandling currentSelectedDelbehandling;
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(e.getSource() == delbehandling_list){
				currentSelectedDelbehandling = (Delbehandling) delbehandling_list.getSelectedValue();
				info_txtArea.setText("Min t�rretid: " + currentSelectedDelbehandling.getMinToerreTid()
										+ "\nIdeal t�rretid: " + currentSelectedDelbehandling.getIdealToerreTid()
										+ "\nMax t�rretid: " + currentSelectedDelbehandling.getMaxToerreTid());
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == opretDelbehandling_btn){
				new OpretDelbehandlingDialog(delbehandling_list);
			}else if(e.getSource() == fjernDelbehandling_btn){
				if(Service.deleteDelBehandling(currentSelectedDelbehandling)){
					delbehandling_list.setListData(Service.getDelbehandlinger().toArray());
				}else{
					JOptionPane.showMessageDialog(null, "Delbehandlingen du forsoeger at fjerne er tilknyttet til en behandling", "Fejl", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

}

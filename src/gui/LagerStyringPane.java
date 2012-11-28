package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.Service;

public class LagerStyringPane extends JPanel {

	private Controller controller = new Controller();
	private JButton nsteDag_btn, kritiskeMellemvarer_btn, nsteMellemvareTilBehandling_btn, forGamleMellemvarer_btn;
	private JLabel nuvaerendeDag_lbl;
	
	/**
	 * Create the panel.
	 */
	public LagerStyringPane() {
		setLayout(null);
		
		nsteDag_btn = new JButton("N\u00E6ste dag");
		nsteDag_btn.setBounds(97, 38, 251, 29);
		add(nsteDag_btn);
		nsteDag_btn.addActionListener(controller);
		
		kritiskeMellemvarer_btn = new JButton("Kritiske mellemvarer");
		kritiskeMellemvarer_btn.setBounds(97, 79, 251, 29);
		add(kritiskeMellemvarer_btn);
		kritiskeMellemvarer_btn.addActionListener(controller);
		
		nsteMellemvareTilBehandling_btn = new JButton("N\u00E6ste mellemvare til behandling");
		nsteMellemvareTilBehandling_btn.setBounds(97, 120, 251, 29);
		add(nsteMellemvareTilBehandling_btn);
		nsteMellemvareTilBehandling_btn.addActionListener(controller);
		
		forGamleMellemvarer_btn = new JButton("For gamle mellemvarer");
		forGamleMellemvarer_btn.setBounds(97, 161, 251, 29);
		add(forGamleMellemvarer_btn);
		forGamleMellemvarer_btn.addActionListener(controller);
		
		JLabel dag_lbl = new JLabel("Dag:");
		dag_lbl.setBounds(112, 10, 61, 16);
		add(dag_lbl);
		
		nuvaerendeDag_lbl = new JLabel("0");
		nuvaerendeDag_lbl.setText("" + Service.getDag());
		nuvaerendeDag_lbl.setBounds(158, 10, 190, 16);
		add(nuvaerendeDag_lbl);
	}
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == nsteDag_btn){
				Service.nyDag();
				nuvaerendeDag_lbl.setText("" + Service.getDag());
			}
		}
	}

}

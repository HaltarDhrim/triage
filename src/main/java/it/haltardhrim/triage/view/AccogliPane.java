package it.haltardhrim.triage.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AccogliPane extends JPanel {

	JLabel lblCodfisc = new JLabel("Cod.Fisc.");
	JTextField codfisc = new JTextField();
	JLabel lblPriorita = new JLabel("Priorità");
	JComboBox<String> priorita = new JComboBox<String>(new String[] { "Rosso", "Giallo", "Verde", "Bianco" });

	public AccogliPane() throws HeadlessException {
		setLayout(new GridLayout(0, 2));
		add(lblCodfisc);
		add(codfisc);
		add(lblPriorita);
		add(priorita);
	}
}

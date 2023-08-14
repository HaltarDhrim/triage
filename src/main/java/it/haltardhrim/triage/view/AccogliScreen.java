package it.haltardhrim.triage.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.haltardhrim.triage.control.Control;

@SuppressWarnings("serial")
public class AccogliScreen extends JFrame {

	// Componenti Listener
	Control control;
	MainScreen mainScreen;

	// Componenti Panel
	JPanel panelCenter;
	JPanel panelSouth;

	// Componenti Component
	JLabel lblCodfisc;
	JTextField codfisc;
	JLabel lblPriorita;
	JComboBox<String> priorita;
	JButton ok;
	JButton annulla;

	public AccogliScreen(Control control, MainScreen mainScreen) throws HeadlessException {
		super("Accogli");
		this.control = control;
		this.mainScreen = mainScreen;
		init();
		define();
		build();
		setVisible(true);
	}

	public void init() {
		setSize(300, 130);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void define() {
		lblCodfisc = new JLabel("Cod.Fisc.");
		codfisc = new JTextField();
		lblPriorita = new JLabel("Priorità");
		priorita = new JComboBox<String>(new String[] { "Rosso", "Giallo", "Verde", "Bianco" });

		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK");
				control.accogliOkClicked(codfisc.getText(), priorita.getSelectedIndex(), mainScreen);
				dispose();
			}
		});

		annulla = new JButton("Annulla");
		annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public void build() {
		// panelCenter = aggiungi label e caselle di testo codfisc
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(0, 2));
		panelCenter.add(lblCodfisc);
		panelCenter.add(codfisc);
		panelCenter.add(lblPriorita);
		panelCenter.add(priorita);

		panelSouth = new JPanel();
		panelSouth.add(ok);
		panelSouth.add(annulla);

		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
	}
}

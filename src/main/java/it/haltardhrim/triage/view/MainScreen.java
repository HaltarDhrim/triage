package it.haltardhrim.triage.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.haltardhrim.triage.control.Control;

public class MainScreen extends JFrame {

	// Componenti View-Panel
	JScrollPane panelCenter;
	JPanel panelSouth;

	// Componenti View-Component
	JTable lista;
	JButton mostra;

	// Componenti Control
	Control control;

	public MainScreen(Control control) throws HeadlessException {
		super("Triage");
		this.control = control;
		init();
		define();
		build();
		setVisible(true);
	}

	public void init() {
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void define() {
		lista = new JTable(new PazientiTable());
		lista.setFillsViewportHeight(true);

		mostra = new JButton("Aggiorna");
		mostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Aggiorna");
				PazientiTable t = (PazientiTable) lista.getModel();
				control.aggiornaClicked(t);
			}
		});
	}

	public void build() {
		panelCenter = new JScrollPane(lista);

		panelSouth = new JPanel();
		panelSouth.add(mostra);

		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
	}
}

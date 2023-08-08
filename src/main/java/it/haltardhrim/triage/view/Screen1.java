package it.haltardhrim.triage.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.haltardhrim.triage.model.Paziente;
import it.haltardhrim.triage.model.PazienteService;

public class Screen1 extends JFrame {

	// Componenti View-Panel
	JScrollPane panelCenter;
	JPanel panelSouth;

	// Componenti View-Component
	JTable listaPazienti;
	JButton mostraPazienti;

	// Componenti Model
	PazienteService pazServ;

	public Screen1(PazienteService pazServ) throws HeadlessException {
		super("Triage");
		this.pazServ = pazServ;
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
		listaPazienti = new JTable(new PazientiTable());
		listaPazienti.setFillsViewportHeight(true);

		mostraPazienti = new JButton("Aggiorna Pazienti");
		mostraPazienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Paziente> pazList = pazServ.mostraCodaPazienti();
				PazientiTable t = (PazientiTable) listaPazienti.getModel();
				t.reset(pazList);
			}
		});
	}

	public void build() {
		panelCenter = new JScrollPane(listaPazienti);

		panelSouth = new JPanel();
		panelSouth.add(mostraPazienti);

		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
	}
}

package it.haltardhrim.triage.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.haltardhrim.triage.control.Control;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	// Componenti Control
	Control control;

	// Componenti Panel
	JScrollPane panelCenter;
	JPanel panelSouth;

	// Componenti Component
	JTable lista;
	ButtonColumn dimetti;
	JButton aggiorna;
	JButton accogli;

	public MainScreen(Control control) throws HeadlessException {
		super("Triage");
		this.control = control;
		init();
		define();
		build();
		setVisible(true);
	}

	public void init() {
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void define() {
		PazientiTable table = new PazientiTable();
		lista = new JTable(table);
		lista.setFillsViewportHeight(true);
		lista.setEnabled(true);

		dimetti = new ButtonColumn(lista, PazientiTable.DIMETTI, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable lista = (JTable) e.getSource();
				int riga = Integer.valueOf(e.getActionCommand());
				PazientiTable table = (PazientiTable) lista.getModel();
				int id = (int) table.getValueAt(riga, PazientiTable.ID);

				control.dimettiClicked(id);
				fireAggiorna();
			}
		});

		aggiorna = new JButton("Aggiorna");
		aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireAggiorna();
			}
		});

		accogli = new JButton("Accogli");
		accogli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				control.accogliClicked();
			}
		});
	}

	public void build() {
		panelCenter = new JScrollPane(lista);

		panelSouth = new JPanel();
		panelSouth.add(aggiorna);
		panelSouth.add(accogli);

		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		fireAggiorna();
	}

	public void fireAggiorna() {
		PazientiTable t = (PazientiTable) lista.getModel();
		control.aggiornaClicked(t);
	}
}

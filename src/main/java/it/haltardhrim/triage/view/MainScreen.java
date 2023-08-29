package it.haltardhrim.triage.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.haltardhrim.triage.control.Control;

@SuppressWarnings("serial")
public class MainScreen extends JFrame implements ActionListener {

	// Componenti Control
	Control control;

	// Componenti Panel
	JScrollPane panelCenter;
	JPanel panelSouth;

	// Componenti Component
	JTable lista;
	PazientiTableModel model;
	ButtonColumn dimetti;
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
		model = new PazientiTableModel();
		lista = new JTable(model);
		lista.setFillsViewportHeight(true);
		lista.setEnabled(true);

		dimetti = new ButtonColumn(lista, PazientiTableModel.DIMETTI, this);

		accogli = new JButton("Accogli");
		accogli.addActionListener(this);
  	}

	public void build() {
		panelCenter = new JScrollPane(lista);

		panelSouth = new JPanel();
		panelSouth.add(accogli);

		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		fireAggiorna();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == accogli) {
			fireAccogli();
		}
		else if (o == lista) {
			int row = Integer.valueOf(e.getActionCommand().split(",",2)[0]);
			int col = Integer.valueOf(e.getActionCommand().split(",",2)[1]);

			if (col == PazientiTableModel.DIMETTI) {
				fireDimetti(row);
			}
		}
	}

	public void fireAggiorna() {
		PazientiTableModel model = (PazientiTableModel) lista.getModel();
		control.aggiornaClicked(model);
	}

	public void fireAccogli() {
		AccogliPane panel = new AccogliPane();
		int confirm = JOptionPane.showConfirmDialog(
				this,
				panel,
				"Accogli Paziente",
				JOptionPane.OK_CANCEL_OPTION);

		if (confirm == JOptionPane.OK_OPTION) {
			control.accogliClicked(
					panel.codfisc.getText(),
					panel.priorita.getSelectedIndex(),
					this);
		}
	}

	public void fireDimetti(int row) {
		int id = (int) model.getValueAt(row, PazientiTableModel.ID);

		int confirm = JOptionPane.showConfirmDialog(
				lista,
				"Sicuro di voler dimettere il paziente?",
				"Dimetti Paziente",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (confirm == JOptionPane.YES_OPTION) {
			control.dimettiClicked(id);
			fireAggiorna();
		}
	}
}

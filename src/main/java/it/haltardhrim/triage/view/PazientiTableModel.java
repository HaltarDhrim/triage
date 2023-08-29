package it.haltardhrim.triage.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import it.haltardhrim.triage.model.Paziente;

@SuppressWarnings("serial")
public class PazientiTableModel extends AbstractTableModel {

	public ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
	public String[] colonne = { "ID", "Cod.Fisc.", "Priorità", "Stato", "Dimetti" };
	public static final int ID = 0;
	public static final int CODFISC = 1;
	public static final int PRIORITA = 2;
	public static final int STATO = 3;
	public static final int DIMETTI = 4;

	@Override
	public int getRowCount() {
		return pazienti.size();
	}

	@Override
	public int getColumnCount() {
		return colonne.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Paziente p = pazienti.get(r);

		switch (c) {
		case ID:
			return p.getId();
		case CODFISC:
			return p.getCodfisc();
		case PRIORITA:
			return p.prioritaEnum[p.getPriorita()];
		case STATO:
			return p.statoEnum[p.getStato()];
		case DIMETTI:
			return colonne[DIMETTI];
			// return new ImageIcon("C:\\Users\\Mattia\\git\\triage\\res\\exit.png");
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int i) {
		return colonne[i];
	}

	public void reset(ArrayList<Paziente> list) {
		pazienti.clear();

		for (Paziente p : list) {
			pazienti.add(p);
		}
		fireTableDataChanged();
	}

	@Override
    public boolean isCellEditable(int row, int col) {
		// Solo la colonna Dimetti è editabile.
		return (col == DIMETTI);
	}

//	public Class getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}

//	public void setValueAt(Object value, int row, int col) {
//		pazienti[row][col] = value;
//		fireTableCellUpdated(row, col);
//	}
}

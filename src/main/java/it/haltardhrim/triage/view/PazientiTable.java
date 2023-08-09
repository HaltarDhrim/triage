package it.haltardhrim.triage.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import it.haltardhrim.triage.model.Paziente;

public class PazientiTable extends AbstractTableModel {

	private String[] colonne = { "Cod.Fisc.", "Priorità", "Stato" };
	private ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
	private final int CODFISC = 0;
	private final int PRIORITA = 1;
	private final int STATO = 2;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pazienti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonne.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		// TODO Auto-generated method stub
		Paziente p = pazienti.get(r);

		switch (c) {
		case CODFISC:
			return p.getCodfisc();
		case PRIORITA:
			return p.prioritaEnum[p.getPriorita()];
		case STATO:
			return p.statoEnum[p.getStato()];
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

//	public Class getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}

//	public void setValueAt(Object value, int row, int col) {
//		pazienti[row][col] = value;
//		fireTableCellUpdated(row, col);
//	}
}

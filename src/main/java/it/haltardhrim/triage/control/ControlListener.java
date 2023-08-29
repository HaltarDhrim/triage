package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.MainScreen;
import it.haltardhrim.triage.view.PazientiTableModel;

public interface ControlListener {
	public void aggiornaClicked(PazientiTableModel tableModel);

	public void accogliClicked(String codfisc, int priorita, MainScreen mainScreen);

	public void dimettiClicked(int id);
}

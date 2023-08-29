package it.haltardhrim.triage.control;

import it.haltardhrim.triage.view.MainScreen;
import it.haltardhrim.triage.view.PazientiTable;

public interface ControlListener {
	public void aggiornaClicked(PazientiTable tableModel);

	public void accogliClicked();

	public void accogliOkClicked(String codfisc, int priorita, MainScreen mainScreen);

	public void dimettiClicked(int id);
}

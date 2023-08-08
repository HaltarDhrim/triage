package it.haltardhrim.triage.model;

import java.sql.Timestamp;

/**
 * Questa classe fa parte del pattern DAO.
 * Risponde alla domanda: com'è fatto un Paziente nel DB?
 * Indica i dati che contiene, e descrive i metodi per aggiornarli in Java.
 */
public class Paziente {

	public final int ROSSO  = 1;
	public final int GIALLO = 2;
	public final int VERDE  = 3;
	public final int BIANCO = 4;

	public final int DA_VISITARE     = 1;
	public final int IN_VISITA       = 2;
	public final int IN_INTERVENTO   = 3;
	public final int IN_OSSERVAZIONE = 4;
	public final int EVASO           = 5;

	private Integer   id;
	private String    codfisc;
	private Integer   prioritaIniz; //1=Rosso, 2=Giallo, 3=Verde, 4=Bianco
	private Integer   priorita;     //1=Rosso, 2=Giallo, 3=Verde, 4=Bianco
	private Integer   stato;        //1=Da visitare, 2=In visita, 3=In intervento, 4=In osservazione, 5=Evaso
	private String    userInsert;
	private Timestamp timeInsert;
	private String    userUpdate;
	private Timestamp timeUpdate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodfisc() {
		return codfisc;
	}
	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}
	public Integer getPrioritaIniz() {
		return prioritaIniz;
	}
	public void setPrioritaIniz(Integer prioritaIniz) {
		this.prioritaIniz = prioritaIniz;
	}
	public Integer getPriorita() {
		return priorita;
	}
	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
	public Integer getStato() {
		return stato;
	}
	public void setStato(Integer stato) {
		this.stato = stato;
	}
	public String getUserInsert() {
		return userInsert;
	}
	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}
	public Timestamp getTimeInsert() {
		return timeInsert;
	}
	public void setTimeInsert(Timestamp timeInsert) {
		this.timeInsert = timeInsert;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	public Timestamp getTimeUpdate() {
		return timeUpdate;
	}
	public void setTimeUpdate(Timestamp timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
}
package controller;

import gui.AbstractTableModelKorisnici;
import gui.KorisniciJTable;
import model.Korisnik;
import model.listaKorisnika;

public class korisniciController {
	private static korisniciController instance = null;
	
	public static korisniciController getInstance() {
		if (instance == null) {
			instance = new korisniciController();
		}
		return instance;
	}
	
	private korisniciController() {}
	
	public void dodajKorisnika(String username, String password, String ime, String prezime, String tip){
		listaKorisnika.getInstance().dodajKorisnika(username, password, ime,prezime,tip);
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();		
	}
	
    public void izbrisiKorisnika(Korisnik k) {    	
    	listaKorisnika.getInstance().izbrisiKorisnika(k);
    	AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
    }
	
	public void izmeniKorisnika(String username, String password, String ime, String prezime, String tip, Korisnik k){		
		listaKorisnika.getInstance().izmeniKorisnika(username, password, ime, prezime, tip, k);
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelKorisnici model=(AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
}
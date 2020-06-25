package controller;

import gui.AbstractTableModelKorisnici;
import gui.KorisniciJTable;
import model.Korisnik;
import model.ListaKorisnika;

public class KorisniciController {
	private static KorisniciController instance = null;

	public static KorisniciController getInstance() {
		if (instance == null) {
			instance = new KorisniciController();
		}
		return instance;
	}

	private KorisniciController() {
	}

	public void dodajKorisnika(String username, String password, String ime, String prezime, String tip) {
		ListaKorisnika.getInstance().dodajKorisnika(username, password, ime, prezime, tip);
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void izbrisiKorisnika(Korisnik k) {
		ListaKorisnika.getInstance().izbrisiKorisnika(k);
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void izmeniKorisnika(String username, String password, String ime, String prezime, String tip, Korisnik k) {
		ListaKorisnika.getInstance().izmeniKorisnika(username, password, ime, prezime, tip, k);
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void promenaPosleDeserijalizacije() {
		AbstractTableModelKorisnici model = (AbstractTableModelKorisnici) KorisniciJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

}
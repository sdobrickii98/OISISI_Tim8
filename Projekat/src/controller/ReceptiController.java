package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import gui.AbstractTableModelRecepti;
import gui.ReceptiJTable;
import model.Recept;
import model.ListaRecepata;

public class ReceptiController {
	private static ReceptiController instance = null;

	public static ReceptiController getInstance() {
		if (instance == null) {
			instance = new ReceptiController();
		}
		return instance;
	}

	private ReceptiController() {
	}

	public void dodajRecept(String sifra, String lekar, String jmbg, Date datum, float ukCena) throws ParseException {
		ListaRecepata.getInstance().dodajRecept(sifra, lekar, jmbg, datum, ukCena, new ArrayList<String>());
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void izbrisiRecept(Recept r) {
		ListaRecepata.getInstance().izbrisiRecept(r);
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void IzmeniRecept(String sifra, String lekar, String jmbg, Date datum, float ukCena, Recept recept) {
		ListaRecepata.getInstance().izmeniRecept(sifra, lekar, jmbg, datum, ukCena, recept);
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void promenaPosleDeserijalizacije() {
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

}

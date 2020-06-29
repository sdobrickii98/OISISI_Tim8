package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import gui.AbstractTableModelProdavnica;
import gui.ProdavnicaJTable;
import model.ListaProdavnica;
import model.Prodavnica;

public class ProdavnicaController {
	private static ProdavnicaController instance = null;

	public static ProdavnicaController getInstance() {
		if (instance == null) {
			instance = new ProdavnicaController();
		}
		return instance;
	}

	private ProdavnicaController() {
	}

	public void dodajProdavnica(String sifra, String lekar, String jmbg, Date datum, float ukCena) throws ParseException {
		ListaProdavnica.getInstance().dodajProdavnica(sifra, lekar, jmbg, datum, ukCena, new ArrayList<String>());
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void izbrisiProdavnica(Prodavnica p) throws ParseException {
		ListaProdavnica.getInstance().izbrisiProdavnica(p);
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void IzmeniProdavnica(String sifra, String lekar, String jmbg, Date datum, float ukCena, Prodavnica prodavnica) throws ParseException {
		ListaProdavnica.getInstance().izmeniProdavnica(sifra, lekar, jmbg, datum, ukCena, prodavnica);
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void promenaPosleDeserijalizacije() {
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

}

package controller;

import gui.AbstractTableModelLekovi;
import gui.AbstractTableModelProdavnica;
import gui.AbstractTableModelRecepti;
import gui.LekoviJTable;
import gui.ProdavnicaJTable;
import gui.ReceptiJTable;
import model.Lek;
import model.ListaLekova;
import model.Prodavnica;
import model.Recept;

public class LekoviController {
	private static LekoviController instance = null;

	public static LekoviController getInstance() {
		if (instance == null) {
			instance = new LekoviController();
		}
		return instance;
	}

	private LekoviController() {
	}

	public void dodajLek(String sifra, String naziv, String proizvodjac, boolean naRecept, Float cena) {
		ListaLekova.getInstance().dodajLek(sifra, naziv, proizvodjac, naRecept, cena);
		AbstractTableModelLekovi model = (AbstractTableModelLekovi) LekoviJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void izbrisiLek(Lek l) {
		ListaLekova.getInstance().izbrisiLek(l);
		AbstractTableModelLekovi model = (AbstractTableModelLekovi) LekoviJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void IzmeniLek(String sifra, String naziv, String proizvodjac, Boolean naRecept, Float cena, Lek lek) {
		ListaLekova.getInstance().izmeniLek(sifra, naziv, proizvodjac, naRecept, cena, lek);
		AbstractTableModelLekovi model = (AbstractTableModelLekovi) LekoviJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void DodavanjeLekaNaRecept(Recept recept, String sifra) {
		ListaLekova.getInstance().DodajLekNaRecept(recept, sifra);
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

	public void UklanjanjeLekaSaRecepta(Recept recept, String sifra) {
		ListaLekova.getInstance().UkloniLekSaRecepta(recept, sifra);
		AbstractTableModelRecepti model = (AbstractTableModelRecepti) ReceptiJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void DodavanjeLekaUKorpu(Prodavnica prodavnica, String sifra) {
		ListaLekova.getInstance().DodajLekUKorpu(prodavnica, sifra);
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void DodavanjeCelogReceptaUKorpu(Prodavnica prodavnica, String sifra) {
		ListaLekova.getInstance().DodajCeoReceptUKorpu(prodavnica, sifra);
		AbstractTableModelProdavnica model = (AbstractTableModelProdavnica) ProdavnicaJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}	

	public void promenaPosleDeserijalizacije() {
		AbstractTableModelLekovi model = (AbstractTableModelLekovi) LekoviJTable.getInstance().getModel();
		model.fireTableDataChanged();
	}

}

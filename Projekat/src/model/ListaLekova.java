package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controller.LekoviController;

public class ListaLekova implements Serializable {
	private static final long serialVersionUID = 1L;
	private static ListaLekova instance = null;

	public static ListaLekova getInstance() {
		if (instance == null) {
			instance = new ListaLekova();
		}
		return instance;
	}

	private List<Lek> lekovi;
	private List<String> kolone;

	private ListaLekova() {
		initLekove();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Proizvodjac");
		this.kolone.add("NaRecept");
		this.kolone.add("Cena");
	}

	public List<Lek> getLekovi() {
		return lekovi;
	}

	public void setLek(List<Lek> lekovi) {
		this.lekovi = lekovi;
	}

	public int getColumnCount() {
		return 5;
	}

	public Lek getRow(int rowIndex) {
		return this.lekovi.get(rowIndex);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public String getValueAt(int row, int column) {
		Lek lekovi = this.lekovi.get(row);
		switch (column) {
		case 0:
			return lekovi.getSifra();
		case 1:
			return lekovi.getNaziv();
		case 2:
			return lekovi.getProizvodjac();
		case 3:
			return lekovi.getNaRecept().toString();
		case 4:
			return lekovi.getCena().toString();
		default:
			return null;
		}
	}

	public void initLekove() {
		this.lekovi = new ArrayList<Lek>();
		// lekovi.add(new Lek("H1","HIPER HAMA GEL","Imela farmacija", true, (float)
		// 211.5));
		// lekovi.add(new Lek("H2","HIPER UREA KREM","Imela farmacija", true, (float)
		// 111.5));
		// lekovi.add(new Lek("H1","HIPER NOCURAK GEL","Imela farmacija", true, (float)
		// 311.5));
		// lekovi.add(new Lek("G1","ASPIRIN","Galenika", true, (float) 11.5));
	}

	public void dodajLek(Lek lek) {
		this.lekovi.add(lek);
	}

	public void dodajLek(String sifra, String naziv, String proizvodjac, boolean naRecept, Float cena) {
		this.lekovi.add(new Lek(sifra, naziv, proizvodjac, naRecept, cena));
	}

	public void izbrisiLek(Lek l) {
		lekovi.remove(l);
	}

	public void izbrisiLek(String sifra) {
		for (Lek l : lekovi) {
			if (l.getSifra() == sifra) {
				lekovi.remove(l);
				break;
			}
		}
	}

	public void izmeniLek(String sifra, String naziv, String proizvodjac, boolean naRecept, Float cena, Lek lek) {
		lek.setSifra(sifra);
		lek.setNaziv(naziv);
		lek.setProizvodjac(proizvodjac);
		lek.setNaRecept(naRecept);
		lek.setCena(cena);
	}

	public void serijalizacijaLekova() {
		try {
			FileOutputStream fLekova = new FileOutputStream("lekovi.ser");
			ObjectOutputStream lekOut = new ObjectOutputStream(fLekova);
			lekOut.writeObject(ListaLekova.getInstance().getLekovi());

			lekOut.close();
			fLekova.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserijalizacijaLekova() {
		try {
			FileInputStream fLekova = new FileInputStream("lekovi.ser");
			ObjectInputStream lekoviIn = new ObjectInputStream(fLekova);
			@SuppressWarnings("unchecked")
			ArrayList<Lek> lekovi = (ArrayList<Lek>) lekoviIn.readObject();
			ListaLekova.getInstance().setLek(lekovi);
			LekoviController.getInstance().promenaPosleDeserijalizacije();

			fLekova.close();
			lekoviIn.close();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {

			cnf.printStackTrace();
		}
	}

	public void DodajLekNaRecept(Recept recept, String sifra) {
		int exists = 0;
		for (Lek l : ListaLekova.getInstance().getLekovi()) {

			if (l.getSifra().equals(sifra)) {
				exists = 1;
				if (!recept.getSpisakLekova().contains(sifra)) {
					recept.getSpisakLekova().add(sifra);
				} else {
					JOptionPane.showMessageDialog(null, "Lek je veæ na receptu!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (exists == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji lek sa tom šifrom!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void UkloniLekSaRecepta(Recept recept, String sifra) {
				if (recept.getSpisakLekova().contains(sifra)) {
					recept.getSpisakLekova().remove(sifra);
				} else {
					JOptionPane.showMessageDialog(null, "Lek nije na receptu!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}
	}
	
	public void DodajLekUKorpu(Prodavnica prodavnica, String sifra) {
		int exists = 0;
		for (Lek l : ListaLekova.getInstance().getLekovi()) {

			if (l.getSifra().equals(sifra)) {
				exists = 1;
				if (!prodavnica.getSpisakLekova().contains(sifra) && !l.getNaRecept()) {
					prodavnica.getSpisakLekova().add(sifra);
				} else {
					JOptionPane.showMessageDialog(null, "Lek je veæ u korpi ili se izdaje samo na recept!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (exists == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji lek sa tom šifrom!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DodajCeoReceptUKorpu(Prodavnica prodavnica, String sifra) {
		int exists = 0;
		for (Lek l : ListaLekova.getInstance().getLekovi()) {

			if (l.getSifra().equals(sifra)) {
				exists = 1;
				if (!prodavnica.getSpisakLekova().contains(sifra)) {
					prodavnica.getSpisakLekova().add(sifra);
				} else {
					JOptionPane.showMessageDialog(null, "Lek je veæ u korpi!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (exists == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji lek sa tom šifrom!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
	}		
}

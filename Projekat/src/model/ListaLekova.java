package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
}

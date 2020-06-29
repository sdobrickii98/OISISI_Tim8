package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import controller.ReceptiController;

public class ListaRecepata implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ListaRecepata instance = null;

	public static ListaRecepata getInstance() {
		if (instance == null) {
			instance = new ListaRecepata();
		}
		return instance;
	}

	private List<Recept> recepti;
	private List<String> kolone;

	private ListaRecepata() {
		initRecepte();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Lekar");
		this.kolone.add("JMBG");
		this.kolone.add("Datum");
		this.kolone.add("Ukupna cena");
	}

	public List<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}

	public int getColumnCount() {
		return 5;
	}

	public Recept getRow(int rowIndex) {
		return this.recepti.get(rowIndex);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public String getValueAt(int row, int column) {
		Recept recept = this.recepti.get(row);
		switch (column) {
		case 0:
			return ((Recept) recept).getSifra();
		case 1:
			return ((Recept) recept).getLekar();
		case 2:
			return ((Recept) recept).getJmbg();
		case 3:
			return ((Recept) recept).getDatum().toString();
		case 4:
			return String.valueOf(((Recept) recept).getUkCena());
		default:
			return null;
		}
	}

	public void initRecepte() {
		this.recepti = new ArrayList<Recept>();
		// recepti.add(new Recept("1","lekar1", "0611968800034", new
		// SimpleDateFormat("dd.MM.yyyy").parse("30.05.2020") , (float) 123.45,new
		// ArrayList<String>()));

	}

	public void dodajRecepti(Recept recept) {
		this.recepti.add(recept);
	}

	public void dodajRecept(String sifra, String lekar, String jmbg, Date datum, float ukCena,
			ArrayList<String> spisakLekova) {
		this.recepti.add(new Recept(sifra, lekar, jmbg, datum, ukCena, spisakLekova));
	}

	public void izbrisiRecept(Recept r) {
		recepti.remove(r);

	}

	public void izmeniRecept(String sifra, String lekar, String jmbg, Date datum, float ukCena, Recept recept) {
		recept.setSifra(sifra);
		recept.setLekar(lekar);
		recept.setJmbg(jmbg);
		recept.setDatum(datum);
		recept.setUkCena(ukCena);
	}
	
	public Recept NadjiReceptPoSifri(String sifra) {
		Recept IzabraniRecept = null;
		for (Recept r : ListaRecepata.getInstance().getRecepti()) {
			if (r.getSifra().equals(sifra)) {
				IzabraniRecept = r;
			}
		}
		return IzabraniRecept;
	}

	public void serijalizacijaRecepta() {
		try {
			FileOutputStream fRecepta = new FileOutputStream("recepti.ser");
			ObjectOutputStream receptOut = new ObjectOutputStream(fRecepta);
			receptOut.writeObject(ListaRecepata.getInstance().getRecepti());

			receptOut.close();
			fRecepta.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserijalizacijaRecepta() {
		try {
			System.out.println("\n\n");
			FileInputStream fRecepta = new FileInputStream("recepti.ser");
			ObjectInputStream receptiIn = new ObjectInputStream(fRecepta);
			@SuppressWarnings("unchecked")
			ArrayList<Recept> recepti = (ArrayList<Recept>) receptiIn.readObject();
			ListaRecepata.getInstance().setRecepti(recepti);
			ReceptiController.getInstance().promenaPosleDeserijalizacije();

			fRecepta.close();
			receptiIn.close();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {

			cnf.printStackTrace();
		}
	}

}

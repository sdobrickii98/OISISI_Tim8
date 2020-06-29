package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import controller.ProdavnicaController;

public class ListaProdavnica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ListaProdavnica instance = null;

	public static ListaProdavnica getInstance() {
		if (instance == null) {
			instance = new ListaProdavnica();
		}
		return instance;
	}

	private List<Prodavnica> prodavnica;
	private List<String> kolone;

	private ListaProdavnica() {
		try {
			initProdavnica();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Lekar");
		this.kolone.add("JMBG");
		this.kolone.add("Datum");
		this.kolone.add("Ukupna cena");
	}

	public List<Prodavnica> getProdavnica() {
		return prodavnica;
	}

	public void setProdavnica(List<Prodavnica> prodavnica) {
		this.prodavnica = prodavnica;
	}

	public int getColumnCount() {
		return 5;
	}

	public Prodavnica getRow(int rowIndex) {
		return this.prodavnica.get(rowIndex);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public String getValueAt(int row, int column) {
		Prodavnica prodavnica = this.prodavnica.get(row);
		switch (column) {
		case 0:
			return ((Prodavnica) prodavnica).getSifra();
		case 1:
			return ((Prodavnica) prodavnica).getLekar();
		case 2:
			return ((Prodavnica) prodavnica).getJmbg();
		case 3:
			return ((Prodavnica) prodavnica).getDatum().toString();
		case 4:
			return String.valueOf(((Prodavnica) prodavnica).getUkCena());
		default:
			return null;
		}
	}

	public void initProdavnica() throws ParseException {
		this.prodavnica = new ArrayList<Prodavnica>();
		 prodavnica.add(new Prodavnica("1","lekar1", "0611968800034", new SimpleDateFormat("dd.MM.yyyy").parse("30.05.2020") , (float) 123.45,new
		 ArrayList<String>()));

	}

	public void dodajProdavnica(Prodavnica prodavnica) {
		this.prodavnica.add(prodavnica);
	}

	public void dodajProdavnica(String sifra, String lekar, String jmbg, Date datum, float ukCena,
			ArrayList<String> spisakLekova) {
		this.prodavnica.add(new Prodavnica(sifra, lekar, jmbg, datum, ukCena, spisakLekova));
	}

	public void izbrisiProdavnica(Prodavnica r) {
		prodavnica.remove(r);
	}

	public void izmeniProdavnica(String sifra, String lekar, String jmbg, Date datum, float ukCena, Prodavnica prodavnica) {
		prodavnica.setSifra(sifra);
		prodavnica.setLekar(lekar);
		prodavnica.setJmbg(jmbg);
		prodavnica.setDatum(datum);
		prodavnica.setUkCena(ukCena);
	}

	public void serijalizacijaProdavnica() throws ParseException {
		try {
			FileOutputStream fProdavnica = new FileOutputStream("prodavnica.ser");
			ObjectOutputStream receptOut = new ObjectOutputStream(fProdavnica);
			receptOut.writeObject(ListaProdavnica.getInstance().getProdavnica());

			receptOut.close();
			fProdavnica.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserijalizacijaProdavnica() throws ParseException {
		try {
			System.out.println("\n\n");
			FileInputStream fProdavnica = new FileInputStream("prodavnica.ser");
			ObjectInputStream prodavnicaIn = new ObjectInputStream(fProdavnica);
			@SuppressWarnings("unchecked")
			ArrayList<Prodavnica> prodavnica = (ArrayList<Prodavnica>) prodavnicaIn.readObject();
			ListaProdavnica.getInstance().setProdavnica(prodavnica);
			ProdavnicaController.getInstance().promenaPosleDeserijalizacije();

			fProdavnica.close();
			prodavnicaIn.close();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {

			cnf.printStackTrace();
		}
	}

}

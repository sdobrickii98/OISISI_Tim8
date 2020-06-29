package model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Prodavnica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sifra;
	private String lekar;
	private String jmbg;
	private Date datum;
	private float ukCena;
	private ArrayList<String> spisakLekova;

	public Prodavnica() {
		super();
	}

	public Prodavnica(String sifra, String lekar, String jmbg, Date datum, float ukCena, ArrayList<String> spisakLekova) {
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbg = jmbg;
		this.datum = datum;
		this.ukCena = ukCena;
		this.spisakLekova = spisakLekova;
		;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getLekar() {
		return lekar;
	}

	public void setLekar(String lekar) {
		this.lekar = lekar;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public float getUkCena() {
		return ukCena;
	}

	public void setUkCena(float ukCena) {
		this.ukCena = ukCena;
	}

	public ArrayList<String> getSpisakLekova() {
		return spisakLekova;
	}

	public void setSpisakLekova(ArrayList<String> spisakLekova) {
		this.spisakLekova = spisakLekova;
	}
	
	public static int getMaxSifra() throws ParseException {
		int maxint = 0;
		ArrayList<String> spisak = new ArrayList<String>();
		for (Prodavnica p : ListaProdavnica.getInstance().getProdavnica()) {
			spisak.add(p.getSifra());
		}		
		String[] lista = spisak.toArray(new String[spisak.size()]);
		for (int i=0; i<lista.length; i++) {
			int vrednost = (Integer.parseInt(lista[i]));
				if (vrednost> maxint) {
					maxint=vrednost;
				}
			}
		return maxint;
	}
}

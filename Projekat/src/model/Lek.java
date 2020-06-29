package model;

import java.io.Serializable;

public class Lek implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sifra;
	private String naziv;
	private String proizvodjac;
	private Boolean naRecept;
	private Float cena;

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public Boolean getNaRecept() {
		return naRecept;
	}

	public void setNaRecept(Boolean naRecept) {
		this.naRecept = naRecept;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public Lek() {
		super();
	}

	public Lek(String sifra, String naziv, String proizvodjac, boolean naRecept, Float cena) {
		// TODO Auto-generated constructor stub
		this.sifra = sifra;
		this.naziv = naziv;
		this.proizvodjac = proizvodjac;
		this.naRecept = naRecept;
		this.cena = cena;

	}

}

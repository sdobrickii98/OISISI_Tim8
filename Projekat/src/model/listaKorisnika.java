package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import controller.korisniciController;

public class listaKorisnika implements Serializable{
	private static final long serialVersionUID = 1L;
	private static listaKorisnika instance=null;

	public static listaKorisnika getInstance() {
		if(instance==null) {
			instance=new listaKorisnika();
		}
		return instance;
	}
	
	private List<Korisnik> korisnici;
	private List<String> kolone;
	
	private listaKorisnika() {
		initKorisnike();		
		this.kolone=new ArrayList<String>();
		this.kolone.add("Username");
		this.kolone.add("Password");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Tip");
	}

	public void initKorisnike()  {
		this.korisnici = new ArrayList<Korisnik>();		
		//korisnici.add(new Korisnik("admin", "password", "Administrator", "Sistema", "Administrator"));
		//korisnici.add(new Korisnik("lekar1", "lekar1", "Darija", "Tepavčević-Kisić", "Lekar"));
		//korisnici.add(new Korisnik("apotekar1", "apotekar1", "Neki", "Apotekar", "Apotekar"));
	}
	
	public List<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnika(List<Korisnik> korisnik) {
		this.korisnici=korisnik;
	}
	
	public int getColumnCount() {
		return 5; 
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Korisnik getRow(int rowIndex) {
		return this.korisnici.get(rowIndex);
	}
	public String getValueAt(int row,int column) {
		Korisnik korisnik=this.korisnici.get(row);
		switch(column) {
		case 0:
			return korisnik.getUsername();
		case 1:
			return korisnik.getPassword();
		case 2:
			return korisnik.getIme();
		case 3:
			return korisnik.getPrezime();
		case 4:
			return korisnik.getTip();
		default:
			return null;
		}
	}
	
	public void dodajKorisnika(Korisnik korisnik) {
		this.korisnici.add(korisnik);
	}

	public void dodajKorisnika(String username, String password, String ime, String prezime, String tip) {
		this.korisnici.add(new Korisnik(username, password, ime,prezime,tip));
	}
	
	public void izbrisiKorisnika(Korisnik korisnik) {
				korisnici.remove(korisnik);
			}

	public void izmeniKorisnika(String username, String password, String ime, String prezime, String tip, Korisnik k) {
		
				k.setUsername(username);
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setPassword(password);
				k.setTip(tip);
	}

	public void serijalizacijaKorisnika() {
		try {
			FileOutputStream fKorisnika = new FileOutputStream("korisnici.ser");
			ObjectOutputStream korisnikOut = new ObjectOutputStream(fKorisnika);
			korisnikOut.writeObject(listaKorisnika.getInstance().getKorisnici());
			
			korisnikOut.close();
			fKorisnika.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserijalizacijaKorisnika() {
		try {
			FileInputStream fKorisnika = new FileInputStream("korisnici.ser");
			ObjectInputStream korisnikIn = new ObjectInputStream(fKorisnika);
			@SuppressWarnings("unchecked")
			ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) korisnikIn.readObject();
			listaKorisnika.getInstance().setKorisnika(korisnici);
		    korisniciController.getInstance().promenaPosleDeserijalizacije();
			
		    korisnikIn.close();
		    fKorisnika.close();
		}catch (IOException e) {
			
			 e.printStackTrace();
		}catch (ClassNotFoundException cnf) {
		  	 
			cnf.printStackTrace();
		}
	}
}
package jwd.modul3test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zadaci")
public class Zadatak {

	@Id
	@GeneratedValue
	@Column(name = "id")
    protected Long id;
	
	@Column(name = "ime", unique=true, nullable=false)
    protected String ime;
	
	@Column(name = "zaduzeni")
    protected String zaduzeni;
	
	@Column(name = "bodovi")
    protected int bodovi;
	
	@ManyToOne(fetch=FetchType.EAGER)
	protected Sprint sprint;
	
	@ManyToOne(fetch=FetchType.EAGER)
	protected Stanje stanje;
	
	public Zadatak() {
		super();
	}

	public Zadatak(String ime, String zaduzeni, int bodovi) {
		super();
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
	}

	public Zadatak(Long id, String ime, String zaduzeni, int bodovi) {
		super();
		this.id = id;
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZaduzeni() {
		return zaduzeni;
	}

	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	
}

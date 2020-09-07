package jwd.modul3test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sprints")
public class Sprint {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
    protected Long id;
	
	@Column(name = "ime")
    protected String ime;
	
	@Column(name = "ukupno_bodova")
    protected int ukupnoBodova;
	
	@OneToMany(mappedBy = "sprint", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    protected List<Zadatak> zadaci = new ArrayList<>();
	
	public Sprint() {
		super();
	}

	public Sprint(String ime, int ukupnoBodova) {
		super();
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
	}

	public Sprint(Long id, String ime, int ukupnoBodova) {
		super();
		this.id = id;
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
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

	public int getUkupnoBodova() {
		return ukupnoBodova;
	}

	public void setUkupnoBodova(int ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
	}

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}
	
	
}

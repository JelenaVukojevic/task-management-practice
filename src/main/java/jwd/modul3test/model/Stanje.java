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
@Table(name = "stanja")
public class Stanje {

	@Id
	@GeneratedValue
	@Column(name = "id")
    protected Long id;
	
	@Column(name = "ime")
    protected String ime;
	
	@OneToMany(mappedBy = "stanje", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    protected List<Zadatak> zadaci = new ArrayList<>();
	
	public Stanje() {
		super();
	}

	public Stanje(String ime) {
		super();
		this.ime = ime;
	}

	public Stanje(Long id, String ime) {
		super();
		this.id = id;
		this.ime = ime;
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

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}
	
	
}

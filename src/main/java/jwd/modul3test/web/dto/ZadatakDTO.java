package jwd.modul3test.web.dto;

public class ZadatakDTO {

	protected Long id;
    protected String ime;
    protected String zaduzeni;
    protected int bodovi;
    
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
    
    
}

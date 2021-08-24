/**
 * 
 */
package de.intellinet.ausbildung.rest.restkundenportal.model.request;

/**
 * @author aakh1
 *
 */
public class KontaktDTO {

	private String email;
	private String telefon;
	private String mobil;

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}

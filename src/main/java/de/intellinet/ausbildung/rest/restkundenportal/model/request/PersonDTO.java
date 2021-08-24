/**
 * 
 */

package de.intellinet.ausbildung.rest.restkundenportal.model.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author aakh1
 *
 */
public class PersonDTO {

    private Long id;
    private String vorname;
    private String name;
    private String geburtsort;
    private String geburtsname;
    private String Staatsangehoerigkeit;
    private LocalDate geburtsdatum;
    private LocalDateTime anlagedatum;
    private LocalDateTime aenderungsdatum;

    private KontaktDTO kontakt;
    private AdresseDTO adresse;

    public PersonDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long setId) {
        this.id = setId;
    }

    public KontaktDTO getKontakt() {
        return kontakt;
    }

    public void setKontakt(KontaktDTO kontakt) {
        this.kontakt = kontakt;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }

    public String getStaatsangehoerigkeit() {
        return Staatsangehoerigkeit;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public LocalDateTime getAnlagedatum() {
        return anlagedatum;
    }

    public void setAnlagedatum(LocalDateTime anlagedatum) {
        this.anlagedatum = anlagedatum;
    }

    public LocalDateTime getAenderungsdatum() {
        return aenderungsdatum;
    }

    public void setAenderungsdatum(LocalDateTime aenderungsdatum) {
        this.aenderungsdatum = aenderungsdatum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String Staatsangehoerigkeit() {
        return Staatsangehoerigkeit;
    }

    public void setStaatsangehoerigkeit(String stadtangehoerichkeit) {
        this.Staatsangehoerigkeit = stadtangehoerichkeit;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getGeburtsname() {
        return geburtsname;
    }

    public void setGeburtsname(String geburtsname) {
        this.geburtsname = geburtsname;
    }

}

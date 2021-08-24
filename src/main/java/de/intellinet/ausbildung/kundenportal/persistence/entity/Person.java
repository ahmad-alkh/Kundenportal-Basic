/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 29.01.2020
 */
public class Person implements Serializable {

    private Long id;
    private Anrede anrede;
    private String vorname;
    private String name;
    private String geburtsort;
    private String geburtsname;
    private String staatsangehoerigkeit;
    private LocalDate geburtsdatum;
    private LocalDateTime anlagedatum;
    private LocalDateTime aenderungsdatum;

    private Kontakt kontakt;
    private Adresse adresse;

    public Kontakt getKontakt() {

        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getStaatsangehoerigkeit() {
        return staatsangehoerigkeit;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String staatsangehoerigkeit() {
        return staatsangehoerigkeit;
    }

    public void setStaatsangehoerigkeit(String stadtangehoerichkeit) {
        this.staatsangehoerigkeit = stadtangehoerichkeit;
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

    public Anrede getAnrede() {
        return anrede;
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;

    }

    public void setAnrede(String anrede) {
        if (Anrede.HERR.equals(anrede)) {
            this.anrede = Anrede.HERR;
        } else if (Anrede.FRAU.equals(anrede)) {
            this.anrede = Anrede.FRAU;
        } else {
            this.anrede = Anrede.UNBEKANNT;
        }
    }

}

/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import java.time.LocalDate;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class Merkmal {

    private String kontonummer;
    private String text;
    private String typ;
    private Integer ratenzahl;
    private String ratenart;
    private String merkmalOhneGeburtsdatum;
    private String eigenesMerkmal;
    private String beschreibung;
    private String merkmalcode;
    private LocalDate datum;
    private Betrag betrag;

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getRatenzahl() {
        return ratenzahl;
    }

    public void setRatenzahl(Integer ratenzahl) {
        this.ratenzahl = ratenzahl;
    }

    public String getRatenart() {
        return ratenart;
    }

    public void setRatenart(String ratenart) {
        this.ratenart = ratenart;
    }

    public String getMerkmalOhneGeburtsdatum() {
        return merkmalOhneGeburtsdatum;
    }

    public void setMerkmalOhneGeburtsdatum(String merkmalOhneGeburtsdatum) {
        this.merkmalOhneGeburtsdatum = merkmalOhneGeburtsdatum;
    }

    public String getEigenesMerkmal() {
        return eigenesMerkmal;
    }

    public void setEigenesMerkmal(String eigenesMerkmal) {
        this.eigenesMerkmal = eigenesMerkmal;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getMerkmalcode() {
        return merkmalcode;
    }

    public void setMerkmalcode(String merkmalcode) {
        this.merkmalcode = merkmalcode;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Betrag getBetrag() {
        return betrag;
    }

    public void setBetrag(Betrag betrag) {
        this.betrag = betrag;
    }

}

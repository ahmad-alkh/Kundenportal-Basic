/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence.entity;

import java.io.Serializable;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 29.01.2020
 */
public class Adresse implements Serializable {

    private Long id;
    private Long person_id;
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String land;

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

}

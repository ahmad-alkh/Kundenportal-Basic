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
 *
 * @since 29.01.2020
 */
public class Kontakt implements Serializable {

    private Long id;
    private Long person_id;
    private String email;
    private String telefon;
    private String mobil;

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

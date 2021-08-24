/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class VerbraucherDaten {

    private Anrede anrede;
    private String nachname;
    private String vorname;
    private String schufaId;
    private String geburtsort;

    public Anrede getAnrede() {
        return anrede;
    }

    public void setAnrede(de.intellinet.services.rating.client.enums.Anrede anrede) {
        if (de.intellinet.services.rating.client.enums.Anrede.FRAU.equals(anrede)) {

            this.anrede = Anrede.FRAU;
        } else if (de.intellinet.services.rating.client.enums.Anrede.HERR.equals(anrede)) {

            this.anrede = Anrede.HERR;
        } else if (de.intellinet.services.rating.client.enums.Anrede.UNBEKANNT.equals(anrede)) {
            this.anrede = Anrede.UNBEKANNT;
        }
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getSchufaId() {
        return schufaId;
    }

    public void setSchufaId(String schufaId) {
        this.schufaId = schufaId;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }
}

/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import de.intellinet.services.rating.client.model.rest.schufa_response.Betrugspraevention.ErgebnisTyp;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class BetrugsPraevention {

    private Ergebnistyp ergebnistyp;
    private String trefferID;

    public Ergebnistyp getErgebnistyp() {
        return ergebnistyp;
    }

    public void setErgebnistyp(Ergebnistyp ergebnisTy) {
        this.ergebnistyp = ergebnisTy;
    }

    public void setErgebnistyp(ErgebnisTyp ergebnisTy) {
        if (ErgebnisTyp.ERGEBNIS_NICHT_VERFUEGBAR.equals(ergebnisTy)) {

            this.ergebnistyp = Ergebnistyp.ERGEBNIS_NICHT_VERFUEGBAR;
        } else if (ErgebnisTyp.KEIN_TREFFER.equals(ergebnisTy)) {

            this.ergebnistyp = Ergebnistyp.KEIN_TREFFER;
        } else {
            this.ergebnistyp = Ergebnistyp.TREFFER;
        }

    }

    public String getTrefferID() {
        return trefferID;
    }

    public void setTrefferID(String trefferID) {
        this.trefferID = trefferID;
    }
}

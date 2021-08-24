/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class SchufaDaten {

    private String ergebnisToken;
    private SchufaErgebnis schufaErgebnis;
    private List<Merkmal> merkmale;
    private List<ScoreInformation> scoreInformationen;
    private BetrugsPraevention betrugsPraevention;
    private VerbraucherDaten verbraucherDaten;
    private LocalDateTime anfrageDatum;

    public String getErgebnisToken() {
        return ergebnisToken;
    }

    public void setErgebnisToken(String ergebnisToken) {
        this.ergebnisToken = ergebnisToken;
    }

    public SchufaErgebnis getSchufaErgebnis() {
        return schufaErgebnis;
    }

    public void setSchufaErgebnis(de.intellinet.services.rating.client.enums.SchufaErgebnis schufaErgebnis) {

        if (SchufaErgebnis.FEHLER.equals(schufaErgebnis)) {
            this.schufaErgebnis = SchufaErgebnis.FEHLER;
        } else if (SchufaErgebnis.NACHBEHANDLUNG.equals(schufaErgebnis)) {
            this.schufaErgebnis = SchufaErgebnis.NACHBEHANDLUNG;
        } else {
            this.schufaErgebnis = SchufaErgebnis.OK;
        }
    }

    public List<Merkmal> getMerkmale() {
        return merkmale;
    }

    public void setMerkmale(List<Merkmal> merkmale) {
        this.merkmale = merkmale;
    }

    public List<ScoreInformation> getScoreInformationen() {
        return scoreInformationen;
    }

    public void setScoreInformationen(List<ScoreInformation> scoreInformationen) {
        this.scoreInformationen = scoreInformationen;
    }

    public BetrugsPraevention getBetrugsPraevention() {
        return betrugsPraevention;
    }

    public void setBetrugsPraevention(BetrugsPraevention betrugsPraevention) {
        this.betrugsPraevention = betrugsPraevention;
    }

    public VerbraucherDaten getVerbraucherDaten() {
        return verbraucherDaten;
    }

    public void setVerbraucherDaten(VerbraucherDaten verbraucherDaten) {
        this.verbraucherDaten = verbraucherDaten;
    }

    public LocalDateTime getAnfrageDatum() {
        return anfrageDatum;
    }

    public void setAnfrageDatum(LocalDateTime anfrageDatum) {
        this.anfrageDatum = anfrageDatum;

    }
}

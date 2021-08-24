/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import java.math.BigDecimal;
import java.util.List;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 08.04.2021
 */
public class ScoreInformation {

    private BetrugsPraevention betrugsPraevention;
    private String scorebereich;
    private Integer scorewert;
    private String scoretext;
    private List<String> scoreinfotext;
    private String scorefehler;
    private BigDecimal risikoquote;
    private String beschreibung;

    public BetrugsPraevention getBetrugsPraevention() {
        return betrugsPraevention;
    }

    public void setBetrugsPraevention(BetrugsPraevention betrugsPraevention) {
        this.betrugsPraevention = betrugsPraevention;
    }

    public String getScorebereich() {
        return scorebereich;
    }

    public void setScorebereich(String scorebereich) {
        this.scorebereich = scorebereich;
    }

    public Integer getScorewert() {
        return scorewert;
    }

    public void setScorewert(Integer scorewert) {
        this.scorewert = scorewert;
    }

    public String getScoretext() {
        return scoretext;
    }

    public void setScoretext(String scoretext) {
        this.scoretext = scoretext;
    }

    public List<String> getScoreinfotext() {
        return scoreinfotext;
    }

    public void setScoreinfotext(List<String> scoreinfotext) {
        this.scoreinfotext = scoreinfotext;
    }

    public String getScorefehler() {
        return scorefehler;
    }

    public void setScorefehler(String scorefehler) {
        this.scorefehler = scorefehler;
    }

    public BigDecimal getRisikoquote() {
        return risikoquote;
    }

    public void setRisikoquote(BigDecimal risikoquote) {
        this.risikoquote = risikoquote;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}

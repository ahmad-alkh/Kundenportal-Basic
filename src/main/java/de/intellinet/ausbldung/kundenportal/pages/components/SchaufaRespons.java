/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import java.util.ArrayList;
import java.util.List;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.SchaufaService;
import de.intellinet.services.rating.client.model.rest.schufa_response.Merkmal;
import de.intellinet.services.rating.client.model.rest.schufa_response.SchufaPersonResponse;
import de.intellinet.services.rating.client.model.rest.schufa_response.ScoreInformation;
import de.intellinet.services.rating.client.model.rest.schufa_response.VerbraucherDaten;

/**
 * 
 * @author ahmalk
 *
 * @since 07.04.2021
 */
public class SchaufaRespons {

    public SchufaDaten MappingSchufaDaten(Person Person) {
        SchaufaService schaufaService = new SchaufaService();
        SchufaDaten schufaDaten1 = new SchufaDaten();
        SchufaPersonResponse schufaDaten = schaufaService.getSchufaDaten(Person);
        schufaDaten1.setErgebnisToken(schufaDaten.getErgebnisToken());
        schufaDaten1.setSchufaErgebnis(schufaDaten.getSchufaErgebnis());
        schufaDaten1.setMerkmale(mappingMerkmale(schufaDaten.getMerkmale()));
        schufaDaten1.setScoreInformationen(MappingScoreInformationen(schufaDaten.getScoreInformationen()));
        schufaDaten1.setBetrugsPraevention(new BetrugsPraevention());
        schufaDaten1.getBetrugsPraevention().setErgebnistyp(schufaDaten.getBetrugsPraevention().getErgebnistyp());
        schufaDaten1.getBetrugsPraevention().setTrefferID(schufaDaten.getBetrugsPraevention().getTrefferID());
        schufaDaten1.setAnfrageDatum(schufaDaten.getAnfrageDatum());
        schufaDaten1.setVerbraucherDaten(mapinngVerbraucherDaten(schufaDaten.getVerbraucherDaten()));
        return schufaDaten1;
    }

    private de.intellinet.ausbldung.kundenportal.pages.components.VerbraucherDaten mapinngVerbraucherDaten(
            VerbraucherDaten verbraucherDaten) {
        de.intellinet.ausbldung.kundenportal.pages.components.VerbraucherDaten verbraucherDaten2 =
                new de.intellinet.ausbldung.kundenportal.pages.components.VerbraucherDaten();
        verbraucherDaten2.setAnrede(verbraucherDaten.getAnrede());
        verbraucherDaten2.setGeburtsort(verbraucherDaten.getGeburtsort());
        verbraucherDaten2.setNachname(verbraucherDaten.getNachname());
        verbraucherDaten2.setSchufaId(verbraucherDaten.getSchufaId());
        verbraucherDaten2.setVorname(verbraucherDaten.getVorname());
        return verbraucherDaten2;
    }

    private List<de.intellinet.ausbldung.kundenportal.pages.components.ScoreInformation> MappingScoreInformationen(
            List<ScoreInformation> scoreInformationen) {
        List<de.intellinet.ausbldung.kundenportal.pages.components.ScoreInformation> scoreInformationen1 =
                new ArrayList<de.intellinet.ausbldung.kundenportal.pages.components.ScoreInformation>();

        for (ScoreInformation scoreInformation : scoreInformationen) {
            de.intellinet.ausbldung.kundenportal.pages.components.ScoreInformation scoreInformation2 =
                    new de.intellinet.ausbldung.kundenportal.pages.components.ScoreInformation();
            scoreInformation2.setBeschreibung(scoreInformation.getBeschreibung());
            scoreInformation2.setRisikoquote(scoreInformation.getRisikoquote());
            scoreInformation2.setScorefehler(scoreInformation.getScorefehler());
            scoreInformation2.setScoreinfotext(scoreInformation.getScoreinfotext());
            scoreInformation2.setScoretext(scoreInformation.getScoretext());
            scoreInformation2.setScorewert(scoreInformation.getScorewert());
            scoreInformation2.setScorebereich(scoreInformation.getScorebereich());

            scoreInformationen1.add(scoreInformation2);
        }
        return scoreInformationen1;
    }

    private List<de.intellinet.ausbldung.kundenportal.pages.components.Merkmal> mappingMerkmale(
            List<Merkmal> merkmale) {
        List<de.intellinet.ausbldung.kundenportal.pages.components.Merkmal> merkmalen1 =
                new ArrayList<de.intellinet.ausbldung.kundenportal.pages.components.Merkmal>();
        for (Merkmal merkmal : merkmale) {
            de.intellinet.ausbldung.kundenportal.pages.components.Merkmal merkmal2 =
                    new de.intellinet.ausbldung.kundenportal.pages.components.Merkmal();

            merkmal2.setBetrag(new Betrag());
            merkmal2.getBetrag().setValue(merkmal.getBetrag().getValue());
            merkmal2.getBetrag().setWaehrung(merkmal.getBetrag().getWaehrung());
            merkmal2.setDatum(merkmal.getDatum());
            merkmal2.setMerkmalcode(merkmal.getMerkmalcode());
            merkmal2.setBeschreibung(merkmal.getBeschreibung());
            merkmal2.setEigenesMerkmal(merkmal.getEigenesMerkmal());
            merkmal2.setMerkmalOhneGeburtsdatum(merkmal.getMerkmalOhneGeburtsdatum());
            merkmal2.setRatenart(merkmal.getRatenart());
            merkmal2.setRatenzahl(merkmal.getRatenzahl());
            merkmal2.setText(merkmal.getText());
            merkmal2.setTyp(merkmal.getTyp());
            merkmal2.setKontonummer(merkmal.getKontonummer());

            merkmalen1.add(merkmal2);
        }
        return merkmalen1;
    }
}

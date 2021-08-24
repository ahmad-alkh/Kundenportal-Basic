/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbldung.kundenportal.pages.components;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * 
 * @author ahmalk
 *
 * @since 09.04.2021
 */
public class SchaufaResponsTest {

    private SchaufaRespons schaufaRespons = new SchaufaRespons();
    private SchufaDaten SchufaDaten = schaufaRespons.MappingSchufaDaten(person());

    @Test
    public void personDatenTest() {
        assertThat(SchufaDaten.getVerbraucherDaten().getNachname(), is("WEIN"));
        assertThat(SchufaDaten.getVerbraucherDaten().getVorname(), is("STEIN"));
        assertThat(SchufaDaten.getVerbraucherDaten().getGeburtsort(), is("FRECHEN"));
        assertThat(SchufaDaten.getVerbraucherDaten().getAnrede(), is(Anrede.HERR));
    }

    @Test
    public void hauptmerkmalTest() {
        Merkmal merkmal = SchufaDaten.getMerkmale().get(0);
        assertThat(merkmal.getBeschreibung(), is("Mitverpflichtung für Kredit"));
        assertThat(merkmal.getBetrag().getValue(), is(new BigDecimal(78525)));
        assertThat(merkmal.getBetrag().getWaehrung(), is("EUR"));
        assertThat(merkmal.getDatum(), is(LocalDate.of(2013, 02, 01)));
        assertThat(merkmal.getEigenesMerkmal(), is(nullValue()));
        assertThat(merkmal.getKontonummer(), is(nullValue()));
        assertThat(merkmal.getRatenart(), is("J"));
        assertThat(merkmal.getRatenzahl(), is(12));
        assertThat(merkmal.getText(), is(nullValue()));
        assertThat(merkmal.getTyp(), is("hauptmerkmal"));
        assertThat(merkmal.getMerkmalcode(), is("MA"));
        assertThat(merkmal.getMerkmalOhneGeburtsdatum(), is(nullValue()));
    }

    @Test
    public void scoreinfotextTest() {
        ScoreInformation scoreInformation = SchufaDaten.getScoreInformationen().get(0);
        assertThat(scoreInformation.getBeschreibung(), is("Score"));
        assertThat(scoreInformation.getScorewert(), is(9847));
        BigDecimal c = new BigDecimal(1.10);
        // double x = 1.10;
        assertThat(scoreInformation.getRisikoquote(), is(c));
        assertThat(scoreInformation.getScorebereich(), is("B"));
        assertThat(scoreInformation.getScoretext(), is("RATINGSTUFE B"));
        assertThat(scoreInformation.getScorefehler(), is(nullValue()));
        assertThat(scoreInformation.getBetrugsPraevention(), is(nullValue()));

    }

    @Test
    public void kriedetTest() {
        assertThat(SchufaDaten.getSchufaErgebnis(), is(SchufaErgebnis.OK));
        assertThat(SchufaDaten.getAnfrageDatum(), is(LocalDateTime.of(2021, 4, 7, 10, 04, 26)));

    }

    public Person person() {
        Person person = new Person();
        person.setAnrede(Anrede.HERR);
        person.setGeburtsdatum(LocalDate.of(1955, 4, 5));
        person.setGeburtsort("Frechen");
        person.setName("Wein");
        person.setVorname("Stein");

        Adresse adresse = new Adresse();
        adresse.setHausnummer("1");
        adresse.setOrt("Frankfurt");
        adresse.setLand("DE");
        adresse.setPlz("60437");
        adresse.setStrasse("Am Bier");
        adresse.setLand("DE");

        person.setAdresse(adresse);
        return person;
    }
}

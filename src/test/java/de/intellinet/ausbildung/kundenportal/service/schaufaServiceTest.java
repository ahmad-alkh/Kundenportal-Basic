/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service;

import java.time.LocalDate;

import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 18.03.2021
 */
public class schaufaServiceTest {

    SchaufaService schaufaService = new SchaufaService();

    @Test
    public void test() {
        schaufaService.getSchufaDaten(person());

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

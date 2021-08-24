/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 04.03.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonSaveAndUpdeat {

    PersonSaveRepository personSaveRepository = new PersonSaveRepository();
    IPersonReadRepository iPersonReadRepository = new PersonReadRepository();
    PersonReadRepository personRepository = new PersonReadRepository();

    static Person person;

    @BeforeClass
    public static void init() {
        person = new Person();
        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();

        person.setAnrede(Anrede.HERR);
        person.setName("Tobi");
        person.setVorname("Martin");
        person.setGeburtsdatum(LocalDate.of(1999, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Neuss");
        person.setGeburtsname(null);
        person.setStaatsangehoerigkeit("DE");
        person.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        kontakt.setEmail("tobi.martin@net.de");
        kontakt.setTelefon("02216341512");
        kontakt.setMobil("016687874683");

        adresse.setStrasse("BramsStr.");
        adresse.setPlz("56465");
        adresse.setOrt("Fschinsch");
        adresse.setLand("DE");
    }

    public void lesegespeichertenKunden() {
        Optional<Person> findById = iPersonReadRepository.findById(person.getId());

        Person findP = findById.get();
        System.out.println(ReflectionToStringBuilder.toString(findById, ToStringStyle.JSON_STYLE));
        assertThat(person.getName(), is(findP.getName()));
        assertThat(person.getStaatsangehoerigkeit(), is(findP.getStaatsangehoerigkeit()));
        assertThat(person.getGeburtsdatum(), is(findP.getGeburtsdatum()));

        // assertThat(findP.getKontakt().getId(), is(notNullValue()));
        assertThat(findP.getAdresse().getId(), is(notNullValue()));

        assertThat(person.getId(), is(findP.getKontakt().getPerson_id()));
        // assertThat(person.getId(), is(findP.getAdresse().getPerson_id()));
        assertThat(person.getAdresse().getLand(), is(findP.getAdresse().getLand()));
        // assertThat(person.getKontakt().getEmail(), is(findP.getKontakt().getEmail()));

    }

    @Test
    public void testA() throws ClassNotFoundException, SQLException {

        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));
        lesegespeichertenKunden();
    }

    @Test
    public void testB() throws SQLException {
        person.setAnrede(Anrede.HERR);
        person.setName("Karem");
        person.setVorname("Majed");
        person.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        personSaveRepository.updateKunde(person);
        lesegespeichertenKunden();
    }

}

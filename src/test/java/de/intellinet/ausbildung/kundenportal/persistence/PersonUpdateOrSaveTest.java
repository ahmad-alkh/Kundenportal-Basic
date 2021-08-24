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
 * @since 05.03.2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonUpdateOrSaveTest {

    PersonSaveRepository personSaveRepository = new PersonSaveRepository();
    IPersonReadRepository iPersonReadRepository = new PersonReadRepository();
    PersonReadRepository personRepository = new PersonReadRepository();

    static Person person;

    @BeforeClass
    public static void init() {
        person = new Person();
        // person.setKontakt(new Kontakt());
        // kontakt = person.getKontakt();
        person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();
        person.setAnrede(Anrede.HERR);
        person.setName("Aljamal");
        person.setVorname("Jussen");
        person.setGeburtsdatum(LocalDate.of(1999, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Neuss");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        adresse.setStrasse("SamStr.");
        adresse.setPlz("66544");
        adresse.setOrt("londerich");
        adresse.setLand("DE");

    }

    public void lesegespeichertenKunden(Long id) {
        Optional<Person> findById = iPersonReadRepository.findById(id);

        Person findP = findById.get();

        assertThat(person.getName(), is(findP.getName()));
        assertThat(person.getStaatsangehoerigkeit(), is(findP.getStaatsangehoerigkeit()));
        assertThat(person.getGeburtsdatum(), is(findP.getGeburtsdatum()));

        // assertThat(findP.getKontakt().getId(), is(notNullValue()));
        assertThat(findP.getAdresse().getId(), is(notNullValue()));

        // assertThat(person.getId(), is(findP.getKontakt().getPerson_id()));
        assertThat(person.getId(), is(findP.getAdresse().getPerson_id()));
        assertThat(person.getAdresse().getLand(), is(findP.getAdresse().getLand()));
        // assertThat(person.getKontakt().getEmail(), is(findP.getKontakt().getEmail()));

    }

    @Test
    public void testAInsert() throws ClassNotFoundException, SQLException {

        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));
        lesegespeichertenKunden(person.getId());
    }

    @Test
    public void testBUpdate() throws SQLException, ClassNotFoundException {
        person.setAnrede(Anrede.HERR);
        person.setName("Karem");
        person.setVorname("Majed");
        person.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        kontakt.setEmail("asdjsadas@ffo.d");
        kontakt.setMobil("01445555");
        kontakt.setTelefon("00011444555");
        Adresse adresse = person.getAdresse();
        adresse.setStrasse("QramsStr.");
        adresse.setPlz("56465");
        adresse.setOrt("Fschinsch");
        adresse.setLand("DE");

        personSaveRepository.updateKunde(person);
        lesegespeichertenKunden(person.getId());
        personSaveRepository.update(person);
    }

    @Test
    public void testC() throws SQLException, ClassNotFoundException {

        assertThat(personSaveRepository.deleteKunde(person), is(true));

    }

    static Person person2 = new Person();

    @Test
    public void testDNurPersonMitKontakt() throws ClassNotFoundException, SQLException {
        person2.setAnrede(Anrede.HERR);
        person2.setName("Jomaa");
        person2.setVorname("Jamal");
        person2.setGeburtsdatum(LocalDate.of(1959, 01, 8));
        person2.setGeburtsname(null);
        person2.setGeburtsort("");
        person2.setStaatsangehoerigkeit("Leb");
        person2.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person2.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        person2.setKontakt(new Kontakt());
        Kontakt kontakt2 = person2.getKontakt();
        kontakt2.setEmail("alte92@ffo.d");
        kontakt2.setMobil("033333335");
        kontakt2.setTelefon("0333333335");
        System.out.println(person2.getKontakt() + "c");

        personSaveRepository.insert(person2);

    }

    @Test
    public void testEUpdateNurAdUndKo() throws SQLException, ClassNotFoundException {
        System.out.println(person2.getId() + "B");
        // person.setKontakt(new Kontakt());
        Kontakt kontakt2 = person2.getKontakt();

        kontakt2.setEmail("neueKontakt92@ffo.d");
        kontakt2.setMobil("01445555");
        kontakt2.setTelefon("00011444555");

        // person2.setAdresse(new Adresse());
        Adresse adresse2 = person2.getAdresse();
        adresse2.setStrasse("WramsStr.");
        adresse2.setPlz("56465");
        adresse2.setOrt("Fschinsch");
        adresse2.setLand("DE");

        personSaveRepository.update(person2);
    }

    static Person person3 = new Person();

    @Test
    public void testLNurPersonMitAdresse() throws ClassNotFoundException, SQLException {
        person3.setAnrede(Anrede.HERR);
        person3.setName("Jomaa");
        person3.setVorname("Jamal");
        person3.setGeburtsdatum(LocalDate.of(1959, 01, 8));
        person3.setGeburtsname(null);
        person3.setGeburtsort("");
        person3.setStaatsangehoerigkeit("Leb");
        person3.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person3.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        person3.setAdresse(new Adresse());
        Adresse adresse3 = person3.getAdresse();

        adresse3.setStrasse("RramsStr.");
        adresse3.setPlz("56465");
        adresse3.setOrt("Fschinsch");
        adresse3.setLand("DE");

        personSaveRepository.insert(person3);

    }

    @Test
    public void testMUpdateNurAdUndKo() throws SQLException, ClassNotFoundException {
        System.out.println(person3.getId() + "B");
        // person.setKontakt(new Kontakt());
        Kontakt kontakt3 = person3.getKontakt();

        kontakt3.setEmail("zeueKontakt92@ffo.d");
        kontakt3.setMobil("044445555");
        kontakt3.setTelefon("077744555");

        // person2.setAdresse(new Adresse());
        Adresse adresse3 = person3.getAdresse();

        adresse3.setStrasse("NasuhStr.");
        adresse3.setPlz("83302");
        adresse3.setOrt("Fassen");
        adresse3.setLand("DE");

        personSaveRepository.update(person3);
    }

    static Person person4 = new Person();

    @Test
    public void testNNurPerson() throws ClassNotFoundException, SQLException {
        person4.setAnrede(Anrede.HERR);
        person4.setName("Omaa");
        person4.setVorname("Jamal");
        person4.setGeburtsdatum(LocalDate.of(1959, 01, 8));
        person4.setGeburtsname(null);
        person4.setGeburtsort("");
        person4.setStaatsangehoerigkeit("Leb");
        person4.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person4.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        personSaveRepository.insert(person4);

    }

    @Test
    public void testOUpdateNurAdUndKo() throws SQLException, ClassNotFoundException {
        System.out.println(person4.getId() + "B");
        // person.setKontakt(new Kontakt());
        Kontakt kontakt4 = person4.getKontakt();

        kontakt4.setEmail("neueKontakt92@ffo.d");
        kontakt4.setMobil("01445555");
        kontakt4.setTelefon("00011444555");

        // person2.setAdresse(new Adresse());
        Adresse adresse4 = person4.getAdresse();
        adresse4.setStrasse("HramsStr.");
        adresse4.setPlz("56465");
        adresse4.setOrt("Fschinsch");
        adresse4.setLand("DE");

        personSaveRepository.update(person4);
    }

}

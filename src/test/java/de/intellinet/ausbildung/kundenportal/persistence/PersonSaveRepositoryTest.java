/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenSuchService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 20.02.2020
 */
@Ignore
public class PersonSaveRepositoryTest {

    PersonReadRepository personRepository = new PersonReadRepository();
    PersonSaveRepository personSaveRepository = new PersonSaveRepository();

    IPersonReadRepository dbBearbeitung = new PersonReadRepository();

    @Deprecated
    public void test() throws ClassNotFoundException, SQLException {
        Person person = new Person();
        person.setAnrede(Anrede.HERR);
        person.setName("Max");
        person.setVorname("Stein");
        person.setGeburtsdatum(LocalDate.of(1951, 01, 8));
        person.setGeburtsname(null);
        person.setGeburtsort("");
        person.setStaatsangehoerigkeit("DE");
        person.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        personSaveRepository.speicherPerson(person);

    }

    @Deprecated
    // @Test
    public void speicherkundenMitfindIdtest() throws ClassNotFoundException, SQLException {
        KundenSuchService suchKunden = new KundenSuchService();

        Person person = new Person();
        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();

        person.setName("ALnasuh");
        person.setVorname("nasieh");
        person.setGeburtsdatum(LocalDate.of(2007, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("");
        person.setStaatsangehoerigkeit("KSA");
        person.setAnlagedatum(LocalDateTime.of(2018, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        kontakt.setEmail("nasuh.ALnasuh@net.de");
        kontakt.setTelefon("00316341512");
        kontakt.setMobil("015687874683");

        adresse.setStrasse("NasuhStr.");
        adresse.setPlz("83302");
        adresse.setOrt("Fassen");
        adresse.setLand("DE");

        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));

        Optional<Person> findById = dbBearbeitung.findById(person.getId());

        Person findP = findById.get();
        assertThat(person.getName(), is(findP.getName()));
        assertThat(person.getStaatsangehoerigkeit(), is(findP.getStaatsangehoerigkeit()));
        assertThat(person.getGeburtsdatum(), is(findP.getGeburtsdatum()));

        assertThat(findP.getKontakt().getId(), is(notNullValue()));
        assertThat(findP.getAdresse().getId(), is(notNullValue()));

        assertThat(person.getId(), is(findP.getKontakt().getPerson_id()));
        assertThat(person.getId(), is(findP.getAdresse().getPerson_id()));
        assertThat(person.getAdresse().getLand(), is(findP.getAdresse().getLand()));
        assertThat(person.getKontakt().getEmail(), is(findP.getKontakt().getEmail()));
    }

    @Deprecated
    @Test
    public void findIdtest011() throws ClassNotFoundException, SQLException {

        KundenSuchService suchKunden = new KundenSuchService();
        PersonReadRepository bearbeitung = new PersonReadRepository();
        long c = 34;
        // bearbeitung.findId(54);
        Optional<Person> sucheId = suchKunden.findId(c);
        // assertThat(sucheId, hasSize(1));

    }

    @Test
    public void speicherkunden() throws ClassNotFoundException, SQLException {
        KundenSuchService suchKunden = new KundenSuchService();

        Person person = new Person();
        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();

        person.setName("Tahsen");
        person.setVorname("Alsabi");
        person.setGeburtsdatum(LocalDate.of(2001, 01, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Neuss");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        kontakt.setEmail("grigor.Kurz@net.de");
        kontakt.setTelefon("02216341512");
        kontakt.setMobil("016687874683");

        adresse.setStrasse("BramsStr.");
        adresse.setPlz("56465");
        adresse.setOrt("Fschinsch");
        adresse.setLand("DE");

        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));

        Optional<Person> findById = dbBearbeitung.findById(person.getId());

        Person findP = findById.get();
        assertThat(person.getName(), is(findP.getName()));
        assertThat(person.getStaatsangehoerigkeit(), is(findP.getStaatsangehoerigkeit()));
        assertThat(person.getGeburtsdatum(), is(findP.getGeburtsdatum()));

        // assertThat(findP.getKontakt().getId(), is(notNullValue()));
        assertThat(findP.getAdresse().getId(), is(notNullValue()));

        assertThat(person.getId(), is(findP.getKontakt().getPerson_id()));
        // assertThat(person.getId(), is(findP.getAdresse().getPerson_id()));
        assertThat(person.getAdresse().getLand(), is(findP.getAdresse().getLand()));
        // assertThat(person.getKontakt().getEmail(),
        // is(findP.getKontakt().getEmail()));

    }

    @Deprecated
    @Test
    public void findIdtest01() throws ClassNotFoundException, SQLException {

        KundenSuchService suchKunden = new KundenSuchService();
        PersonReadRepository bearbeitung = new PersonReadRepository();
        long c = 34;
        // bearbeitung.findId(54);
        Optional<Person> sucheId = suchKunden.findId(c);
        // assertThat(sucheId, hasSize(1));

    }

    @Test
    public void adressetest02() throws ClassNotFoundException, SQLException {

        PersonSaveRepository personSaveRepository = new PersonSaveRepository();
        assertThat(personSaveRepository.speicherAdresse(null), is(nullValue()));
        assertThat(personSaveRepository.speicherAdresse(null), is(nullValue()));

    }

    @Test
    public void adressetest03() throws ClassNotFoundException, SQLException {

        PersonSaveRepository personSaveRepository = new PersonSaveRepository();

        Person person = new Person();
        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());
        Adresse adresse1 = person.getAdresse();

        person.setName("Kurz");
        person.setVorname("Grigor");
        person.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        adresse1.setStrasse("BramsStr.");
        adresse1.setPlz("56465");
        adresse1.setOrt("Fschinsch");
        adresse1.setLand("DE");
        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));

        assertThat(personSaveRepository.speicherAdresse(adresse1), is(notNullValue()));

    }

    @Test
    public void kontakttest02() throws ClassNotFoundException, SQLException {

        PersonSaveRepository personSaveRepository = new PersonSaveRepository();
        assertThat(personSaveRepository.speicherKontakt(null), is(nullValue()));
        assertThat(personSaveRepository.speicherKontakt(null), is(nullValue()));

    }

    @Test
    public void kontakttest03() throws ClassNotFoundException, SQLException {

        PersonSaveRepository personSaveRepository = new PersonSaveRepository();

        Person person = new Person();
        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());

        person.setName("Hane");
        person.setVorname("Bass");
        person.setGeburtsdatum(LocalDate.of(1987, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("Ss");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        kontakt.setEmail("hane.bass@net.de");
        kontakt.setTelefon("02216341512");
        kontakt.setMobil("01554549789");

        // update
        personSaveRepository.insert(person);
        assertThat(person.getId(), is(notNullValue()));

        assertThat(personSaveRepository.speicherKontakt(kontakt), is(notNullValue()));

    }

    Person person = new Person();

    @Test
    public void UKtest() throws SQLException {
        long l = 112;
        person.setId(l);
        person.setName("Karem");
        person.setVorname("Majed");

        person.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("De");
        person.setAnlagedatum(LocalDateTime.of(2015, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 01, 06, 12, 11, 11));

        // kundenHinzufuegen.insert(person);
        assertThat(personSaveRepository.updateKunde(person), is(true));
    }

    @Test
    public void UKAtest() throws SQLException {

        person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();

        long l = 110;
        adresse.setId(l);
        adresse.setStrasse("SdoerStr.");
        adresse.setHausnummer("98");
        adresse.setLand("Fn");
        adresse.setOrt("Neustadt");
        adresse.setPlz("65777");

        assertThat(personSaveRepository.updateAdresse(adresse), is(true));
    }

    @Test
    public void UKKtest() throws SQLException {

        person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        person.setAdresse(new Adresse());

        long l = 100;
        kontakt.setId(l);
        kontakt.setEmail("asdjsadas@ffo.d");
        kontakt.setMobil("01445555");
        kontakt.setTelefon("00011444555");

        assertThat(personSaveRepository.updateKontakt(kontakt), is(true));
    }

}

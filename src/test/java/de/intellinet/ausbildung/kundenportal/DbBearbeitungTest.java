/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.IPersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.PersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 24.01.2020
 */
public class DbBearbeitungTest {

    private IPersonReadRepository dbBearbeitung = new PersonReadRepository();

    @Test
    public void testGetKundenDaten() throws ClassNotFoundException, SQLException {
        List<Person> rs = dbBearbeitung.findAll();

        // for (Person person : rs) {
        //
        // System.out.println(person);
        // }

        assertEquals(rs.size(), 6);
        assertEquals(rs.contains("dd"), false);
        assertEquals("Jennes", rs.get(1).getVorname());
        assertEquals("Stein", rs.get(1).getName());
        assertEquals("De", rs.get(1).getStaatsangehoerigkeit());
        assertEquals(LocalDate.of(2002, 02, 02), rs.get(1).getGeburtsdatum());
        assertEquals("Hammstraße", rs.get(1).getAdresse().getStrasse());
        assertEquals("56", rs.get(1).getAdresse().getHausnummer());
        assertEquals("Bielfeld", rs.get(1).getAdresse().getOrt());
        assertEquals("stein@net.de", rs.get(1).getKontakt().getEmail());
        assertEquals(null, rs.get(1).getKontakt().getMobil());

        // System.out.println(rs.get(1));

        // Person person = new Person();
        //
        // CollectionUtils.isNotEmpty(rs);
        //
        // CollectionUtils.isEmpty(rs);
        // rs.isEmpty();
        //
        // assertTrue(rs.isEmpty() == true);

        // assertEquals(rs.get(1).substring(0, 1), "2");
    }

    @Test
    public void testGetKundenDaten02() throws ClassNotFoundException, SQLException {
        List<Person> rs = dbBearbeitung.findAll();

        assertEquals("Ahmad", rs.get(0).getVorname());
        assertEquals("Alkhatib", rs.get(0).getName());
        assertEquals("Syrain", rs.get(0).getStaatsangehoerigkeit());
        assertEquals(LocalDate.of(1996, 06, 07 + 1), rs.get(0).getGeburtsdatum());
        assertEquals("Norkstrße", rs.get(0).getAdresse().getStrasse());
        assertEquals("48", rs.get(0).getAdresse().getHausnummer());
        assertEquals("Frechen", rs.get(0).getAdresse().getOrt());
        assertEquals("ahmad.kh@gmail.com", rs.get(0).getKontakt().getEmail());
        assertEquals("00155854588696", rs.get(0).getKontakt().getMobil());

    }

    @Test
    public void testGetKundenDaten03() throws ClassNotFoundException, SQLException {
        List<Person> rs = dbBearbeitung.findAll();

        assertEquals("Christian", rs.get(5).getVorname());
        assertEquals("Niehoff", rs.get(5).getName());
        assertEquals("De", rs.get(5).getStaatsangehoerigkeit());
        assertEquals(LocalDate.of(1975, 07, 02), rs.get(5).getGeburtsdatum());
        assertEquals(null, rs.get(5).getAdresse().getStrasse());
        assertEquals(null, rs.get(5).getAdresse().getHausnummer());
        assertEquals(null, rs.get(5).getAdresse().getOrt());
        assertEquals(null, rs.get(5).getKontakt().getEmail());
        assertEquals(null, rs.get(5).getKontakt().getMobil());

    }

    // @Test
    // public void testCollections() {
    // List<Integer> liste = null;
    //
    // assertTrue(CollectionUtils.isEmpty(liste));
    // assertTrue(liste != null && liste.isEmpty());
    // }
    //
    // @Test
    // public void testCollections2() {
    // List<Integer> liste = new ArrayList<Integer>();
    //
    // assertTrue(CollectionUtils.isEmpty(liste));
    // assertTrue(liste.isEmpty());
    // }
    //
    // @Test
    // public void testCollections3() {
    // List<Integer> liste = new ArrayList<Integer>();
    // liste.add(1);
    //
    // assertTrue(!CollectionUtils.isEmpty(liste));
    // assertTrue(!liste.isEmpty());
    // }

}

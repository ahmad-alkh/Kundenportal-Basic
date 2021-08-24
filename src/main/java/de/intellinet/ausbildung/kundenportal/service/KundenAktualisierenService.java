/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import de.intellinet.ausbildung.kundenportal.persistence.IPersonSaveRepository;
import de.intellinet.ausbildung.kundenportal.persistence.PersonSaveRepository;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 27.03.2020
 */
public class KundenAktualisierenService {

    private IPersonSaveRepository dbBearbeitung = new PersonSaveRepository();

    public void update(Person person) throws ClassNotFoundException, SQLException {
        dbBearbeitung.update(person);
    }

    public void hinzufuegen(Person person) throws ClassNotFoundException, SQLException {
        if (person.getAnlagedatum() == null)
            person.setAnlagedatum(LocalDateTime.now());
        person.setAenderungsdatum(LocalDateTime.now());
        dbBearbeitung.insert(person);
    }

    public void loeschePerson(Person person) throws SQLException {
        dbBearbeitung.deleteKunde(person);
    }
}

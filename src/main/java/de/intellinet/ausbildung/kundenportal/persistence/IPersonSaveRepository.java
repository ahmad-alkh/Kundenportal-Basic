
package de.intellinet.ausbildung.kundenportal.persistence;

import java.sql.SQLException;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

public interface IPersonSaveRepository {

    void insert(Person person) throws ClassNotFoundException, SQLException;

    long speicherPerson(Person person) throws ClassNotFoundException, SQLException;

    Long speicherKontakt(Kontakt kontakt) throws ClassNotFoundException, SQLException;

    Long speicherAdresse(Adresse adresse) throws ClassNotFoundException, SQLException;

    void update(Person person) throws ClassNotFoundException, SQLException;

    boolean updateKunde(Person person) throws SQLException;

    boolean updateAdresse(Adresse adresse) throws SQLException;

    boolean updateKontakt(Kontakt kontakt) throws SQLException;

    boolean deleteKunde(Person person) throws SQLException;
}

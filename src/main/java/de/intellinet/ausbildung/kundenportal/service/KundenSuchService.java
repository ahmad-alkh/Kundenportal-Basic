/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import de.intellinet.ausbildung.kundenportal.persistence.IPersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.PersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 07.02.2020
 */
public class KundenSuchService implements Serializable {

	private IPersonReadRepository dbRead = new PersonReadRepository();
	// private IPersonSaveRepository dbBearbeitung = new PersonSaveRepository();

	public List<Person> sucheNachName(String eingabe) throws ClassNotFoundException, SQLException {
		// ein neuen methed erstellen
		return dbRead.findByName(eingabe);
	}

	public List<Person> sucheVorUndNachName(String eingabe, String eingabe2)
			throws ClassNotFoundException, SQLException {
		List<Person> ergebnis = dbRead.findByVorAndName(eingabe, eingabe2); // ein neuen methed erstellen

		return ergebnis;
	}

	public List<Person> sucheNachVorOderNachNameOderGeburtsdatum(String name, String vorname, LocalDate geburtsdatum)
			throws ClassNotFoundException, SQLException {
		// List<Person> ergebnis = dbBearbeitung.findByVorAndNameAndGe(name, vorname,
		// geburtsdatum); // ein
		// neuen methed
		List<Person> ergebnis = dbRead.findByOptionalNameAndVornameAndGeburtsdatum(name, vorname, geburtsdatum); // ein
		// neuen methed erstellen

		return ergebnis;
	}

	public Optional<Person> findId(long id) throws ClassNotFoundException, SQLException {

		Optional<Person> ergebnis = dbRead.findById(id); // ein neuen methed

		return ergebnis;
	}

	public List<Person> sucheAlle() {
		return dbRead.findAll();
	}

	@Deprecated
	public List<Person> sucheNachNname(String eingabe) throws ClassNotFoundException, SQLException {
		List<Person> rs = dbRead.findAll();

		List<Person> ergebnis = new ArrayList<Person>();

		for (int i = 0; i < rs.size(); i++) {
			if (StringUtils.equals(eingabe, rs.get(i).getName())) {
				// ist die Name gleich, dann index speichern in tempArray
				ergebnis.add(rs.get(i));
			}
		}

		return ergebnis;
	}
}

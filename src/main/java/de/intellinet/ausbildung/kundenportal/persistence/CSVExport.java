/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 24.06.2020
 */
public class CSVExport implements Serializable {

	/**
	 * TODO Comment
	 */
	private static Logger logger = LoggerFactory.getLogger(CSVExport.class);

	/**
	 * Constructor.
	 * 
	 * @throws IOException
	 *
	 */
	public void exportCsv(Appendable input, Iterable<Person> personen) throws IOException {
		try {
			// hier wird die Kopf Zeile Initialisiert
			CSVPrinter printer = new CSVPrinter(input, CSVFormat.DEFAULT.withHeader("ID" //
					, "Name" //
					, "Vorname" //
					, "Geburtsort" //
					, "Staatsangehoerigkeit" //
					, "Geburtsdatum" //
					, "Geburtsname" //
					, "Anlagedatum" //
					, "Aenderungsdatum", "Strasse"//
					, "Hausnummer"//
					, "Plz"//
					, "Ort"//
					, "Land"//
					, "E-Mail"//
					, "Telefon"//
					, "Mobil"));

			schreibPerson(printer, personen); // hier wird die Datei geschrieben

		} catch (IOException e) {
			logger.error("Fehler beim Datei export");
			throw new RuntimeException("Fehler beim Datei export", e);
		} finally {
		}
	}

	/**
	 * @param printer
	 * @param personen
	 * @throws IOException
	 */
	private void schreibPerson(CSVPrinter printer, Iterable<Person> personen) throws IOException {
		if (personen == null) {
			return;
		}

		for (Person person : personen) {
			if (person == null) {
				continue;
			}

			ArrayList<Object> iterierbaresObjekt = getInhalt(person);
			printer.printRecord(iterierbaresObjekt);
		}

	}

	// hier wird die Object Itieriert
	public ArrayList<Object> getInhalt(Person person) {
		ArrayList<Object> arrayList = new ArrayList<>();

		if (person.getId() != null) {
			arrayList.add(person.getId());
		} else {
			arrayList.add(0);
		}

		String keineAngabe = "";
		if (person.getName() != null) {
			arrayList.add(person.getName());
		} else {
			arrayList.add(keineAngabe);
		}

		if (person.getVorname() != null) {
			arrayList.add(person.getVorname());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getStaatsangehoerigkeit() != null) {
			arrayList.add(person.getStaatsangehoerigkeit());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getGeburtsdatum() != null) {
			arrayList.add(person.getGeburtsdatum());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getGeburtsort() != null) {
			arrayList.add(person.getGeburtsort());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getGeburtsname() != null) {
			arrayList.add(person.getGeburtsname());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAnlagedatum() != null) {
			arrayList.add(person.getAnlagedatum());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAenderungsdatum() != null) {
			arrayList.add(person.getAenderungsdatum());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAdresse().getStrasse() != null) {
			arrayList.add(person.getAdresse().getStrasse());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAdresse().getHausnummer() != null) {
			arrayList.add(person.getAdresse().getHausnummer());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAdresse().getPlz() != null) {
			arrayList.add(person.getAdresse().getPlz());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAdresse().getOrt() != null) {
			arrayList.add(person.getAdresse().getOrt());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getAdresse().getLand() != null) {
			arrayList.add(person.getAdresse().getLand());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getKontakt().getEmail() != null) {
			arrayList.add(person.getKontakt().getEmail());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getKontakt().getTelefon() != null) {
			arrayList.add(person.getKontakt().getTelefon());
		} else {
			arrayList.add(keineAngabe);
		}
		if (person.getKontakt().getMobil() != null) {
			arrayList.add(person.getKontakt().getMobil());
		} else {
			arrayList.add(keineAngabe);
		}

		return arrayList;
	}

}

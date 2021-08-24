/**
 * 
 */

package de.intellinet.ausbildung.kundenportal.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import de.intellinet.ausbildung.kundenportal.persistence.CSVExport;
import de.intellinet.ausbildung.kundenportal.persistence.IPersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.PersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * @author aakh1
 *
 */
public class CSVService {

	IPersonReadRepository iPersonReadRepository = new PersonReadRepository();
	CSVExport cSVExport = new CSVExport();

	public void exportPersonen(Person person) throws IOException {
		List<Person> findP = iPersonReadRepository.findByOptionalNameAndVornameAndGeburtsdatum //
		(person.getName() //
				, person.getVorname() //
				, person.getGeburtsdatum());
		// List<Person> person1 = new ArrayList<Person>();
		if (CollectionUtils.isEmpty(findP)) {
			throw new RuntimeException("Person nicht gefunden");
		}
		// person1.add(findP.get());
		FileWriter writer = new FileWriter(person.getName() + ".csv"); // hier wird die speicher Ziel gegeben
		cSVExport.exportCsv(writer, findP);
		writer.close();

	}

	public void exportAllPersonen() throws IOException {
		FileWriter writer = new FileWriter("All.csv"); // hier wird die speicher Ziel gegeben
		List<Person> findP = iPersonReadRepository.findAll();
		cSVExport.exportCsv(writer, findP);
		writer.close();

	}

}

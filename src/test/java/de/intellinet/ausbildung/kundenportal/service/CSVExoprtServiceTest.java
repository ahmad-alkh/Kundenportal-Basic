package de.intellinet.ausbildung.kundenportal.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.CSVExport;
import de.intellinet.ausbildung.kundenportal.persistence.IPersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.PersonReadRepository;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

public class CSVExoprtServiceTest {

	CSVExport cSVExoprtService = new CSVExport();
	IPersonReadRepository iPersonReadRepository = new PersonReadRepository();

	@Test
	public void exportCsvTest() throws IOException {

		ArrayList<Person> personen = new ArrayList<Person>();

//		Iterable<Person> personen = person.iterator() ;
//	

		String filename = "Ergebnis.csv";

		Person person1 = new Person();

		person1.setId(0l);
		person1.setName("Hans");
		person1.setVorname("Mueller");
		person1.setStaatsangehoerigkeit("Deutschlad");

		personen.add(person1);
		Person person2 = new Person();
		person2.setId(1l);
		person2.setName("Jan");
		person2.setVorname("Kino");
		person2.setStaatsangehoerigkeit("Deutschlad");
		personen.add(person2);
		Person person = new Person();
		person.setId(2l);
		person.setName("Sam");
		person.setVorname("Stein");
		person.setStaatsangehoerigkeit("Deutschlad");
		personen.add(person);

		FileWriter writer = new FileWriter("Ergebnis.csv"); // hier wird die speicher Ziel gegeben
		List<Person> findP = iPersonReadRepository.findByName("Hannes");
		cSVExoprtService.exportCsv(writer, findP);

		writer.close();
	}

}

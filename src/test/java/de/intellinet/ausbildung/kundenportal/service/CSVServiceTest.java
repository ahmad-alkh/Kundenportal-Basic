
package de.intellinet.ausbildung.kundenportal.service;

import java.io.IOException;

import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

public class CSVServiceTest {

	CSVService cSVService = new CSVService();

	@Test
	public void test() throws IOException {
		Person person = new Person();
		person.setName("Ahmad");
		cSVService.exportPersonen(person);

	}

	@Test
	public void findByIdTest() throws IOException {
		Person person = new Person();
		person.setVorname("Ahmad");
		cSVService.exportPersonen(person);

	}

}

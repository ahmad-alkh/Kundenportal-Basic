/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 10.02.2020
 */
@Ignore
public class SuchKundenTest {

	KundenSuchService suchKunden = new KundenSuchService();

	@Test
	public void testSuchKunden() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheNachName("Niehoff");
		assertThat(sucheNachNname, hasSize(1));
		Person person = sucheNachNname.get(0);
		assertThat(person.getVorname(), is("Christian"));
		assertThat(person.getStaatsangehoerigkeit(), is("De"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(1975, 07, 02)));
		// System.out.println(suchKunden.sucheNachNname("Ahmad"));

	}

	@Test
	public void testSuchKunden2() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheNachName("stein");
		assertThat(sucheNachNname, hasSize(2));
		Person person = sucheNachNname.get(0);
		assertThat(person.getVorname(), is("Jennes"));
		assertThat(person.getStaatsangehoerigkeit(), is("De"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(2002, 02, 02)));

		// // System.out.println(suchKunden.sucheNachNname("Ahmad"));
		//
		// }
		//
		// @Test
		// public void testSuchKunden_SqlInjection() throws ClassNotFoundException,
		// SQLException {
		//
		// List<Person> sucheNachNname = suchKunden.sucheNachName("'\"\";CREATE DATABASE
		// SQLINJECT;'");
		// assertThat(sucheNachNname, hasSize(2));
		// Person person = sucheNachNname.get(0);
		// assertThat(person.getVorname(), is("Jennes"));
		// assertThat(person.getStaatsangehoerigkeit(), is("De"));
		// assertThat(person.getGeburtsdatum(), is(LocalDate.of(2002, 02, 02)));
		//
		// // System.out.println(suchKunden.sucheNachNname("Ahmad"));

	}

	@Test
	public void findByVorORName() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheVorUndNachName("stein", "Jennes");
		assertThat(sucheNachNname, hasSize(1));
		Person person = sucheNachNname.get(0);
		assertThat(person.getVorname(), is("Jennes"));
		assertThat(person.getStaatsangehoerigkeit(), is("De"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(2002, 02, 02)));
	}

	@Test
	public void findByVorAndNameAndGe() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheNachVorOderNachNameOderGeburtsdatum(null, null,
				LocalDate.of(2002, 02, 02));
		assertThat(sucheNachNname, hasSize(1));
		Person person = sucheNachNname.get(0);
		assertThat(person.getVorname(), is("Jennes"));
		assertThat(person.getStaatsangehoerigkeit(), is("De"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(2002, 02, 02)));
	}

	@Test
	public void findByVorOrNameOoGe() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheNachVorOderNachNameOderGeburtsdatum(null, "Ahmad", null);
		assertThat(sucheNachNname, hasSize(1));
		Person person = sucheNachNname.get(0);
		assertThat(person.getName(), is("Alkhatib"));
		assertThat(person.getStaatsangehoerigkeit(), is("Syrain"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(1996, 06, 8)));
	}

	@Test
	public void findByVorOrNameOoGe01() throws ClassNotFoundException, SQLException {

		List<Person> sucheNachNname = suchKunden.sucheNachVorOderNachNameOderGeburtsdatum("Frisch", null, null);
		assertThat(sucheNachNname, hasSize(1));
		Person person = sucheNachNname.get(0);
		assertThat(person.getVorname(), is("Jrgen"));
		assertThat(person.getStaatsangehoerigkeit(), is("Ostreich"));
		assertThat(person.getGeburtsdatum(), is(LocalDate.of(1959, 01, 8)));
	}
	// @Test
	// public void findByVorANDNameANDGe() throws ClassNotFoundException,
	// SQLException {
	//
	// List<Person> sucheNachNname = suchKunden.sucheNachName("", "",
	// LocalDate.of(1996, 06, 8));
	// assertThat(sucheNachNname, hasSize(1));
	// Person person = sucheNachNname.get(0);
	// assertThat(person.getVorname(), is("Ahmad"));
	// assertThat(person.getStaatsangehoerigkeit(), is("Syrain"));
	// // assertThat(person.getGeburtsdatum(), is(LocalDate.of(2002, 02, 02)));
	// }
}

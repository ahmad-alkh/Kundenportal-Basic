/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 20.02.2020
 */
public interface IPersonReadRepository {

    public Optional<Person> findById(Long id);

    public List<Person> findByName(String name);

    public List<Person> findByVorAndName(String name, String vorname);

    public List<Person> findByVornameAndNameAndGeburtsdatum(String name, String vorname, LocalDate geburtsdatum);

    public List<Person> findByOptionalNameAndVornameAndGeburtsdatum(String name, String vorname, LocalDate geburtsdatum);

    public List<Person> findAll();

}

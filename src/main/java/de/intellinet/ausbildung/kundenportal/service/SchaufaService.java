/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service;

import java.util.Optional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.config.RatingServiceClientConfig;
import de.intellinet.services.rating.client.controller.RatingControllerClient;
import de.intellinet.services.rating.client.enums.Anrede;
import de.intellinet.services.rating.client.model.rest.AdresseDto;
import de.intellinet.services.rating.client.model.rest.PersonDto;
import de.intellinet.services.rating.client.model.rest.PersonIdResponseDto;
import de.intellinet.services.rating.client.model.rest.schufa_response.SchufaPersonResponse;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 18.03.2021
 */
public class SchaufaService {

    private static final Logger logger = LoggerFactory.getLogger(SchaufaService.class);
    RatingServiceClientConfig ratingServiceClientConfig = new RatingServiceClientConfig();
    static Person personOut = new Person();

    public SchufaPersonResponse getSchufaDaten(Person person) {

        PersonDto mapSchufaPerson = mapSchufaPerson(person);
        RatingControllerClient client = ratingServiceClientConfig.getClient();
        Optional<PersonIdResponseDto> personIdResponse = client.createPerson(mapSchufaPerson);
        // logger.info(personIdResponse.get().getId());

        PersonIdResponseDto personIdResponseDto = personIdResponse.get();
        Optional<SchufaPersonResponse> schufa = client.getSchufa(personIdResponseDto.getId(), "KK", "127.0.0.1");
        logger.info(ReflectionToStringBuilder.toString(schufa, ToStringStyle.JSON_STYLE));
        logger.info(ReflectionToStringBuilder.toString(schufa.get()));
        return schufa.get();
    }

    private PersonDto mapSchufaPerson(Person person) {
        PersonDto personOut = new PersonDto();

        if (person.getAnrede() != null) {
            personOut.setAnrede(mapAnreder(person.getAnrede()));
        } else {
            personOut.setAnrede(Anrede.UNBEKANNT);
        }
        if (person.getName() != null) {
            personOut.setNachname(person.getName());
        }

        if (person.getVorname() != null) {
            personOut.setVorname(person.getVorname());
        }

        if (person.getGeburtsort() != null) {
            personOut.setGeburtsort(person.getGeburtsort());
        }

        if (person.getStaatsangehoerigkeit() != null) {
            personOut.setStaatsangehoerigkeit(person.getStaatsangehoerigkeit());
        }
        if (person.getGeburtsdatum() != null) {
            personOut.setGeburtsdatum((person.getGeburtsdatum()));
        }

        if (person.getAdresse() != null) {
            personOut.setAdresse(mapAdresse(person.getAdresse()));
        }

        return personOut;
    }

    /**
     * Adresse Mapping
     * 
     */
    private AdresseDto mapAdresse(Adresse adresse) {

        AdresseDto adresseDto = new AdresseDto();

        if (null != adresse.getStrasse()) {
            adresseDto.setStrasse(adresse.getStrasse());
        }

        if (adresse.getHausnummer() != null) {
            adresseDto.setHausnummer(adresse.getHausnummer());
        }
        if (adresse.getPlz() != null) {
            adresseDto.setPlz(adresse.getPlz());
        }
        if (adresse.getOrt() != null) {
            adresseDto.setOrt(adresse.getOrt());
        }
        if (adresse.getLand() != null) {
            adresseDto.setLand(adresse.getLand());
        }
        return adresseDto;

    }

    private Anrede mapAnreder(de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede anrede) {
        if (de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede.HERR.equals(anrede)) {
            return Anrede.HERR;
        } else if (de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede.FRAU.equals(anrede)) {
            return Anrede.FRAU;
        } else {
            return Anrede.UNBEKANNT;

        }

    }

}

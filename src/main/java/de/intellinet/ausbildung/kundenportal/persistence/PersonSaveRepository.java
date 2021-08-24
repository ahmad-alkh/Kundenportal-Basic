/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mysql.jdbc.Statement;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 14.02.2020
 */
public class PersonSaveRepository implements IPersonSaveRepository, Serializable {

    /**
     * 
     * TODO Comment
     * 
     * @param person
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public long speicherPerson(Person person) throws ClassNotFoundException, SQLException {
        long person_id = 0;
        Connection con = null;
        PreparedStatement pstmtSP = null;

        String sPerson = "INSERT INTO `person` (" //
                + " `anrede`" //
                + " ,`name`"//
                + " ,`vorname`" //
                + " ,`geburtsort`"//
                + " ,`Staatsangehoerigkeit`" //
                + " ,`geburtsdatum`"//
                + " ,`geburtsname`"//
                + ",`anlagedatum`"//
                + ",`aenderungsdatum`) VALUES (" //
                + "?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            pstmtSP = con.prepareStatement(sPerson, Statement.RETURN_GENERATED_KEYS);
            pstmtSP.setString(1, mapAnrede(person.getAnrede()));
            pstmtSP.setString(2, person.getName());
            pstmtSP.setString(3, person.getVorname());
            pstmtSP.setString(4, person.getGeburtsort());
            pstmtSP.setString(5, person.getStaatsangehoerigkeit());
            pstmtSP.setDate(6, geburtsdatum(person.getGeburtsdatum()));
            pstmtSP.setString(7, person.getGeburtsname());
            pstmtSP.setTimestamp(8, convertToTimestampViaInstant(person.getAnlagedatum()));
            pstmtSP.setTimestamp(9, convertToTimestampViaInstant(person.getAenderungsdatum()));

            // execute the preparedstatement insert
            pstmtSP.executeUpdate();
            pstmtSP.getGeneratedKeys();
            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmtSP.getGeneratedKeys();
            if (rs != null && rs.next()) {
                person_id = rs.getInt(1);
                person.setId(person_id);

            }
        } finally {
            DbVerbinder.close(con, pstmtSP);
        }
        return person_id;
    }

    private String mapAnrede(Anrede anrede) {
        if (anrede.equals(Anrede.HERR)) {
            return "HERR";
        } else if (anrede.equals(Anrede.FRAU)) {
            return "FRAU";
        }
        return "UNBEKANNT";
    }

    private Timestamp convertToTimestampViaInstant(LocalDateTime anlagedatum) {
        return Timestamp.valueOf(anlagedatum);
    }

    private Date geburtsdatum(LocalDate localDate) {
        Date date = java.sql.Date.valueOf(localDate);
        return date;
    }

    @Override
    public Long speicherKontakt(Kontakt kontakt) throws ClassNotFoundException, SQLException {
        if (kontakt == null)
            return null;
        Connection con = null;

        PreparedStatement pstmtSK = null;

        String sKontakt = "INSERT INTO `kontakt`("//
                + "`person_id`"//
                + ",`email`"//
                + ", `telefon`"//
                + ",`mobil`)"//
                + "  VALUES(?,?,?,?)";

        try {

            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            pstmtSK = con.prepareStatement(sKontakt, Statement.RETURN_GENERATED_KEYS);
            pstmtSK.setLong(1, kontakt.getPerson_id());
            pstmtSK.setString(2, kontakt.getEmail());
            pstmtSK.setString(3, kontakt.getTelefon());
            pstmtSK.setString(4, kontakt.getMobil());

            // execute the preparedstatement insert
            pstmtSK.executeUpdate();

            pstmtSK.getGeneratedKeys();
            // die erste Befehl wurde geschrieben
            ResultSet rs = pstmtSK.getGeneratedKeys();
            if (rs != null && rs.next()) {
                Long primaryId = rs.getLong(1);
                kontakt.setId(primaryId);
                return primaryId;
            }

        } finally {
            DbVerbinder.close(con, pstmtSK);
        }
        return null;

    }

    @Override
    public Long speicherAdresse(Adresse adresse) throws ClassNotFoundException, SQLException { // alles
        if (adresse == null)
            return null;
        Connection con = null;

        PreparedStatement pstmtSA = null;

        String sAdresse = "INSERT INTO `adresse`("//
                + "`person_id`"//
                + ",`strasse`"//
                + ",`hausnummer`"//
                + ",`plz`"//
                + ",`ort`"//
                + ",`land`)"//
                + "  VALUES(?,?,?,?,?,?)";

        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            pstmtSA = con.prepareStatement(sAdresse, Statement.RETURN_GENERATED_KEYS);
            pstmtSA.setLong(1, adresse.getPerson_id());
            pstmtSA.setString(2, adresse.getStrasse());
            pstmtSA.setString(3, adresse.getHausnummer());
            pstmtSA.setString(4, adresse.getPlz());
            pstmtSA.setString(5, adresse.getOrt());
            pstmtSA.setString(6, adresse.getLand());

            // execute the preparedstatement insert
            pstmtSA.executeUpdate();
            // die erste Befehl wurde geschrieben
            pstmtSA.getGeneratedKeys();
            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmtSA.getGeneratedKeys();
            if (rs != null && rs.next()) {
                Long primaryId = rs.getLong(1);
                adresse.setId(primaryId);
                return primaryId;
            }
        } finally {
            DbVerbinder.close(con, pstmtSA);
        }
        return null;
    }

    @Override
    public void insert(Person person) throws ClassNotFoundException, SQLException {

        long person_id = speicherPerson(person);
        if (person.getAdresse() == null) {
            person.setAdresse(new Adresse());
        }
        if (person.getKontakt() == null) {
            person.setKontakt(new Kontakt());
        }

        person.getAdresse().setPerson_id(person_id);
        speicherAdresse(person.getAdresse());

        person.getKontakt().setPerson_id(person_id);
        speicherKontakt(person.getKontakt());

    }

    @Override
    public void update(Person person) throws ClassNotFoundException, SQLException {

        long person_id = person.getId();
        updateKunde(person);

        if (person.getAdresse().getPerson_id() == null) {

            person.getAdresse().setPerson_id(person_id);
            speicherAdresse(person.getAdresse());
        } else {
            person.getAdresse().setPerson_id(person_id);
            updateAdresse(person.getAdresse());
        }
        if (person.getKontakt().getPerson_id() == null) {
            person.getKontakt().setPerson_id(person_id);
            speicherKontakt(person.getKontakt());
        } else {
            updateKontakt(person.getKontakt());

        }

    }

    @Override
    public boolean updateKunde(Person person) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = " UPDATE person SET" //
                + "  anrede= ?" //
                + " ,name= ?" //
                + " ,vorname=?" //
                + " ,geburtsort=?" //
                + " ,Staatsangehoerigkeit=?" //
                + " ,geburtsdatum=?" //
                + " ,geburtsname=?" //
                + " ,anlagedatum=?"//
                + " ,aenderungsdatum=?"//
                + " WHERE id=?";
        try {
            con = DbVerbinder.getConnection();
            pstmt = con.prepareStatement(sql);
            int pos = 0;
            pstmt.setString(++pos, mapAnrede(person.getAnrede()));
            pstmt.setString(++pos, person.getName());
            pstmt.setString(++pos, person.getVorname());
            pstmt.setString(++pos, person.getGeburtsort());
            pstmt.setString(++pos, person.getStaatsangehoerigkeit());
            pstmt.setDate(++pos, geburtsdatum(person.getGeburtsdatum()));
            pstmt.setString(++pos, person.getGeburtsname());
            pstmt.setTimestamp(++pos, convertToTimestampViaInstant(person.getAnlagedatum()));
            pstmt.setTimestamp(++pos, convertToTimestampViaInstant(person.getAenderungsdatum()));
            pstmt.setLong(++pos, person.getId());

            (pstmt).executeUpdate();

        } finally {
            DbVerbinder.close(con, pstmt);
        }
        return true;
    }

    @Override
    public boolean deleteKunde(Person person) throws SQLException {

        Connection con = null;
        PreparedStatement pstmtKo = null;

        String SQL = "DELETE FROM person"//
                + " WHERE  id=?;"; //
        try {
            con = DbVerbinder.getConnection();

            pstmtKo = con.prepareStatement(SQL);
            int pos = 0;
            pstmtKo.setLong(++pos, person.getId());

            (pstmtKo).executeUpdate();

        } finally {
            DbVerbinder.close(con, pstmtKo);
        }
        return true;
    }

    @Override
    public boolean updateAdresse(Adresse adresse) throws SQLException {

        Connection con = null;
        PreparedStatement pstmtAd = null;

        String sql = " UPDATE adresse SET" //
                + " strasse=? " //
                + "  ,hausnummer=? " //
                + "  ,plz=? " //
                + "  ,ort=? " //
                + "  ,land=? " //
                + " WHERE id=?";
        try {
            con = DbVerbinder.getConnection();

            pstmtAd = con.prepareStatement(sql);
            int pos = 0;
            pstmtAd.setString(++pos, adresse.getStrasse());
            pstmtAd.setString(++pos, adresse.getHausnummer());
            pstmtAd.setString(++pos, adresse.getPlz());
            pstmtAd.setString(++pos, adresse.getOrt());
            pstmtAd.setString(++pos, adresse.getLand());

            pstmtAd.setLong(++pos, adresse.getId());

            (pstmtAd).executeUpdate();

        } finally {
            DbVerbinder.close(con, pstmtAd);
        }
        return true;
    }

    @Override
    public boolean updateKontakt(Kontakt kontakt) throws SQLException {

        Connection con = null;
        PreparedStatement pstmtKo = null;

        String sql = " UPDATE kontakt SET" //
                + " email=? " //
                + "  ,telefon=? " //
                + "  ,mobil=? " //
                + " WHERE id=?";
        try {
            con = DbVerbinder.getConnection();

            pstmtKo = con.prepareStatement(sql);
            int pos = 0;
            pstmtKo.setString(++pos, kontakt.getEmail());
            pstmtKo.setString(++pos, kontakt.getTelefon());
            pstmtKo.setString(++pos, kontakt.getMobil());

            pstmtKo.setLong(++pos, kontakt.getId());

            (pstmtKo).executeUpdate();

        } finally {
            DbVerbinder.close(con, pstmtKo);
        }
        return true;
    }

}

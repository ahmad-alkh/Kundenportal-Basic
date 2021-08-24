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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.persistence.utils.PreparedWhere;

/*
 * [TODO Insert description here.]
 * @author ahmalk *
 * @since 23.01.2020
 */
public class PersonReadRepository implements IPersonReadRepository, Serializable {

    static String SQLBfehl = "SELECT person.*, kontakt.*, adresse.*  FROM person" //
            + " LEFT JOIN kontakt ON kontakt.person_id=person.id " //
            + " LEFT JOIN adresse on adresse.person_id=person.id";

    @Override
    public List<Person> findAll() {

        List<Person> ergebnis = new ArrayList<Person>();

        Connection con = null;
        Statement stmt = null;
        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            stmt = con.createStatement(); // stamt schick die Info/Befehle zur DB

            String SQL = SQLBfehl; // die erste Befehl wurde geschrieben
            ResultSet rs = stmt.executeQuery(SQL); // hier wurde die Befhle gechikt
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                Person person = personEinlesen(rs);
                ergebnis.add(person);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, stmt);
        }
        return ergebnis;
    }

    @Override
    public List<Person> findByName(String eingabe) { // alles einfugen und
        List<Person> SuchErgebnis = new ArrayList<Person>();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            String sqlStmnt = SQLBfehl + " WHERE person.name LIKE ?"; //
            pstmt = con.prepareStatement(sqlStmnt); // anpassen
            pstmt.setString(1, eingabe);
            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmt.executeQuery();
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                // System.out.println(rs);
                Person person = personEinlesen(rs);
                SuchErgebnis.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, pstmt);
        }
        return SuchErgebnis;
    }

    @Override
    public List<Person> findByVorAndName(String name, String vorname) { // alles
                                                                        // einfugen
                                                                        // und
        List<Person> SuchErgebnis = new ArrayList<Person>();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            String sqlStmnt = SQLBfehl + " WHERE person.name LIKE ? and person.vorname LIKE ?" //
            ; //
            pstmt = con.prepareStatement(sqlStmnt); // anpassen
            pstmt.setString(1, name);
            pstmt.setString(2, vorname);

            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmt.executeQuery();
            // Iterate through the data in the result set and display it.
            while (rs.next()) {

                Person person = personEinlesen(rs);
                SuchErgebnis.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, pstmt);
        }
        return SuchErgebnis;
    }

    @Override
    public List<Person> findByVornameAndNameAndGeburtsdatum(String name, String vorname, LocalDate geburtsdatum) { // alles
        // einfugen
        // und
        List<Person> SuchErgebnis = new ArrayList<Person>();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            String sqlStmnt = SQLBfehl

                    + " WHERE person.name LIKE ? and person.vorname LIKE ?" //
                    + "and person.geburtsdatum LIKE ?"; //

            pstmt = con.prepareStatement(sqlStmnt); // anpassen
            pstmt.setString(1, name);
            pstmt.setString(2, vorname);
            pstmt.setDate(3, geburtsdatum(geburtsdatum));

            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmt.executeQuery();
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                // System.out.println(rs);
                Person person = personEinlesen(rs);
                SuchErgebnis.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, pstmt);
        }
        return SuchErgebnis;
    }

    @Override
    public List<Person> findByOptionalNameAndVornameAndGeburtsdatum(String name, String vorname,
            LocalDate geburtsdatum) { // alles
        // einfugen
        // und
        List<Person> SuchErgebnis = new ArrayList<Person>();
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            PreparedWhere befehl = pruefeAufNull(name, vorname, geburtsdatum);

            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            String sqlStmnt = SQLBfehl + befehl.getBedingung(); //

            pstmt = con.prepareStatement(sqlStmnt);

            List<Object> parameter = befehl.getParameter();

            for (int i = 0; i < parameter.size(); i++) {
                Object o = parameter.get(i);

                if (o instanceof LocalDate) {
                    pstmt.setDate(i + 1, geburtsdatum((LocalDate) o));
                } else if (o instanceof String) {
                    pstmt.setString(i + 1, (String) o);

                }
            }
            // die erste Befehl wurde geschrieben

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Person person = personEinlesen(rs);
                SuchErgebnis.add(person);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, pstmt);
        }
        return SuchErgebnis;
    }

    private Person personEinlesen(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setAnrede(mapAnrede(rs.getString("anrede")));
        person.setName(rs.getString("name"));
        person.setVorname(rs.getString("vorname"));
        person.setId(rs.getLong("id"));
        person.setGeburtsort(rs.getString("geburtsort"));
        person.setStaatsangehoerigkeit(rs.getString("Staatsangehoerigkeit"));

        Timestamp aenderungsdatum = rs.getTimestamp("aenderungsdatum");
        Timestamp anlagedatum = rs.getTimestamp("anlagedatum");
        Date geburtsdatum = rs.getDate("geburtsdatum");

        person.setGeburtsdatum(geburtsdatum.toLocalDate());
        person.setAnlagedatum(anlagedatum.toLocalDateTime());
        person.setAenderungsdatum(aenderungsdatum.toLocalDateTime());

        Kontakt kontakt = new Kontakt();
        kontakt.setId(rs.getLong("kontakt.id"));
        kontakt.setPerson_id(rs.getLong("kontakt.person_id"));
        kontakt.setEmail(rs.getString("kontakt.email"));
        kontakt.setTelefon(rs.getString("kontakt.telefon"));
        kontakt.setMobil(rs.getString("kontakt.mobil"));
        person.setKontakt(kontakt);

        // damit kein Elmente resviern, falls leer ist
        Adresse adresse = new Adresse();

        adresse.setId(rs.getLong("adresse.id"));
        adresse.setPerson_id(rs.getLong("adresse.person_id"));
        adresse.setLand(rs.getString("adresse.land"));
        adresse.setPlz(rs.getString("adresse.plz"));
        adresse.setOrt(rs.getString("adresse.ort"));
        adresse.setStrasse(rs.getString("adresse.strasse"));
        adresse.setHausnummer(rs.getString("adresse.hausnummer"));
        person.setAdresse(adresse);
        // }

        return person;
    }

    private Anrede mapAnrede(String anrede) {
        if ("HEER".equals(anrede)) {
            return Anrede.HERR;
        } else if ("FRAU".equals(anrede)) {
            return Anrede.FRAU;
        } else {

            return Anrede.UNBEKANNT;
        }
    }

    private PreparedWhere pruefeAufNull(String name, String vorname, LocalDate geburtsdatum) {
        List<Object> parameter = new ArrayList<Object>();
        String whereBedingung = "";
        int temp0 = 0;
        if (name != null) {
            whereBedingung += whereOrAnd(temp0++, "person.name LIKE ?");
            parameter.add(name);
        }

        if (vorname != null) {

            whereBedingung += whereOrAnd(temp0++, "person.vorname LIKE ?");
            parameter.add(vorname);
        }
        if (geburtsdatum != null) {
            whereBedingung += whereOrAnd(temp0++, "person.geburtsdatum = ?");
            parameter.add(geburtsdatum);
        }

        PreparedWhere ergebnis = new PreparedWhere(whereBedingung, parameter);
        return ergebnis;
    }

    /**
     * 
     * TODO Comment
     * 
     * @param temp
     * @param befehl
     * @return
     */
    String whereOrAnd(int temp, String befehl) {
        String aufbau = null;
        if (temp > 0) {
            aufbau = " AND ";
        } else {
            aufbau = " WHERE ";

        }
        aufbau += befehl;;
        return aufbau;
    }

    /**
     * 
     */
    @Override
    public Optional<Person> findById(Long id) {
        Person ergebnis = new Person();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DbVerbinder.getConnection(); // um Kontakt dazwischen auf zu bauen
            stmt = con.createStatement(); // stamt schick die Info/Befehle zur DB

            String SQL = SQLBfehl + " WHERE person.id=" + id; // die erste
                                                              // Befehl wurde
                                                              // geschrieben
            ResultSet rs = stmt.executeQuery(SQL); // hier wurde die Befhle gechikt
            if (rs.next()) {
                ergebnis = personEinlesen(rs);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbVerbinder.close(con, stmt);
        }

        return Optional.ofNullable(ergebnis);
    }

    private Date geburtsdatum(LocalDate localDate) {
        Date date = java.sql.Date.valueOf(localDate);
        return date;
    }

}

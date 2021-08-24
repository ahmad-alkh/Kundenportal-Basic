/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * 
 * @author ahmalk
 *
 * @since 29.01.2020
 */
public class DbVerbinder {

    static final String DB_URL = "jdbc:mysql://localhost:3306/uebung_kundenportal";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl(DB_URL);
        ds.setUser(USER);
        ds.setPassword(PASS);

        return ds.getConnection();
    }

    public static void close(Connection conn, java.sql.Statement stmt) {
        // finally block used to close resources
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
        } // nothing we can do
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } // end finally try
    }

}

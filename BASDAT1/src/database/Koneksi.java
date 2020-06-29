package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexander Pratama
 */
public class Koneksi {

    private Connection connect;
    private Statement db;

    public Koneksi() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                        "alexander_07029", "alexander");
            } catch (SQLException se) {
                System.err.println("Koneksi database gagal, ini disebabkan oleh : " + se);
            }
        } catch (ClassNotFoundException err) {
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + err);
        }
    }

    public ResultSet getData(String sql) {
        try {
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    public int manipulasiData(String sql) {
        try {
            db = connect.createStatement();
            return db.executeUpdate(sql);
        } catch (SQLException e) {
            return 0;
        }
    }

}

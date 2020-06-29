package aksesdata;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelKasir;

public class AksesDataKasir {

    private final Koneksi koneksi;

    public AksesDataKasir() {
        this.koneksi = new Koneksi();
    }

    public ArrayList<ModelKasir> getSemuaDataKasir() throws SQLException {
        ArrayList<ModelKasir> daftarDataKasir = new ArrayList<>();

        String kodeSql = "SELECT * FROM list_kasir";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        while (hasilKodeSql.next()) {
            int idKasir = hasilKodeSql.getInt("Id_Kasir");
            String nama = hasilKodeSql.getString("Nama_Kasir");
            String password = hasilKodeSql.getString("Password_Kasir");
            ModelKasir modelKasir = new ModelKasir(idKasir, nama, password);
            daftarDataKasir.add(modelKasir);
        }
        return daftarDataKasir;
    }

    public boolean cekDataKasirMasihKosong() throws SQLException {
        String kodeSql = "SELECT * FROM Kasir_07029";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        return !hasilKodeSql.next();
    }

    public int cariIdKasir(String namaKasir) throws SQLException {
        String kodeSql = "SELECT Id_Kasir FROM kasir_07029 WHERE Nama_Kasir LIKE '" + namaKasir + "'";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        hasilKodeSql.next();
        return hasilKodeSql.getInt("id_kasir");
    }

    public ModelKasir cariDataKasir(int idKasir) throws SQLException {
        ModelKasir modelKasir = null;
        String kodeSql = "SELECT * FROM Kasir_07029 WHERE Id_Kasir = " + idKasir;
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        if (hasilKodeSql.next()) {
            String nama = hasilKodeSql.getString("Nama_Kasir");
            String password = hasilKodeSql.getString("Password_Kasir");
            modelKasir = new ModelKasir(idKasir, nama, password);
        }
        return modelKasir;
    }
}

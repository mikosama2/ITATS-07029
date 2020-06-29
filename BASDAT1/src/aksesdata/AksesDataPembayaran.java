package aksesdata;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.ModelKasir;
import model.ModelMember;
import model.ModelPembayaran;

public class AksesDataPembayaran {

    private final Koneksi koneksi;

    public AksesDataPembayaran() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdPembayaran() throws SQLException {
        String kodeSql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_PEMBAYARAN'";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        hasilKodeSql.next();
        return hasilKodeSql.getInt("last_number");
    }

    public void create(int idKasir, int idMember, String tanggalPembayaran, int hargaTiket, 
            int banyakTiket, int total) {
        String kodeSql = "INSERT INTO pembayaran_07029 (id_pembayaran, id_kasir, id_member, "
                + "tanggal_pembayaran, harga_tiket, banyak_tiket, total) VALUES (id_pembayaran.NEXTVAL, "
                + idKasir + ", " + idMember + ", TO_DATE('" + tanggalPembayaran + "', 'dd/MM/yyyy'), " 
                + hargaTiket + ", " + banyakTiket + ", " + total + ")";
        this.koneksi.manipulasiData(kodeSql);
    }

    public ArrayList<ModelPembayaran> read() throws SQLException {
        ArrayList<ModelPembayaran> daftarDataPembayaran = new ArrayList<>();

        String kodeSql = "SELECT a.id_pembayaran, a.tanggal_pembayaran, "
                + "a.harga_tiket, a.banyak_tiket, a.total, "
                + "b.id_kasir, b.nama_kasir, b.password_kasir, "
                + "c.id_member, c.nama_member, c.no_telp_member "
                + "FROM pembayaran_07029 a "
                + "JOIN kasir_07029 b "
                + "ON a.id_kasir = b.id_kasir "
                + "JOIN member_07029 c "
                + "ON a.id_member = c.id_member";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        while (hasilKodeSql.next()) {
            int idMember = hasilKodeSql.getInt("id_member");
            String namaMember = hasilKodeSql.getString("nama_member");
            int noTelpMember = hasilKodeSql.getInt("no_telp_member");
            ModelMember modelMember = new ModelMember(idMember, namaMember, noTelpMember);

            int idKasir = hasilKodeSql.getInt("id_kasir");
            String namaKasir = hasilKodeSql.getString("nama_kasir");
            String passwordKasir = hasilKodeSql.getString("password_kasir");
            ModelKasir modelKasir = new ModelKasir(idKasir, namaKasir, passwordKasir);

            int idPembayaran = hasilKodeSql.getInt("id_pembayaran");
            Date tanggalPembayaran = hasilKodeSql.getDate("tanggal_pembayaran");
            int hargaTiket = hasilKodeSql.getInt("harga_tiket");
            int banyakTiket = hasilKodeSql.getInt("banyak_tiket");
            int total = hasilKodeSql.getInt("total");
            ModelPembayaran modelPembayaran = new ModelPembayaran(idPembayaran, modelKasir, modelMember,
                    tanggalPembayaran, hargaTiket, banyakTiket, total);

            daftarDataPembayaran.add(modelPembayaran);
        }
        return daftarDataPembayaran;
    }

}

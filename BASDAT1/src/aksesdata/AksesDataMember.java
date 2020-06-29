package aksesdata;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelMember;

public class AksesDataMember {

    private final Koneksi koneksi;

    public AksesDataMember() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdMember() throws SQLException {
        String kodeSql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_MEMBER'";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        hasilKodeSql.next();
        return hasilKodeSql.getInt("last_number");
    }

    public void create(String namaMember, int noTelpMember) {
        String kodeSql = "INSERT INTO member_07029 (id_member, nama_member, no_telp_member) VALUES "
                + "(id_member.NEXTVAL, '" + namaMember + "', " + noTelpMember + ")";
        this.koneksi.manipulasiData(kodeSql);
    }
    
    public void update(int idMember, String namaMember, int noTelpMember) {
        String kodeSql = "UPDATE member_07029 SET nama_member = '" + namaMember + "', "
                + "no_telp_member = '" + noTelpMember + "' WHERE id_member = " + idMember;
        this.koneksi.manipulasiData(kodeSql);
    }
    
    public void delete(int idMember) {
        String kodeSql = "DELETE FROM member_07029 WHERE id_member = " + idMember;
        this.koneksi.manipulasiData(kodeSql);
    }

    public ArrayList<ModelMember> read() throws SQLException {
        ArrayList<ModelMember> daftarDataMember = new ArrayList<>();

        String kodeSql = "SELECT * FROM member_07029";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        while (hasilKodeSql.next()) {
            int idMember = hasilKodeSql.getInt("id_member");
            String namaMember = hasilKodeSql.getString("nama_member");
            int noTelpMember = hasilKodeSql.getInt("no_telp_member");
            ModelMember modelMember = new ModelMember(idMember, namaMember, noTelpMember);

            daftarDataMember.add(modelMember);
        }
        return daftarDataMember;
    }
    
    public boolean cekDataMemberMasihKosong() throws SQLException {
        String kodeSql = "SELECT * FROM member_07029";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        return !hasilKodeSql.next();
    }
    
    public int cariIdMember(String namaMember) throws SQLException {
        String kodeSql = "SELECT id_member FROM member_07029 WHERE nama_member LIKE '" + namaMember + "'";
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        hasilKodeSql.next();
        return hasilKodeSql.getInt("id_member");
    }
    
    public ModelMember cariDataMember(int idMember) throws SQLException {
        ModelMember modelMember = null;
        String kodeSql = "SELECT * FROM member_07029 WHERE id_member = " + idMember;
        ResultSet hasilKodeSql = this.koneksi.getData(kodeSql);
        if (hasilKodeSql.next()) {
            String namaMember = hasilKodeSql.getString("nama_member");
            int noTelpMember = hasilKodeSql.getInt("no_telp_member");
            modelMember = new ModelMember(idMember, namaMember, noTelpMember);
        }
        return modelMember;
    }

}

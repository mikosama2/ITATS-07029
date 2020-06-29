package model;

public class ModelKasir {

    private final int idKasir;
    private final String namaKasir;
    private final String passwordKasir;

    public ModelKasir(int idKasir, String nama, String password) {
        this.idKasir = idKasir;
        this.namaKasir = nama;
        this.passwordKasir = password;
    }

    public ModelKasir(ModelKasir modelKasir) {
        this.idKasir = modelKasir.getIdKasir();
        this.namaKasir = modelKasir.getNamaKasir();
        this.passwordKasir = modelKasir.getPasswordKasir();
    }

    public int getIdKasir() {
        return idKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public String getPasswordKasir() {
        return passwordKasir;
    }
}

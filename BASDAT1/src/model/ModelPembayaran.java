package model;

import java.util.Date;

public class ModelPembayaran {

    private final int idPembayaran;
    private final ModelKasir modelKasir;
    private final ModelMember modelMember;
    private final Date tanggalPembayaran;
    private final int hargaTiket;
    private final int banyakTiket;
    private final int total;

    public ModelPembayaran(int idPembayaran, ModelKasir modelKasir, ModelMember modelMember, Date tanggal,
            int hargatix, int banyaktix, int total) {
        this.idPembayaran = idPembayaran;
        this.modelKasir = modelKasir;
        this.modelMember = modelMember;
        this.tanggalPembayaran = tanggal;
        this.hargaTiket = hargatix;
        this.banyakTiket = banyaktix;
        this.total = total;
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public ModelKasir getModelKasir() {
        return modelKasir;
    }

    public ModelMember getModelMember() {
        return modelMember;
    }

    public Date getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public int getBanyakTiket() {
        return banyakTiket;
    }

    public int getTotal() {
        return total;
    }

}

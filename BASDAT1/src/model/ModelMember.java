package model;

public class ModelMember {

    private final int idMember;
    private final String namaMember;
    private final int noTelpMember;

    public ModelMember(int idMember, String namaMember, int noTelpMember) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.noTelpMember = noTelpMember;
    }

    public ModelMember(ModelMember modelMember) {
        this.idMember = modelMember.getIdMember();
        this.namaMember = modelMember.getNamaMember();
        this.noTelpMember = modelMember.getNoTelpMember();
    }

    public int getIdMember() {
        return idMember;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public int getNoTelpMember() {
        return noTelpMember;
    }
}

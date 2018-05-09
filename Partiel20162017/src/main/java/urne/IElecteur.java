package urne;

public abstract class IElecteur {

    private long numeroElecteur;
    private String nomElecteur;
    private String prenomElecteur;

    private static long id = 0;

    public IElecteur(String nomElecteur, String prenomElecteur) {
        numeroElecteur = id ++;
        this.nomElecteur = nomElecteur;
        this.prenomElecteur = prenomElecteur;
    }

    public long getNumeroElecteur() {
        return numeroElecteur;
    }

    public void setNumeroElecteur(long numeroElecteur) {
        this.numeroElecteur = numeroElecteur;
    }

    public String getNomElecteur() {
        return nomElecteur;
    }

    public void setNomElecteur(String nomElecteur) {
        this.nomElecteur = nomElecteur;
    }

    public String getPrenomElecteur() {
        return prenomElecteur;
    }

    public void setPrenomElecteur(String prenomElecteur) {
        this.prenomElecteur = prenomElecteur;
    }
}

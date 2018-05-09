package urne;

public abstract class IVote {

    private String candidat;

    public IVote(String candidat) {
        this.candidat = candidat;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }
}

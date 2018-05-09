package urne;

import exceptions.ElectionPasEncoreOuverte;
import exceptions.NonIncritSurListeElectorale;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Urne implements IUrne {

    List<String> listeCandidats = new ArrayList<String>();
    Map<String, Double> resultatsPourcentage;
    Long nbVotants;
    Map<String, Long> resultatsNbVotants;
    boolean electionInitialisee;
    Long votesNuls;
    boolean electionOuverte;
    List<IVote> votes = new ArrayList<IVote>();
    Map<String, Long> votesEnregistres;
    List<IElecteur> electeurs = new ArrayList<>();
    Long nbVotesBlancs;


    public Urne() {
    }

    @Override
    public void ajouterVote(IVote vote, long idElecteur) throws ElectionPasEncoreOuverte, NonIncritSurListeElectorale {
        if(!this.isElectionOuverte()){
            throw new ElectionPasEncoreOuverte();
        }
        for(IElecteur electeur : this.getElecteurs()){
            if(electeur.getNumeroElecteur() == idElecteur){
                this.getVotes().add(vote);
                this.setNbVotants(this.getNbVotants() + 1);
                return;
            }
        }
        throw  new NonIncritSurListeElectorale();
    }

    @Override
    public void depouillement() {

    }

    @Override
    public void clotureElection() {

    }


    public List<String> getListeCandidats() {
        return listeCandidats;
    }

    public void setListeCandidats(List<String> listeCandidats) {
        this.listeCandidats = listeCandidats;
    }

    public Map<String, Double> getResultatsPourcentage() {
        return resultatsPourcentage;
    }

    public void setResultatsPourcentage(Map<String, Double> resultatsPourcentage) {
        this.resultatsPourcentage = resultatsPourcentage;
    }

    public Long getNbVotants() {
        return nbVotants;
    }

    public void setNbVotants(Long nbVotants) {
        this.nbVotants = nbVotants;
    }

    public Map<String, Long> getResultatsNbVotants() {
        return resultatsNbVotants;
    }

    public void setResultatsNbVotants(Map<String, Long> resultatsNbVotants) {
        this.resultatsNbVotants = resultatsNbVotants;
    }

    public boolean isElectionInitialisee() {
        return electionInitialisee;
    }

    public void setElectionInitialisee(boolean electionInitialisee) {
        this.electionInitialisee = electionInitialisee;
    }

    public Long getVotesNuls() {
        return votesNuls;
    }

    public void setVotesNuls(Long votesNuls) {
        this.votesNuls = votesNuls;
    }

    public boolean isElectionOuverte() {
        return electionOuverte;
    }

    public void setElectionOuverte(boolean electionOuverte) {
        this.electionOuverte = electionOuverte;
    }

    public List<IVote> getVotes() {
        return votes;
    }

    public void setVotes(List<IVote> votes) {
        this.votes = votes;
    }

    public Map<String, Long> getVotesEnregistres() {
        return votesEnregistres;
    }

    public void setVotesEnregistres(Map<String, Long> votesEnregistres) {
        this.votesEnregistres = votesEnregistres;
    }

    public List<IElecteur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(List<IElecteur> electeurs) {
        this.electeurs = electeurs;
    }

    public Long getNbVotesBlancs() {
        return nbVotesBlancs;
    }

    public void setNbVotesBlancs(Long nbVotesBlancs) {
        this.nbVotesBlancs = nbVotesBlancs;
    }
}

package urne;

import exceptions.ElectionPasEncoreOuverte;
import exceptions.NonIncritSurListeElectorale;

public interface IUrne {
    void ajouterVote(IVote vote, long idElecteur ) throws ElectionPasEncoreOuverte, NonIncritSurListeElectorale;
    void depouillement();
    void clotureElection();
}

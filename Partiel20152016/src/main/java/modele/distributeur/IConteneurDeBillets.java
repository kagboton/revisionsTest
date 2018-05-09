package modele.distributeur;

import modele.chaine.IChaineLivraisonCoupures;

public interface IConteneurDeBillets {

    int getNbBillets(int valeurBillet);

    boolean retirerNbBillets(int valeurBillet, int nbBillet);

    boolean isSommeDisponible(int sommeADebiter);

    IChaineLivraisonCoupures getAlgoLivraison(int sommeADebiter);

}

package modele.chaine;

import modele.distributeur.IConteneurDeBillets;

public class PetitesCoupures extends IChaineLivraisonCoupures {

    public PetitesCoupures(IChaineLivraisonCoupures next) {
        super(next);
    }

    @Override
    public int operationChainon(IConteneurDeBillets billets, int sommeDemandee) {
        if((sommeDemandee / 20) >  billets.getNbBillets(20)){
            billets.retirerNbBillets(20, sommeDemandee/20);
            return 0;
        }
        return sommeDemandee;
    }
}

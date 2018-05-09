package modele.chaine;

import modele.distributeur.IConteneurDeBillets;

public abstract class IChaineLivraisonCoupures {
    private IChaineLivraisonCoupures next;

    public IChaineLivraisonCoupures(IChaineLivraisonCoupures next) {
        this.next = next;
    }

    public boolean operation(IConteneurDeBillets billets, int sommeDemandee){
        int restantDu = this.operationChainon(billets, sommeDemandee);
        if(restantDu > 0 && this.next != null){
            return this.next.operation(billets, restantDu);
        }
        else {
            if(restantDu == 0){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public abstract int operationChainon(IConteneurDeBillets billets, int sommeDemandee);


    public IChaineLivraisonCoupures getNext() {
        return next;
    }

    public void setNext(IChaineLivraisonCoupures next) {
        this.next = next;
    }
}

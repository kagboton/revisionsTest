package modele.chaine;

import modele.distributeur.IConteneurDeBillets;

public class GrossesCoupures extends IChaineLivraisonCoupures{
    public GrossesCoupures(IChaineLivraisonCoupures next) {
        super(next);
    }


    @Override
    public int operationChainon(IConteneurDeBillets billets, int sommeDemandee) {

        int sommeRestante = sommeDemandee;

        boolean continuer = true;

        while (continuer){
            continuer = false;

            if(sommeRestante > 500 && billets.getNbBillets(500)>0){
                continuer = true;
                sommeRestante = sommeRestante - 500;
                billets.retirerNbBillets(500, 1);
            }
            else {
                if(sommeRestante > 200 && billets.getNbBillets(200)>0){
                    continuer = true;
                    sommeRestante = sommeRestante - 200;
                    billets.retirerNbBillets(200, 1);
                }else {
                    if (sommeRestante > 100 && billets.getNbBillets(100)>0){
                        continuer = true;
                        sommeRestante = sommeRestante - 100;
                        billets.retirerNbBillets(100, 1);
                    }
                }
            }
        }

        return  sommeRestante;

    }
}

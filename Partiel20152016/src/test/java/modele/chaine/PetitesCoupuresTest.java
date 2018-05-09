package modele.chaine;

import modele.distributeur.IConteneurDeBillets;
import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetitesCoupuresTest {

    private PetitesCoupures sujet;

    int sommeDemandee = 100;


    @Before
    public void init(){
        IChaineLivraisonCoupures next = EasyMock.createMock(IChaineLivraisonCoupures.class);
        sujet = new PetitesCoupures(next);
    }



    @Test
    public void operationChainonTest1(){
        //Creation des mocks
        IConteneurDeBillets billetsMock = EasyMock.createMock(IConteneurDeBillets.class);

        //Scénarios
        EasyMock.expect(billetsMock.getNbBillets(20)).andReturn(3);
        EasyMock.expect(billetsMock.retirerNbBillets(20, sommeDemandee/20)).andReturn(false);

        EasyMock.replay(billetsMock);

        int resultatObtenu = sujet.operationChainon(billetsMock, sommeDemandee);

        EasyMock.verify(billetsMock);

        Assert.assertEquals("La valeur retournée doit être égale à zéro (0)", 0, resultatObtenu);

    }


    @Test
    public void operationChainonTest2(){
        //Creation des mocks
        IConteneurDeBillets billetsMock = EasyMock.createMock(IConteneurDeBillets.class);


        //Scénario
        EasyMock.expect(billetsMock.getNbBillets(20)).andReturn(6);
        EasyMock.expect(billetsMock.retirerNbBillets(20, sommeDemandee/20)).andReturn(true);

        //Replay
        EasyMock.replay(billetsMock);

        //Test
        int resultatObtenu = sujet.operationChainon(billetsMock, sommeDemandee);

        //Verify
        EasyMock.verify(billetsMock);

        //Verification
        Assert.assertEquals("La valeur retournée doit être égale à " +sommeDemandee +".", sommeDemandee, resultatObtenu);



    }
}

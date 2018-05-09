package modele.chaine;

import modele.distributeur.IConteneurDeBillets;
import org.easymock.IMockBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;


public class IChaineLivraisonCoupuresTest {


    private IChaineLivraisonCoupures chaine;
    private IMockBuilder<IChaineLivraisonCoupures> chaineBuilder; //Mock builder pour notre chaine
    IConteneurDeBillets billetsMock;
    int sommeDemandee = 20;


    @Before
    public void init(){
        chaineBuilder = EasyMock.createMockBuilder(IChaineLivraisonCoupures.class); //Initialisation du mockBuilder
        billetsMock = EasyMock.createMock(IConteneurDeBillets.class);
    }

    @Test
    public void operationTest1(){
        //Creationd des mocks
        IChaineLivraisonCoupures nextMock = EasyMock.createMock(IChaineLivraisonCoupures.class);

        chaine = chaineBuilder
                .addMockedMethod("getNext")
                .addMockedMethod("operationChainon").createMock();

        int restantDu = 2;

        //Scénario
        EasyMock.expect(chaine.getNext()).andReturn(nextMock);
        EasyMock.expect(chaine.operationChainon(billetsMock, sommeDemandee)).andReturn(restantDu);
        EasyMock.expect(chaine.getNext().operation(billetsMock, restantDu)).andReturn(true);

        //Replay
        EasyMock.replay( billetsMock, chaine);

        //Test
        boolean resultatObtenu = chaine.operation(billetsMock, sommeDemandee);

        //Verify
        EasyMock.verify(billetsMock, chaine);

        //Verifiaction
        Assert.assertEquals("Les valeurs devraient être pareils", true, resultatObtenu);

    }


    @Test
    public void operationTest2(){
        //Creation des mocks
        chaine = chaineBuilder
                .addMockedMethod("operationChainon").createMock();

        //Scénario
        EasyMock.expect(chaine.operationChainon(billetsMock, sommeDemandee)).andReturn(0);

        //Replay
        EasyMock.replay(billetsMock, chaine);

        boolean resultatObtenu = chaine.operation(billetsMock, sommeDemandee);

        //Verify
        EasyMock.verify(billetsMock, chaine);

        Assert.assertEquals("Le resultat doit être true", true, resultatObtenu);
    }

    @Test
    public void operationTest3(){
        //Creation des mocks
        chaine = chaineBuilder
                .addMockedMethod("operationChainon").createMock();

        //Scenario
        EasyMock.expect(chaine.operationChainon(billetsMock, sommeDemandee)).andReturn(-1);

        //Replay
        EasyMock.replay(billetsMock, chaine);

        boolean resultatObtenu = chaine.operation(billetsMock, sommeDemandee);

        //Verify
        EasyMock.verify(billetsMock, chaine);

        Assert.assertEquals("Le resultat doit être false", false, resultatObtenu );

    }
}

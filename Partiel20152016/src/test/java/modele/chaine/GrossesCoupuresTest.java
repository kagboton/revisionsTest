package modele.chaine;

import modele.distributeur.IConteneurDeBillets;
import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GrossesCoupuresTest {


    private IChaineLivraisonCoupures sujet;
    private IMockBuilder<IChaineLivraisonCoupures> sujetMockBuilder;


    @Before
    public void init(){
        sujetMockBuilder = EasyMock.createMockBuilder(IChaineLivraisonCoupures.class);
    }


    @Test
    public void operationChainonTestCoupuresInferieuresA100(){

        //Creation des mocks
        int sommeDemandee = 90;
        IConteneurDeBillets billetsMock = EasyMock.createMock(IConteneurDeBillets.class);
        sujet = sujetMockBuilder.addMockedMethod("operation").createMock();


        //Scenario
        EasyMock.expect(billetsMock.getNbBillets(500)).andReturn(0);
        EasyMock.expect(billetsMock.getNbBillets(200)).andReturn(0);
        EasyMock.expect(billetsMock.getNbBillets(100)).andReturn(0);

        EasyMock.replay(billetsMock, sujet);

        int resultatObtenu = sujet.operationChainon(billetsMock, sommeDemandee);

        EasyMock.verify(billetsMock, sujet);

        Assert.assertEquals("Le somme retournée doit être la somme demandee" + sommeDemandee +".", sommeDemandee, resultatObtenu);
    }


}

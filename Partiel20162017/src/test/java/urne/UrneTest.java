package urne;

import exceptions.ElectionPasEncoreOuverte;
import exceptions.NonIncritSurListeElectorale;
import jdk.jfr.events.ExceptionThrownEvent;
import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UrneTest {

    private Urne sujet;
    private IMockBuilder<Urne> sujetBuilder;
    IVote voteMock;

    @Before
    public void init(){
        sujetBuilder = EasyMock.createMockBuilder(Urne.class); //MockBuilder pour la mock partiel de Urne
        voteMock = EasyMock.createMock(IVote.class);

    }

    /**
     * Election non encore ouverte test
     * @throws Exception
     */
    @Test(expected = ElectionPasEncoreOuverte.class)
    public void electionNonOuverteTest() throws Exception{

        long idElecteur = 12l;
        sujet = sujetBuilder
                .addMockedMethod("isElectionOuverte")
                .createMock();

        //Scenario
        EasyMock.expect(sujet.isElectionOuverte()).andReturn(false);


        //Replay
        EasyMock.replay(voteMock, sujet);

        //Test
        sujet.ajouterVote(voteMock, idElecteur);

        //Verify
        EasyMock.verify(voteMock, sujet);

    }


    /**
     * Test electeur non inscrit sur la liste en rentrant au moins une fois dans la boucle for
     * @throws Exception
     */
    @Test(expected = NonIncritSurListeElectorale.class)
    public void test1ElecteurNonInscrit() throws Exception{

        //Creation des mocks
        long idElecteur = 218l; //Id de l'electeur qui soulaite voter

        sujet = sujetBuilder
                .addMockedMethod("getElecteurs")
                .addMockedMethod("isElectionOuverte")
                .createMock(); //Mock partiel de Urne

        //Mocks de deux electeurs
        IElecteur electeurMocck1 = EasyMock.createMock(IElecteur.class);
        IElecteur electeurMocck2 = EasyMock.createMock(IElecteur.class);

        //Je crée une liste pour ajouter mes deux électeurs
        List<IElecteur> list = new ArrayList<>();

        //Scenario
        EasyMock.expect(sujet.isElectionOuverte()).andReturn(true);
        EasyMock.expect(electeurMocck1.getNumeroElecteur()).andReturn(2015l);
        EasyMock.expect(electeurMocck2.getNumeroElecteur()).andReturn(2016l);
        list.add(electeurMocck1);
        list.add(electeurMocck2);
        EasyMock.expect(sujet.getElecteurs()).andReturn(list);

        //Replay
        EasyMock.replay(voteMock, sujet, electeurMocck1, electeurMocck2);

        //Test
        sujet.ajouterVote(voteMock, idElecteur);

        //Verify
        EasyMock.verify(voteMock, sujet, electeurMocck1, electeurMocck2);

    }



    /**
     * Test electeur non inscrit sur la liste sans rentrer dans le boucle for
     * @throws Exception
     */
    @Test(expected = NonIncritSurListeElectorale.class)
    public void test2ElecteurNonInscrit() throws Exception{

        long idElecteur = 218l;

        sujet = sujetBuilder
                .addMockedMethod("getElecteurs")
                .addMockedMethod("isElectionOuverte")
                .createMock();

        List<IElecteur> list = new ArrayList<>();

        //Scenario
        EasyMock.expect(sujet.isElectionOuverte()).andReturn(true);
        EasyMock.expect(sujet.getElecteurs()).andReturn(list);

        //Replay
        EasyMock.replay(voteMock, sujet);

        //Test
        sujet.ajouterVote(voteMock, idElecteur);

        //Verify
        EasyMock.verify(voteMock, sujet);

    }



    @Test
    public void testVoteOK() throws Exception{
        long idElecteur = 218l;

        sujet = sujetBuilder
                .addMockedMethod("getElecteurs")
                .addMockedMethod("isElectionOuverte")
                .addMockedMethod("getVotes")
                .addMockedMethod("getNbVotants")
                .addMockedMethod("setNbVotants")
                .createMock();

        IElecteur electeurMocck1 = EasyMock.createMock(IElecteur.class);
        IElecteur electeurMocck2 = EasyMock.createMock(IElecteur.class);

        List<IElecteur> listElecteurs = new ArrayList<IElecteur>();
        List<IVote> listeVotes = new ArrayList<IVote>();

        //Scenario
        EasyMock.expect(sujet.isElectionOuverte()).andReturn(true);
        EasyMock.expect(electeurMocck1.getNumeroElecteur()).andReturn(2015L);
        EasyMock.expect(electeurMocck2.getNumeroElecteur()).andReturn(idElecteur);
        listElecteurs.add(electeurMocck1);
        listElecteurs.add(electeurMocck2);
        EasyMock.expect(sujet.getElecteurs()).andReturn(listElecteurs);

        listeVotes.add(voteMock);
        EasyMock.expect(sujet.getVotes()).andReturn(listeVotes);

        EasyMock.expect(sujet.getNbVotants()).andReturn(3l);
        sujet.setNbVotants(sujet.getNbVotants() + 1);

        //Replay
        EasyMock.replay(voteMock, sujet, electeurMocck1, electeurMocck2);

        //Test
        sujet.ajouterVote(voteMock, idElecteur);
        long nb = sujet.getNbVotants();

        //Replay
        EasyMock.replay(voteMock, sujet, electeurMocck1, electeurMocck2);

        Assert.assertEquals("on doit avoir 4", 4, nb );

    }

}

package tri;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlgoTriTest {

    private AlgoTri<Integer> algoTri;

   @Before
    public void init(){
       algoTri = new AlgoTri<Integer>();
   }

   @Test
    public void testAvecListeVide(){
       List<Integer> listeVide = new ArrayList<>();
       Assert.assertEquals("La liste doit être vide", listeVide, algoTri.tri(listeVide));
   }

   @Test
    public void testAvecSingleton(){
       List<Integer> singleton = new ArrayList<>();
       singleton.add(1);
       Assert.assertEquals("La liste doit contenir un élément", singleton, algoTri.tri(singleton)  );
   }

   @Test
    public void testAvecListeDeuxElements(){
        List<Integer> maListe = new ArrayList<>();
        maListe.add(3);
        maListe.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(3);

        Assert.assertEquals("La liste doit des éléments dans l'ordre",result , algoTri.tri(maListe));
    }


}

package appli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoTriTableTest {

    private AlgoTriTable algoTriTable;

    @Before
    public void init(){
        algoTriTable = new AlgoTriTable();
    }

    @Test
    public void testTableauNormalSansDoubon(){
        int[] maListe = {2, 5, 8, 1, 9};
        int[] expected = {1, 2, 5, 8,9};
        int[] result = algoTriTable.tri(maListe);

        Assert.assertArrayEquals("La liste doit avoir des éléments dans l'ordre", expected , result);

    }

    @Test
    public void testTableauNormalAvecDoubon(){
        int[] maListe = {2, 5, 5, 1, 9};
        int[] expected = {1, 2, 5, 5,9};
        int[] result = algoTriTable.tri(maListe);

        Assert.assertArrayEquals("La liste doit avoir des éléments dans l'ordre", expected , result);

    }

}

package appli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyFunctionTest {

    private MyFunction maFonction;
    private double x;

    @Before
    public void init(){
        maFonction = new MyFunction();
    }

    /**
     * Test de la fonction evaluate avec le chiffre +1
     */
    @Test
    public void testAvecPlusUn(){
        x = 1;
        Assert.assertEquals("La division par zéro est interdite", Double.POSITIVE_INFINITY, maFonction.evaluate(x), 0.0);
    }

    /**
     * Test de la fonction evaluate avec le chiffre -1
     */
    @Test
    public void testAvecMoinsUn(){
        x = -1;
        Assert.assertEquals("La division par zéro est interdite", Double.POSITIVE_INFINITY, maFonction.evaluate(x), 0.0);
    }

    /**
     * Test de la fonction evaluate avec le chiffre 0
     */
    @Test
    public void testAvecZero(){
        x = 0;
        Assert.assertEquals("La racine carrée d'un nombre négatif est interdite", Double.NaN, maFonction.evaluate(x), 0.0);
    }

    /**
     * Test de la fonction evaluate avec une valeur supérieur à 1
     */
    @Test
    public void testAvecDeux(){
        x = 2;
        double resultat = Math.sqrt((double)1/3);
        Assert.assertEquals("La fonction doit retourner une valeure", resultat, maFonction.evaluate(x), 0.0);
    }


    /**
     * Test de la fonction evaluate avec une valeur supérieu à 1
     */
    @Test
    public void testAvecMoinsDeux(){
        x = -2;
        double resultat = Math.sqrt((double)1/3);
        Assert.assertEquals("La fonction doit retourner une valeure", resultat, maFonction.evaluate(x), 0.0);
    }

    /**
     * Test avec des valeurs  proche des extremes proches de -1 et de 1
     */
    @Test
    public void testAvecValeursEpsilon(){

    }


}

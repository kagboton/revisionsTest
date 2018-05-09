package appli;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AlgoTriListe {

    AlgoTriTable algoTriTable;

    public AlgoTriListe() {
        algoTriTable = new AlgoTriTable();
    }

    /**
     * Je transforme une liste en tableau
     * @param list
     * @return un tableau t
     */
    public int[] liteToTable(List<Integer> list){
        int i = 0;
        ListIterator<Integer> iterator = list.listIterator();
        int taille = list.size();
        int[] t = new int[taille];

        while(iterator.hasNext()){
            t[i] = iterator.next();
            i++;
        }
        return t;
    }


    /**
     * Je transforme un tableau en liste
     * @param t
     * @return une liste
     */
    public List<Integer> tableToList(int[] t){
        List<Integer> liste = new ArrayList<>();
        for (int i = 0; i < t.length; i++){
            liste.add(t[i]);
        }
        return liste;
    }


    public List<Integer> tri(List<Integer> list){
         int[] table = liteToTable(list);
         table = algoTriTable.tri(table);
        return tableToList(table);
    }
}

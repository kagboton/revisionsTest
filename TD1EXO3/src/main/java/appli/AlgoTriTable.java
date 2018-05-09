package appli;

public class AlgoTriTable {

    public int[] tri(int[] table){
        int temp;

        for(int i = 0; i < table.length - 1; i++){
            for(int j = table.length -1; j > i ; j--){
                if(table[i] > table[j]){
                    //Je swap
                    temp = table[i];
                    table[i] = table[j];
                    table[j] = temp;
                }
            }
        }
        return table;
    }
}

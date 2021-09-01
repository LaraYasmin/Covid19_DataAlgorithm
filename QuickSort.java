public class QuickSort {
    public static void quickSort(String[][] vetor, int inicio, int fim, int coluna) {
             if (inicio < fim) {
                    int posicaoPivo = separar(vetor, inicio, fim, coluna);
                    quickSort(vetor, inicio, posicaoPivo - 1, coluna);
                    quickSort(vetor, posicaoPivo + 1, fim, coluna);
             }
       }

       public static int separar(String[][] vetor, int inicio, int fim, int coluna) {
             int pivo = Integer.parseInt(vetor[inicio][coluna]);
             String[] pivoaux = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                    if(vetor[i][coluna] == null) {
                        vetor[i][coluna] = "0";
                    }
                    if(vetor[f][coluna] == null) {
                        vetor[f][coluna] = "0";
                    }
                    if (Integer.parseInt(vetor[i][coluna]) <= pivo)
                           i++;
                    else if (pivo < Integer.parseInt(vetor[f][coluna]))
                           f--;
                    else {
                           String[] troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivoaux;
             return f;
       }

       public static void quickSortString(String[][] vetor, int inicio, int fim) {
             if (inicio < fim) {
                    int posicaoPivo = separarString(vetor, inicio, fim);
                    quickSortString(vetor, inicio, posicaoPivo - 1);
                    quickSortString(vetor, posicaoPivo + 1, fim);
             }
       }

       public static int separarString(String[][] vetor, int inicio, int fim) {
            for(int i = 0; i < vetor.length; i++) {
                if(vetor[i][4] == null) {
                    vetor[i][4] = "";
                }
            }
             String pivo = vetor[inicio][4];
             String[] pivoaux = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                    if ((vetor[i][4].compareTo(pivo) <= 0))
                           i++;
                    else if (pivo.compareTo(vetor[f][4]) < 0)
                           f--;
                    else {
                           String[] troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivoaux;
             return f;
       }
}
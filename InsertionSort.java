public class InsertionSort {

    public static void insertionSortMortesAcumuladas(String[][] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            if(vetor[i][10] == null) {
                vetor[i][10] = "0";
            }
        }

        for (int i = 1; i < vetor.length; i++) {
            String atual = vetor[i][10];
            String [] atualaux = vetor[i];
            int j = i - 1;
            if(vetor[j][10] == "last_available_deaths") {
                continue;
            } else {
                while (j >= 1 && Integer.parseInt(vetor[j][10]) >= Integer.parseInt(atual)) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
                vetor[j + 1] = atualaux;
            }
            
        }
    }

    public static void insertionSortQuantidadeDeCasos(String[][] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            if(vetor[i][7] == null) {
                vetor[i][7] = "0";
            }
        }

        for (int i = 1; i < vetor.length; i++) {
            String atual = vetor[i][7];
            String[] atualaux = vetor[i];
            int j = i - 1;
            if(vetor[j][7] == "last_available_confirmed") {
                continue;
            } else {
                while (j >= 1 && Integer.parseInt(vetor[j][7]) >= Integer.parseInt(atual)) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
                vetor[j + 1] = atualaux;
            }
        }
    }

    public static void insertionSortNomeCidade(String[][] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            if(vetor[i][4] == null) {
                vetor[i][4] = "";
            }
        }

        for (int i = 1; i < vetor.length; i++) {
            String atual = vetor[i][4];
            String[] atualaux = vetor[i];
            int j = i - 1;
            if(vetor[j][4] == "city") {
                continue;
            } else {
                while (j >= 1 && (vetor[j][4].compareTo(atual) >= 0)) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
                vetor[j + 1] = atualaux;
            }
        }
    }
}

public class QuickSortMedianaDeTres {
    public static void quicksortMedianaDeTres(String[][] A, int coluna){  
        for(int i = 0; i < A.length; i++) {
            if(A[i][coluna] == null) {
                A[i][coluna] = "0";
            }
        }

        quicksortMedianaDeTres(A, 1, A.length - 1, coluna);
    }

    private static void quicksortMedianaDeTres(String[][] A, int inicio, int fim, int coluna){        
        if(inicio < fim){
            int q = partition(A, inicio, fim, coluna);
            quicksortMedianaDeTres(A, inicio, q - 1, coluna);
            quicksortMedianaDeTres(A, q + 1, fim, coluna);            
        }
    }
    
    //Método de partição
    private static int partition(String[][] A, int inicio, int fim, int coluna){
        int meio = (inicio + fim)/2;
        String a = A[inicio][coluna];
        String b = A[meio][coluna];
        String c = A[fim][coluna];
        int medianaIndice; 
        if(Integer.parseInt(a) < Integer.parseInt(b)){
            if(Integer.parseInt(b) < Integer.parseInt(c)){
                medianaIndice = meio;
            }else{                
                if(Integer.parseInt(a) < Integer.parseInt(c)){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(Integer.parseInt(c) < Integer.parseInt(b)){
                medianaIndice = meio;
            }else{
                if(Integer.parseInt(c) < Integer.parseInt(a)){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swap(A, medianaIndice, fim);
        
        String pivo = A[fim][coluna];
        int i = inicio - 1;

        for(int j = inicio; j <= fim - 1; j++){
            if(Integer.parseInt(A[j][coluna]) <= Integer.parseInt(pivo)){
                i = i + 1;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, fim);
        return i + 1; 
    }
    
    private static void swap(String[][] A, int i, int j){
        String[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void quicksortMedianaDeTresString(String[][] A){  
        for(int i = 0; i < A.length; i++) {
            if(A[i][4] == null) {
                A[i][4] = "0";
            }
        }

        quicksortMedianaDeTresString(A, 1, A.length - 1);
    }

    private static void quicksortMedianaDeTresString(String[][] A, int inicio, int fim){        
        if(inicio < fim){
            int q = partitionString(A, inicio, fim);
            quicksortMedianaDeTresString(A, inicio, q - 1);
            quicksortMedianaDeTresString(A, q + 1, fim);            
        }
    }
    
    //Método de partição
    private static int partitionString(String[][] A, int inicio, int fim){
        int meio = (inicio + fim)/2;
        String a = A[inicio][4];
        String b = A[meio][4];
        String c = A[fim][4];
        int medianaIndice; 
        if(a.compareTo(b) < 0){
            if(b.compareTo(c) < 0){
                medianaIndice = meio;
            }else{                
                if(a.compareTo(c) < 0){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(c.compareTo(b) < 0){
                medianaIndice = meio;
            }else{
                if(c.compareTo(a) < 0){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        swapString(A, medianaIndice, fim);
        
        String pivo = A[fim][4];
        int i = inicio - 1;

        for(int j = inicio; j <= fim - 1; j++){
            if(A[j][4].compareTo(pivo) <= 0){
                i = i + 1;
                swapString(A, i, j);
            }
        }
        swapString(A, i + 1, fim);
        return i + 1; 
    }
    
    private static void swapString(String[][] A, int i, int j){
        String[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }     
}
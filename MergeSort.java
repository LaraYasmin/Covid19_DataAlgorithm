public class MergeSort {

    /* método que ordena o array usando merge sort tomando a coluna como parametro
    para ordenar por mortes acumuladas ou quantidade de casos */
    public static void mergeSort(int tamanho, String[][] vetor, int coluna) {
      int elementos = 1;
      int inicio, meio, fim;

      while(elementos < tamanho) {
        inicio = 1;

        while(inicio + elementos < tamanho) {
          meio = inicio + elementos;
          fim = inicio + 2 * elementos;
        
          if(fim > tamanho)
            fim = tamanho;
        
          intercala(vetor, inicio, meio, fim, coluna);
        
          inicio = fim;
        }
      
        elementos = elementos * 2;
      }
  }

  /* intercala para mortes acumuladas e quantidade de casos tomando a coluna como parametro*/
  public static void intercala(String[][] vetor, int inicio, int meio, int fim, int coluna) {
    String novoVetor[][] = new String[fim - inicio][16];
    int i = inicio;
    int m = meio;
    int pos = 0;
    
    while(i < meio && m < fim) {
        if(vetor[i][coluna] == null) {
            vetor[i][coluna] = "0";
        }
        if(vetor[m][coluna] == null) {
            vetor[m][coluna] = "0";
        }
      if(Integer.parseInt(vetor[i][coluna]) <= Integer.parseInt(vetor[m][coluna])) {
        novoVetor[pos] = vetor[i];
        pos = pos + 1;
        i = i + 1;
      } else {
        novoVetor[pos] = vetor[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    
    while(i < meio) {
      novoVetor[pos] = vetor[i];
      pos = pos + 1;
      i = i + 1;
    }
    
    while(m < fim) {
      novoVetor[pos] = vetor[m];
      pos = pos + 1;
      m = m + 1;
    }
    
    for(pos = 0, i = inicio; i < fim; i++, pos++) {
      vetor[i] = novoVetor[pos];
        }
    }

    /* método que ordena o array usando merge sort para strings
    para ordenar por nomes de cidade*/
    public static void mergeSortString(int tamanho, String[][] vetor) {
    int elementos = 1;
    int inicio, meio, fim;

    while(elementos < tamanho) {
      inicio = 1;

      while(inicio + elementos < tamanho) {
        meio = inicio + elementos;
        fim = inicio + 2 * elementos;
        
        if(fim > tamanho)
          fim = tamanho;
        
        intercalaString(vetor, inicio, meio, fim);
        
        inicio = fim;
      }
      
      elementos = elementos * 2;
    }
  }

 /* intercala para nomes de cidade*/
  public static void intercalaString(String[][] vetor, int inicio, int meio, int fim) {
    String novoVetor[][] = new String[fim - inicio][16];
    int i = inicio;
    int m = meio;
    int pos = 0;
    
    while(i < meio && m < fim) {
        if(vetor[i][4] == null) {
            vetor[i][4] = "0";
        }
        if(vetor[m][4] == null) {
            vetor[m][4] = "0";
        }
      if(vetor[i][4].compareTo(vetor[m][4]) < 0) {
        novoVetor[pos] = vetor[i];
        pos = pos + 1;
        i = i + 1;
      } else {
        novoVetor[pos] = vetor[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    
    while(i < meio) {
      novoVetor[pos] = vetor[i];
      pos = pos + 1;
      i = i + 1;
    }
    
    while(m < fim) {
      novoVetor[pos] = vetor[m];
      pos = pos + 1;
      m = m + 1;
    }
    
    for(pos = 0, i = inicio; i < fim; i++, pos++) {
      vetor[i] = novoVetor[pos];
        }
    }
}

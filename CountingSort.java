public class CountingSort {
  
  /* Método de ordena o array com couting sort usando a coluna das mortes acumuladas */
  public static void countingSortMortesAcumuladas(String array[][], int size) {
      for(int i = 0; i < array.length; i++) {
          if(array[i][10] == null) {
              array[i][10] = "0";
          }
      }
    
      String[][] output = new String[size + 2][16];

    String max = array[1][10];
    for (int i = 1; i < size; i++) {
      if (Integer.parseInt(array[i][10]) > Integer.parseInt(max))
        max = array[i][10];
    }
    String[] count = new String[Integer.parseInt(max) + 1];

    for (int i = 0; i <= Integer.parseInt(max); ++i) {
      count[i] = "0";
    }

    for (int i = 1; i < size; i++) {
      count[Integer.parseInt(array[i][10])] = Integer.toString(Integer.parseInt(count[Integer.parseInt(array[i][10])]) + 1);
    }

    for (int i = 1; i <= Integer.parseInt(max); i++) {
      count[i] = Integer.toString(Integer.parseInt(count[i]) + Integer.parseInt(count[i - 1]));
    }

    for (int i = size - 1; i >= 1; i--) {
      output[Integer.parseInt(count[Integer.parseInt(array[i][10])]) - 1] = array[i];
      count[Integer.parseInt(array[i][10])] = Integer.toString(Integer.parseInt(count[Integer.parseInt(array[i][10])]) - 1);
    }

    for (int i = 1; i < size - 1; i++) {
      array[i] = output[i];
    }
  }

  /* Método que ordena o array com o counting sort usando a coluna dos casos acumulados */
  public static void countingSortCasosAcumulados(String array[][], int size) {
      for(int i = 0; i < array.length; i++) {
          if(array[i][7] == null) {
              array[i][7] = "0";
          }
      }
    
      String[][] output = new String[size + 2][16];

    String max = array[1][7];
    for (int i = 1; i < size; i++) {
      if (Integer.parseInt(array[i][7]) > Integer.parseInt(max))
        max = array[i][7];
    }
    String[] count = new String[Integer.parseInt(max) + 1];

    for (int i = 0; i <= Integer.parseInt(max); ++i) {
      count[i] = "0";
    }

    for (int i = 1; i < size; i++) {
      count[Integer.parseInt(array[i][7])] = Integer.toString(Integer.parseInt(count[Integer.parseInt(array[i][7])]) + 1);
    }

    for (int i = 1; i <= Integer.parseInt(max); i++) {
      count[i] = Integer.toString(Integer.parseInt(count[i]) + Integer.parseInt(count[i - 1]));
    }

    for (int i = size - 1; i >= 1; i--) {
      output[Integer.parseInt(count[Integer.parseInt(array[i][7])]) - 1] = array[i];
      count[Integer.parseInt(array[i][7])] = Integer.toString(Integer.parseInt(count[Integer.parseInt(array[i][7])]) - 1);
    }

    for (int i = 1; i < size - 1; i++) {
      array[i] = output[i];
    }
  }

}
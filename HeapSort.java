public class HeapSort {
    public static void heapSort(String arr[][], int coluna) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(arr[i][coluna] == null) {
                arr[i][coluna] = "0";
            }
        }
 
        for (int i = n / 2 - 1; i >= 1; i--)
            heapify(arr, n, i, coluna);
 
        for (int i = n - 1; i > 0; i--) {
            String[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0, coluna);
        }
    }
 
    public static void heapify(String arr[][], int n, int i, int coluna) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        
        if (l < n && Integer.parseInt(arr[l][coluna]) > Integer.parseInt(arr[largest][coluna]))
            largest = l;
 
        if (r < n && Integer.parseInt(arr[r][coluna]) > Integer.parseInt(arr[largest][coluna]))
            largest = r;
 
        if (largest != i) {
            String[] swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest, coluna);
        }
    }

    public static void heapSortString(String arr[][], int coluna) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(arr[i][coluna] == null) {
                arr[i][coluna] = "";
            }
        }
 
        for (int i = n / 2 - 1; i >= 1; i--)
            heapifyString(arr, n, i, coluna);
 
        for (int i = n - 1; i > 0; i--) {
            String[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapifyString(arr, i, 0, coluna);
        }
    }

    public static void heapifyString(String arr[][], int n, int i, int coluna) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        
        if (l < n && arr[l][coluna].compareTo(arr[largest][coluna]) > 0)
            largest = l;
 
        if (r < n && arr[r][coluna].compareTo(arr[largest][coluna]) > 0)
            largest = r;
 
        if (largest != i) {
            String[] swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapifyString(arr, n, largest, coluna);
        }
    }
}
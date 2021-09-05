public class SelectionSort {

	/* ordena com selection sort as mortes acumuladas */
    public static void selectionSortMortesAcumuladas(String[][] v) {

		for (int i = 1; i < v.length - 1; i++)  
        { 
			int index = i;  
            for (int j = i + 1; j < v.length; j++){ 
				if(v[j][10] == null ) {
					v[j][10] = "0";
				} 
				if(v[index][10] == null) {
					v[index][10] = "0";
				}
				if (Integer.parseInt(v[j][10]) < Integer.parseInt(v[index][10])){  
                    index = j;
            	}     	  
        	}  
            String[] smallerNumber = v[index];   
            v[index] = v[i];  
            v[i] = smallerNumber;  
            
        } 
	
    }

	/* Ordena com selection sort por casos acumulados*/
	public static void selectionSortQuantidadeDeCasos(String[][] v) {

		for (int i = 1; i < v.length - 1; i++)  
        { 
			int index = i;  
            for (int j = i + 1; j < v.length; j++){ 
				if(v[j][7] == null ) {
					v[j][7] = "0";
				} 
				if(v[index][7] == null) {
					v[index][7] = "0";
				}
				if (Integer.parseInt(v[j][7]) < Integer.parseInt(v[index][7])){  
                    index = j;
            	}     	  
        	}  
            String[] smallerNumber = v[index];   
            v[index] = v[i];  
            v[i] = smallerNumber;  
            
        } 
	
    }

	/* Ordena com selection sort por nomes de cidade */
	static void selectionSortNomeCidade(String[][] v) {
    	for(int i = 0; i < v.length - 1; i++) {

        	int min_index = i;
        	String minStr = v[i][4];
        	for(int j = i + 1; j < v.length; j++)	{
				if(v[j][4] == null) {
					v[j][4] = "";
				}
				if(minStr == null) {
					minStr = "";
				}
            	if(v[j][4].compareTo(minStr) < 0) {
                	minStr = v[j][4];
                	min_index = j;
            	}
        	}

    		if(min_index != i) {
        		String[] temp = v[min_index];
        		v[min_index] = v[i];
        		v[i] = temp;
    		}
    	}
	}
}
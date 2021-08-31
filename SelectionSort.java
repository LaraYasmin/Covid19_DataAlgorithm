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
            String smallerNumber = v[index][10];   
            v[index][10] = v[i][10];  
            v[i][10] = smallerNumber;  
            
        } 
	
    }
}

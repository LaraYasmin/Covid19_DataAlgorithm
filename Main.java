import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	public static final String CSV_PATH = "./database/covid19-49bdf44a58bf4ebfa5415b1eabadd3db.csv";
	public static String aList[] = new String[1];

    public static void main(String[] args) throws IOException {
		readAllLinesFromFile(CSV_PATH);

		String selectionMortesAcumuladas[][] = convertToSplited(aList);
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		writeAllLinesToFile("selectionMortesAcumuladas", selectionMortesAcumuladas);
	}

	/*Lê as linhas do arquivo e armazena em um array */
	public static String[] readAllLinesFromFile(String path) throws IOException {

    	FileReader fileReader = new FileReader(path);
    	BufferedReader bufferedReader = new BufferedReader(fileReader);
    	String line = "";
    	while( (line = bufferedReader.readLine()) != null){
			String[] longer = new String[aList.length + 1];
    		System.arraycopy(aList, 0, longer, 0, aList.length);
    		longer[aList.length] = line;
			aList = new String[longer.length];
			for(int i = 0; i < longer.length; i++) {
				aList[i] = longer[i];
			}
		}
    	bufferedReader.close();

    	return aList;

	}

	/* converte o vetor de strings para um array de linhas e colunas */
	public static String[][] convertToSplited(String[] arrSplit) {
    	String [][] splitArr = new String[aList.length][16];
		int cont = 0;
    	for(String arrSplits : arrSplit) {
			if(arrSplits != null) {
				String[] parts = arrSplits.split(",");
				for(int i = 0; i < 16; i++) {
				splitArr[cont][i] = parts[i];
				}
				cont++;
			}
    	}

    	return splitArr;
	}

	/* Escreve o array de linhas e colunas em um novo arquivo csv*/
	public static void writeAllLinesToFile(String fileName, String[][] aList) throws IOException {
		File newFile = new File("arquivos-csv/" + fileName + ".csv");
		String aux = "";
		String line = "";
    	try{
            FileWriter file = new FileWriter("arquivos-csv/" + fileName + ".csv");
            PrintWriter write = new PrintWriter(file);
            for (int i = 0; i < aList.length; i++){
				for(int j = 0; j < 16; j++) {
					aux = aList[i][j] + ",";
					line += aux;
				}
            	write.println(line);
				line =  "";
				aux = "";
        	}
        	write.close();
    	} catch(IOException exe){
        	System.out.println("Cannot create file");
    	}
	}

}
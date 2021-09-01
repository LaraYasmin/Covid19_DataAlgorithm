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
		
		/*lê o arquivo de dados*/
		readAllLinesFromFile(CSV_PATH);

		/* Selection Sort*/

		// Mortes acumuladas
		String selectionMortesAcumuladas[][] = convertToSplited(aList);
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		writeAllLinesToFile("selectionMortesAcumuladas", selectionMortesAcumuladas);
		// Quantidade de casos
		String selectionQuantidadeDeCasos[][] = convertToSplited(aList);
		SelectionSort.selectionSortQuantidadeDeCasos(selectionQuantidadeDeCasos);
		writeAllLinesToFile("selectionQuantidadeDeCasos", selectionQuantidadeDeCasos);
		// Nome de cidades
		String selectionNomeCidade[][] = convertToSplited(aList);
		SelectionSort.selectionSortNomeCidade(selectionNomeCidade);
		writeAllLinesToFile("selectionNomeCidade", selectionNomeCidade);

		/* Insertion Sort */

		/* Merge Sort */
		// Mortes acumuladas
		String mergeMortesAcumuladas[][] = convertToSplited(aList);
		MergeSort.mergeSort(mergeMortesAcumuladas.length, mergeMortesAcumuladas, 10);
		writeAllLinesToFile("mergeMortesAcumuladas", mergeMortesAcumuladas);
		// Quantidade de casos
		String mergeQuantidadeDeCasos[][] = convertToSplited(aList);
		MergeSort.mergeSort(mergeQuantidadeDeCasos.length, mergeQuantidadeDeCasos, 7);
		writeAllLinesToFile("mergeQuantidadeDeCasos", mergeQuantidadeDeCasos);
		// Quantidade de casos
		String mergeNomeCidade[][] = convertToSplited(aList);
		MergeSort.mergeSortString(mergeNomeCidade.length, mergeNomeCidade);
		writeAllLinesToFile("mergeNomeCidade", mergeNomeCidade);

		/* Quick Sort */
		// Mortes acumuladas
		String quickMortesAcumuladas[][] = convertToSplited(aList);
		QuickSort.quickSort(quickMortesAcumuladas, 1, quickMortesAcumuladas.length - 1, 10);
		writeAllLinesToFile("quickMortesAcumuladas", quickMortesAcumuladas);
		// Quantidade de casos
		String quickQuantidadeDeCasos[][] = convertToSplited(aList);
		QuickSort.quickSort(quickQuantidadeDeCasos, 1, quickQuantidadeDeCasos.length - 1, 7);
		writeAllLinesToFile("quickQuantidadeDeCasos", quickQuantidadeDeCasos);
		// Quantidade de casos
		String quickNomeCidade[][] = convertToSplited(aList);
		QuickSort.quickSortString(quickNomeCidade, 1, quickNomeCidade.length - 1);
		writeAllLinesToFile("quickNomeCidade", quickNomeCidade);

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
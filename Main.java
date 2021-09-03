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
		long startTime = System.currentTimeMillis();
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		long endTime = System.currentTimeMillis();
		System.out.println("Selection Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("selectionMortesAcumuladas", selectionMortesAcumuladas);
		// Quantidade de casos
		String selectionQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortQuantidadeDeCasos(selectionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("selectionQuantidadeDeCasos", selectionQuantidadeDeCasos);
		// Nome de cidades
		String selectionNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortNomeCidade(selectionNomeCidade);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort Nomes de Cidade: " + (endTime - startTime));
		writeAllLinesToFile("selectionNomeCidade", selectionNomeCidade);

		/* Insertion Sort */
		// Mortes acumuladas
		String insertionMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortMortesAcumuladas(insertionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("insertionMortesAcumuladas", insertionMortesAcumuladas);
		// Quantidade de casos
		String insertionQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortQuantidadeDeCasos(insertionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("insertionQuantidadeDeCasos", insertionQuantidadeDeCasos);
		// Nome de cidades
		String insertionNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortNomeCidade(insertionNomeCidade);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort Nomes de Cidades: " + (endTime - startTime));
		writeAllLinesToFile("insertionNomeCidade", insertionNomeCidade);

		/* Merge Sort */
		// Mortes acumuladas
		String mergeMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeMortesAcumuladas.length, mergeMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("mergeMortesAcumuladas", mergeMortesAcumuladas);
		// Quantidade de casos
		String mergeQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeQuantidadeDeCasos.length, mergeQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("mergeQuantidadeDeCasos", mergeQuantidadeDeCasos);
		// Quantidade de casos
		String mergeNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSortString(mergeNomeCidade.length, mergeNomeCidade);
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort Nomes de Cidade: " + (endTime - startTime));
		writeAllLinesToFile("mergeNomeCidade", mergeNomeCidade);

		/* Quick Sort */
		// Mortes acumuladas
		String quickMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickMortesAcumuladas, 1, quickMortesAcumuladas.length - 1, 10);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("quickMortesAcumuladas", quickMortesAcumuladas);
		// Quantidade de casos
		String quickQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickQuantidadeDeCasos, 1, quickQuantidadeDeCasos.length - 1, 7);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("quickQuantidadeDeCasos", quickQuantidadeDeCasos);
		// Quantidade de casos
		String quickNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSortString(quickNomeCidade, 1, quickNomeCidade.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Nomes de Cidade: " + (endTime - startTime));
		writeAllLinesToFile("quickNomeCidade", quickNomeCidade);

		/* Quick Sort Mediana de tres*/
		// Mortes acumuladas
		String quickMedTresMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("quickMedianaTresMortesAcumuladas", quickMedTresMortesAcumuladas);
		// Quantidade de casos
		String quickMedTresCasosAcumulados[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresCasosAcumulados, 7);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("quickMedianaTresCasosAcumulados", quickMedTresCasosAcumulados);
		// Quantidade de casos
		String quickMedTresNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTresString(quickMedTresNomeCidade);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade: " + (endTime - startTime));
		writeAllLinesToFile("quickMedianaTresNomeCidade", quickMedTresNomeCidade);

		/* Heap Sort */
		// Mortes acumuladas
		String heapMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		System.out.println("Heap Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("heapMortesAcumuladas", heapMortesAcumuladas);
		// Quantidade de casos
		String heapQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		System.out.println("Heap Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("heapQuantidadeDeCasos", heapQuantidadeDeCasos);
		// Quantidade de casos
		String heapNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSortString(heapNomeCidade, 4);
		endTime = System.currentTimeMillis();
		System.out.println("Heap Sort Nomes de Cidade: " + (endTime - startTime));
		writeAllLinesToFile("heapNomeCidade", heapNomeCidade);

		/* Counting Sort */
		// Mortes acumuladas
		String countMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortMortesAcumuladas(countMortesAcumuladas, countMortesAcumuladas.length);
		endTime = System.currentTimeMillis();
		System.out.println("Counting Sort Mortes Acumuladas: " + (endTime - startTime));
		writeAllLinesToFile("countingMortesAcumuladas", countMortesAcumuladas);
		// // Quantidade de casos
		String countCasosAcumulados[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortCasosAcumulados(countCasosAcumulados, countCasosAcumulados.length);
		endTime = System.currentTimeMillis();
		System.out.println("Counting Sort Casos Acumulados: " + (endTime - startTime));
		writeAllLinesToFile("countingCasosAcumulados", countCasosAcumulados);
		// Quantidade de casos
		// Não é possível fazer



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
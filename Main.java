import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	/*Caminho em que o CSV original está localizado*/ 
	public static final String CSV_PATH = "./database/covid19-49bdf44a58bf4ebfa5415b1eabadd3db.csv";
	/*Array que guarda todos os dados do CSV original*/ 
	public static String aList[] = new String[1];

	/*Método principal*/
    public static void main(String[] args) throws IOException {
		
		/*lê o arquivo de dados*/
		readAllLinesFromFile(CSV_PATH);

		/* ===== Selection Sort =====*/
		// Ordenação para o caso médio de Mortes Acumuladas com Selection Sort
		String selectionMortesAcumuladas[][] = convertToSplited(aList);
		long startTime = System.currentTimeMillis();
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		long endTime = System.currentTimeMillis();
		double memoriaUtilizada = ((double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));;
		System.out.println("Selection Sort Mortes Acumuladas medio caso: " + (endTime - startTime));
		System.out.println("Selection Sort Mortes Acumuladas medio caso memoria: " + memoriaUtilizada);
		writeAllLinesToFile("selectionMortesAcumuladas", selectionMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Selection Sort
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ((double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));;
		System.out.println("Selection Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Selection Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Selection Sort
		selectionMortesAcumuladas = inverterVetor(selectionMortesAcumuladas);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortMortesAcumuladas(selectionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Selection Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Selection Sort
		String selectionQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortQuantidadeDeCasos(selectionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Casos Acumulados medio caso: " + (endTime - startTime));
		System.out.println("Selection Sort Casos Acumulados medio caso memoria: " + memoriaUtilizada);
		writeAllLinesToFile("selectionQuantidadeDeCasos", selectionQuantidadeDeCasos);

		// Ordenação para o melhor caso de Quantidade de casos com Selection Sort
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortQuantidadeDeCasos(selectionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Selection Sort Casos Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Selection Sort
		selectionQuantidadeDeCasos = inverterVetor(selectionQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortQuantidadeDeCasos(selectionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Selection Sort Casos Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o  caso medio de Nomes de Cidades com Selection Sort
		String selectionNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortNomeCidade(selectionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Nomes de Cidade caso medio: " + (endTime - startTime));
		System.out.println("Selection Sort Nomes de Cidade caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("selectionNomeCidade", selectionNomeCidade);

		// Ordenação para o melhor caso de Nomes de Cidade com Selection Sort
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortNomeCidade(selectionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Nomes de Cidade melhor caso: " + (endTime - startTime));
		System.out.println("Selection Sort Nomes de Cidade melhor caso memoria: " + memoriaUtilizada);
		
		// Ordenação para o pior caso de Nomes de Cidade com Selection Sort
		selectionNomeCidade = inverterVetor(selectionNomeCidade);
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSortNomeCidade(selectionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Selection Sort Nomes de Cidade pior caso: " + (endTime - startTime));
		System.out.println("Selection Sort Nomes de Cidade pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* ===== Insertion Sort ===== */
		// Ordenação para o caso medio de Mortes Acumuladas com Insertion Sort
		String insertionMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortMortesAcumuladas(insertionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Insertion Sort Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("insertionMortesAcumuladas", insertionMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Insertion Sort
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortMortesAcumuladas(insertionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Insertion Sort
		insertionMortesAcumuladas = inverterVetor(insertionMortesAcumuladas);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortMortesAcumuladas(insertionMortesAcumuladas);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Insertion Sort
		String insertionQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortQuantidadeDeCasos(insertionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Insertion Sort Casos Acumulados caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("insertionQuantidadeDeCasos", insertionQuantidadeDeCasos);

		// Ordenação para o melhor caso de Quantidade de casos com Insertion Sort
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortQuantidadeDeCasos(insertionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Casos Acumulados melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Insertion Sort
		insertionQuantidadeDeCasos = inverterVetor(insertionQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortQuantidadeDeCasos(insertionQuantidadeDeCasos);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Casos Acumulados pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Nomes de Cidades com Insertion Sort
		String insertionNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortNomeCidade(insertionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Nomes de Cidades caso medio: " + (endTime - startTime));
		System.out.println("Insertion Sort Nomes de Cidades caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("insertionNomeCidade", insertionNomeCidade);

		// Ordenação para o melhor caso de Nomes de Cidade com Insertion Sort
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortNomeCidade(insertionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Nomes de Cidades melhor caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Nomes de Cidades melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Nomes de Cidade com Insertion Sort
		insertionNomeCidade = inverterVetor(insertionNomeCidade);
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSortNomeCidade(insertionNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Insertion Sort Nomes de Cidades pior caso: " + (endTime - startTime));
		System.out.println("Insertion Sort Nomes de Cidades pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* Merge Sort */
		// Ordenação para o caso medio de Mortes Acumuladas com Merge Sort
		String mergeMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeMortesAcumuladas.length, mergeMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Merge Sort Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("mergeMortesAcumuladas", mergeMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Merge Sort
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeMortesAcumuladas.length, mergeMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Merge Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Merge Sort
		mergeMortesAcumuladas = inverterVetor(mergeMortesAcumuladas);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeMortesAcumuladas.length, mergeMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Merge Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Merge Sort
		String mergeQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeQuantidadeDeCasos.length, mergeQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Merge Sort Casos Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("mergeQuantidadeDeCasos", mergeQuantidadeDeCasos);

		// Ordenação para o melhor caso de Quantidade de casos com Merge Sort
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeQuantidadeDeCasos.length, mergeQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Merge Sort Casos Acumulados melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Merge Sort
		mergeQuantidadeDeCasos = inverterVetor(mergeQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(mergeQuantidadeDeCasos.length, mergeQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Merge Sort Casos Acumulados pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Nomes de Cidade com Merge Sort
		String mergeNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSortString(mergeNomeCidade.length, mergeNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Nomes de Cidade caso medio: " + (endTime - startTime));
		System.out.println("Merge Sort Nomes de Cidade caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("mergeNomeCidade", mergeNomeCidade);

		// Ordenação para o melhor caso de Nomes de Cidade com Merge Sort
		startTime = System.currentTimeMillis();
		MergeSort.mergeSortString(mergeNomeCidade.length, mergeNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Nomes de Cidade melhor caso: " + (endTime - startTime));
		System.out.println("Merge Sort Nomes de Cidade melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Nomes de Cidade com Merge Sort
		mergeNomeCidade = inverterVetor(mergeNomeCidade);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSortString(mergeNomeCidade.length, mergeNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Merge Sort Nomes de Cidade pior caso: " + (endTime - startTime));
		System.out.println("Merge Sort Nomes de Cidade pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* ===== Quick Sort ===== */
		// Ordenação para o medio de Mortes Acumuladas com Quick Sort
		String quickMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickMortesAcumuladas, 1, quickMortesAcumuladas.length - 1, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickMortesAcumuladas", quickMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Quick Sort
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickMortesAcumuladas, 1, quickMortesAcumuladas.length - 1, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Quick Sort
		quickMortesAcumuladas = inverterVetor(quickMortesAcumuladas);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickMortesAcumuladas, 1, quickMortesAcumuladas.length - 1, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Quick Sort
		String quickQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickQuantidadeDeCasos, 1, quickQuantidadeDeCasos.length - 1, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Casos Acumulados caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickQuantidadeDeCasos", quickQuantidadeDeCasos);

		// Ordenação para o melhor caso de Quantidade de casos com Quick Sort
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickQuantidadeDeCasos, 1, quickQuantidadeDeCasos.length - 1, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Casos Acumulados melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Quick Sort
		quickQuantidadeDeCasos = inverterVetor(quickQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(quickQuantidadeDeCasos, 1, quickQuantidadeDeCasos.length - 1, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Casos Acumulados pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Nomes de Cidade com Quick Sort
		String quickNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSort.quickSortString(quickNomeCidade, 1, quickNomeCidade.length - 1);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Nomes de Cidade caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Nomes de Cidade caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickNomeCidade", quickNomeCidade);

		// Ordenação para o melhor caso de Nomes de cidade com Quick Sort
		startTime = System.currentTimeMillis();
		QuickSort.quickSortString(quickNomeCidade, 1, quickNomeCidade.length - 1);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Nomes de Cidade melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Nomes de Cidade melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de nomes de cidade com Quick Sort
		quickNomeCidade = inverterVetor(quickNomeCidade);
		startTime = System.currentTimeMillis();
		QuickSort.quickSortString(quickNomeCidade, 1, quickNomeCidade.length - 1);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Nomes de Cidade pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Nomes de Cidade pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* ===== Quick Sort Mediana de tres ===== */
		// Ordenação para o caso medio de Mortes Acumuladas com Quick Sort mediana de tres
		String quickMedTresMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickMedianaTresMortesAcumuladas", quickMedTresMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Quick Sort mediana de tres 
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Quick Sort mediana de tres 
		quickMedTresMortesAcumuladas = inverterVetor(quickMedTresMortesAcumuladas);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);
		
		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Quick Sort mediana de tres
		String quickMedTresCasosAcumulados[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresCasosAcumulados, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickMedianaTresCasosAcumulados", quickMedTresCasosAcumulados);

		// Ordenação para o melhor caso de Quantidade de casos com Quick Sort mediana de tres
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresCasosAcumulados, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Quick Sort mediana de tres 
		quickMedTresCasosAcumulados = inverterVetor(quickMedTresCasosAcumulados);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTres(quickMedTresCasosAcumulados, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Casos Acumulados pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Nomes de cidade com Quick Sort mediana de tres
		String quickMedTresNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTresString(quickMedTresNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade caso medio: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("quickMedianaTresNomeCidade", quickMedTresNomeCidade);

		// Ordenação para o melhor caso de Nomes de cidade com Quick Sort mediana de tres 
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTresString(quickMedTresNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade melhor caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Nomes de cidade com Quick Sort mediana de tres 
		quickMedTresNomeCidade = inverterVetor(quickMedTresNomeCidade);
		startTime = System.currentTimeMillis();
		QuickSortMedianaDeTres.quicksortMedianaDeTresString(quickMedTresNomeCidade);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade pior caso: " + (endTime - startTime));
		System.out.println("Quick Sort Mediana de Tres Nomes de Cidade pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* ===== Heap Sort ===== */
		// Ordenação para o caso medio de Mortes Acumuladas com Heap Sort
		String heapMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Heap Sort Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("heapMortesAcumuladas", heapMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Heap Sort
		heapMortesAcumuladas = heapAux(heapMortesAcumuladas);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Heap Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Heap Sort
		heapMortesAcumuladas = inverterVetor(heapMortesAcumuladas);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapMortesAcumuladas, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Heap Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Mortes Acumuladas com Heap Sort
		String heapQuantidadeDeCasos[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapQuantidadeDeCasos, 7);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Heap Sort Casos Acumulados caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("heapQuantidadeDeCasos", heapQuantidadeDeCasos);

		// Ordenação para o melhor caso de Mortes Acumuladas com Heap Sort
		heapQuantidadeDeCasos = heapAux(heapQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapQuantidadeDeCasos, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Quantidade de Casos melhor caso: " + (endTime - startTime));
		System.out.println("Heap Sort Quantidade Casos melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Heap Sort
		heapQuantidadeDeCasos = inverterVetor(heapQuantidadeDeCasos);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapQuantidadeDeCasos, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Quantidade de Casos pior caso: " + (endTime - startTime));
		System.out.println("Heap Sort Quantidade de Casos pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Heap Sort
		String heapNomeCidade[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		HeapSort.heapSortString(heapNomeCidade, 4);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Nomes de Cidade caso medio: " + (endTime - startTime));
		System.out.println("Heap Sort Nomes de Cidade caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("heapNomeCidade", heapNomeCidade);

		// Ordenação para o melhor caso de Quantidade de casos com Heap Sort
		heapNomeCidade = heapAux(heapNomeCidade);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapNomeCidade, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Nome de Cidade melhor caso: " + (endTime - startTime));
		System.out.println("Heap Sort Nomes de Cidade melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Heap Sort
		heapNomeCidade = inverterVetor(heapNomeCidade);
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(heapNomeCidade, 10);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Heap Sort Nome de Cidade pior caso: " + (endTime - startTime));
		System.out.println("Heap Sort Nome de Cidade pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		/* ===== Counting Sort ===== */
		// Ordenação para o caso medio de Mortes Acumuladas com Counting Sort
		String countMortesAcumuladas[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortMortesAcumuladas(countMortesAcumuladas, countMortesAcumuladas.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Mortes Acumuladas caso medio: " + (endTime - startTime));
		System.out.println("Counting Sort Mortes Acumuladas caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("countingMortesAcumuladas", countMortesAcumuladas);

		// Ordenação para o melhor caso de Mortes Acumuladas com Counting Sort
		startTime = System.currentTimeMillis();
		CountingSort.countingSortMortesAcumuladas(countMortesAcumuladas, countMortesAcumuladas.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Mortes Acumuladas melhor caso: " + (endTime - startTime));
		System.out.println("Counting Sort Mortes Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Mortes Acumuladas com Counting Sort
		countMortesAcumuladas = inverterVetor(countMortesAcumuladas);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortMortesAcumuladas(countMortesAcumuladas, countMortesAcumuladas.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Mortes Acumuladas pior caso: " + (endTime - startTime));
		System.out.println("Counting Sort Mortes Acumuladas pior caso memoria: " + memoriaUtilizada);

		System.out.println("====================================================================");

		// Ordenação para o caso medio de Quantidade de casos com Counting Sort
		String countCasosAcumulados[][] = convertToSplited(aList);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortCasosAcumulados(countCasosAcumulados, countCasosAcumulados.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Casos Acumulados caso medio: " + (endTime - startTime));
		System.out.println("Counting Sort Casos Acumulados caso medio memoria: " + memoriaUtilizada);
		writeAllLinesToFile("countingCasosAcumulados", countCasosAcumulados);

		// Ordenação para o melhor caso de Quantidade de casos com Counting Sort
		startTime = System.currentTimeMillis();
		CountingSort.countingSortCasosAcumulados(countCasosAcumulados, countCasosAcumulados.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Casos Acumulados melhor caso: " + (endTime - startTime));
		System.out.println("Counting Sort Casos Acumuladas melhor caso memoria: " + memoriaUtilizada);

		// Ordenação para o pior caso de Quantidade de casos com Counting Sort
		countCasosAcumulados = inverterVetor(countCasosAcumulados);
		startTime = System.currentTimeMillis();
		CountingSort.countingSortCasosAcumulados(countCasosAcumulados, countCasosAcumulados.length);
		endTime = System.currentTimeMillis();
		memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
		System.out.println("Counting Sort Casos Acumulados pior caso: " + (endTime - startTime));
		System.out.println("Counting Sort Casos Acumuladas pior caso memoria: " + memoriaUtilizada);

		// Nome de cidade
		// Não é possível fazer counting sort com strings

	}

	/*Lê todas as linhas do arquivo e armazena em um vetor dinamico */
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

	/* converte o vetor dinamico para um array de linhas e colunas */
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

	/* Inverte o vetor já ordenado para fazer o calculo do pior caso*/
	public static String[][] inverterVetor(String vet[][]) {		
        String[] temp;		
        for (int i = 0; i < vet.length; i++) {
            for (int j = 1; j < i; j++) {
                temp = vet[i];
                vet[i] = vet[j];
                vet[j] = temp;
            }
        } 		
        return vet;		
    }

	/* Método auxiliar para o heap sort nao dar erro nos calculos de melhor e pior caso (exclui o ultimo elemento do array)*/
	public static String[][] heapAux(String vet[][]) {		
        String[][] temp = new String[vet.length][16];		
        for (int i = 0; i < vet.length - 1; i++) {
            temp[i] = vet[i];
        } 		
        return temp;		
    }
}
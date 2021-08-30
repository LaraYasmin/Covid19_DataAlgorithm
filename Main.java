import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	public static final String CSV_PATH = "./database/covid19-49bdf44a58bf4ebfa5415b1eabadd3db.csv";
	public static boolean append = true;
	public static String aList[] = new String[1];

    public static void main(String[] args) throws IOException {
 
		/*String path = "./database/covid19-49bdf44a58bf4ebfa5415b1eabadd3db.csv"; 

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}*/

		readAllLinesFromFile(CSV_PATH);
    	/*System.out.println("Unsorted:\n");
    	for(int i = 0; i < aList.length; i++) {
			System.out.println(aList[i]);
    	}*/

		String aArr[][] = convertToSplited(aList);

		for(int j = 0; j < aArr.length; j++) {
			System.out.println(Arrays.toString(aArr[j]));
		}
	}

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

}
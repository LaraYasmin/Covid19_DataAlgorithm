package covid_data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class analise {

    public static void main(String[] args) {
 
		String path = "./database/covid19-49bdf44a58bf4ebfa5415b1eabadd3db.csv"; 

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
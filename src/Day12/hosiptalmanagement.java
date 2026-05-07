package Day12;
import java.io.*;
public class hosiptalmanagement {
	public static void main(String[] args) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"));
			writer.write("Patient ID: 303\n");
			writer.write("Patient Name: Suresh\n");
			writer.write("Disease: Fever\n");
			
			writer.close();
			System.out.println("Patient record saved.");
		
            BufferedReader reader = new BufferedReader( new FileReader("patients.txt"));
            String line;
            System.out.println("\nMedical Report");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } 
		catch (IOException e) {
            System.out.println(e);
        }
		
	}
}

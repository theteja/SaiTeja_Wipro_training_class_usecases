package Day12;
import java.io.*;
public class bankapp {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("accounts.txt");
			
			writer.write("Account Number: 101\n");
			writer.write("Customer Name: Teja\n");
			writer.write("Balance: 100000\n");
			
			
			writer.close();
			System.out.println("Account details saved");
		}
		catch (IOException e){
			System.out.println(e);
		}
		
		try {
			FileWriter writer = new FileWriter("transactions.txt");
			writer.write("Deposited: 1000\n");
			writer.write("Withdrawn: 7000\n");
			writer.close();
			
			System.out.println("Transaction histoty saved");
		
			BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
			
			String line;
			
			System.out.println("Account Details");
			
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			reader.close();
		}catch (IOException e){
			System.out.println(e);
		}
	}

}

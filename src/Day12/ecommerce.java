package Day12;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class ecommerce {

	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("order.txt");
			
			writer.write("Order ID: 202\n");
			writer.write("Product: Phone\n");
			writer.write("Price: 50000\n");
			writer.write("Customer Shipping Address: Andhra Pradesh\n");
			
			writer.close();
			System.out.println("Order details saved");	
		
			PrintWriter invoice = new PrintWriter("invoice.txt");
			invoice.println("------ INVOICE ------");
            invoice.println("Order ID: 501\n");
            invoice.println("Product: Laptop\n");
            invoice.println("Amount Paid: 65000\n");
            
            invoice.close();
            System.out.println("Invoice generated.");
		}
		catch (IOException e) {
            System.out.println(e);
        }

	}

}

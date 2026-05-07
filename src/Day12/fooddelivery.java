package Day12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class fooddelivery {

	public static void main(String[] args) {
		try {
			FileWriter menu =  new FileWriter("menu.txt");
			
			menu.write("Pizza 200\n");
			menu.write("Briyani 300\n");
			menu.write("Burger 200\n");
			menu.close();
			
		
			FileWriter order =  new FileWriter("order.txt");
			
			order.write("Customer Name: Teja\n");
			order.write("Orderes Item: Biryani\n");
			order.write("Quantity: 2\n");
			
			order.close();
			
			System.out.println("Order saved");
		

			BufferedWriter log = new BufferedWriter(new FileWriter("deliverylog.txt"));

            log.write("Order Delivered Successfully");
            log.close();
            System.out.println("Delivery log updated.");
        } 
		catch (IOException e) {
            System.out.println(e);
        }

	}

}

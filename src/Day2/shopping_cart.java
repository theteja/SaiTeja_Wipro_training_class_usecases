package Day2;
import java.util.Scanner;
public class shopping_cart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double total = 0;
		double price;

        System.out.print("Enter price : ");
        price = sc.nextDouble();

        while (price != 0) {
            total += price;
            System.out.print("Enter price : ");
            price = sc.nextDouble();
        }

        System.out.println("Total is = " + total);
		
				
	}

}

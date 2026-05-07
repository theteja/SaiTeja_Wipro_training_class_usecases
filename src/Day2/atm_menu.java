//4.Create a menu-driven program for ATM operations
package Day2;

import java.util.Scanner;
public class atm_menu {

public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int option = 0;
		int balance = 10000;
		do{
			System.out.println("1.Check balance ");
			System.out.println("2. Deposit ");
			System.out.println("3.Withdrawal ");
			System.out.println("4.Exit");
			
			System.out.print("Enter option: ");
            option = sc.nextInt(); 
			if(option == 1) {
                System.out.println("Balance: " + balance);
            }
			else if(option == 2) {
				System.out.println("Enter amount");
				 balance += sc.nextDouble();
				 System.out.println("Balance: " + balance);
			}
			else if (option == 3) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                balance -= amt;
                System.out.println("Balance: " + balance);
            }
	}while(option != 4);

}
}
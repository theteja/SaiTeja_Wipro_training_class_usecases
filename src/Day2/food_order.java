//5.Create a program where user selects food item number and the program displays item name and price.
package Day2;
public class food_order {
	public static void main(String[] args) {
		int option = 2;
		switch( option) {
			case 1:
				System.out.println("Selected the Pizza");
				break;
				
			case 2:
				System.out.println("Selected the burger");
				break;
			case 3:
				System.out.println("Selected the Cool Drink");
				break;
			default:
					System.out.println("Selected the Invalid option");
						
		}
		
	}

}

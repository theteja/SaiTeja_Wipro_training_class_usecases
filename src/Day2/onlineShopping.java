package Day2;

public class onlineShopping {
	public static void main(String[] args) {

        double amount = 1200;
        double discount = 10;

        if (amount > 1000) {
            discount = amount * 0.10;
        } 
        else {
            discount = 0;
        }

        double finalAmount = amount - discount;

        System.out.println("Total Amount: " + amount);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);
    }
}



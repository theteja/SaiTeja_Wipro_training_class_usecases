package Day5;

class PaymentSystem{
	public final void processPayment(double amount) {
		System.out.println("Processing secure payment of " + amount);
		
	}
}
class UpiService extends PaymentSystem{
	

	
	
	public void makePayment(double amount) {

        processPayment(amount);
	}
}

public class paySystem {

	public static void main(String[] args) {
		UpiService upi = new UpiService();
		upi.makePayment(2000);
	}

}

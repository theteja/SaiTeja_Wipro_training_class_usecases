package Day5;

public class paymentinterface {
	interface Payment{
		void pay(double amount);
		
		default void paymentStatus() {
			System.out.println("Payment processed Successfully");
			}
		
		default boolean validate(double amount) {
			if(amount <= 0) {
				System.out.println("Invalid payment amount");
				return false;
			}
			return true;
		}
	}
	
	static class upiPayment implements Payment{
		private String upiId;
		
		public upiPayment(String upiId) {
			this.upiId=upiId;
		}

		@Override
		public void pay(double amount) {
			if(validate(amount)) {
				System.out.println("Paying this amount "+ amount +" using UPI ID: " + upiId);
				paymentStatus();
			}
			
		}	
	}
	public static void main(String[] args) {
		Payment upi = new upiPayment("teja");
		
		upi.pay(1000);
		upi.pay(500);
	}
}

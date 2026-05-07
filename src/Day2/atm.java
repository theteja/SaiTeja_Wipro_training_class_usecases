package Day2;

public class atm {
	public static void main(String[] args) {
		double balance = 10000;
		double withdraw = 2000;
		double remainingbalance = balance-withdraw;
		if(withdraw<=balance) {
			System.out.println("Withdrawal done and Reamaining balance is:" +remainingbalance);
		}
		else {
			System.out.println("Insufficinet balance");
		}
		
	}

}

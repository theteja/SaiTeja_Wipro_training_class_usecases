package Day3;

class BankAccount{
	private double balance = 10000;
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		if(amount>0) {
			this.balance+=amount;
		}
	}
	public void withdraw(double amount) {
		if(amount>0 && amount<=this.balance) {
			this.balance-=amount;
		}
		else {
			System.out.println("Insuficient Balance");
		}
	}
	public double getBalance() {
		return balance;
	}
	
}
public class bank_account {

	public static void main(String[] args) {
		BankAccount bank = new BankAccount();
		bank.deposit(5000);
		bank.withdraw(500);
		System.out.println("Balance is : "+bank.getBalance());
	}

}

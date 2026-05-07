package Day5;

abstract class Banks{
	abstract double getInterestRate();
}
class SBI extends Banks{
	double getInterestRate(){
	return 6.5;
	}
}
class HDFC extends Banks{
	double getInterestRate(){
	return 7.0;
	}
}

public class bank {
	public static void main(String[] args) {
		Banks b1 = new SBI();
		Banks b2 = new HDFC();
		System.out.println("SBI Interest Rate: " + b1.getInterestRate());
		System.out.println("HDFC Interest Rate: " + b2.getInterestRate()); 
	}

}

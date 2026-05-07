package Day5;
interface Calculator {

    void divide(int a, int b);
}
class mycal implements Calculator{
	public void divide(int a, int b) {
		try {
		int result = a / b;
		System.out.println("Result: " + result);
	}
		catch(ArithmeticException e){
			System.out.println("Error: Cannot divide by zero");
		}
			
	}
		
}
public class cal {

	public static void main(String[] args) {
		mycal calc = new mycal();
		calc.divide(8, 2);
		calc.divide(8, 0);

	}

}

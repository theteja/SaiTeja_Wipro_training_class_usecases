package Day6;
import java.util.*;

class InvalidPinException extends Exception{
	public InvalidPinException(String message) {
		super(message);
	}
}
class ATM{
	private static final int correctPin = 1234;
	public void validatePin(int pin) throws InvalidPinException{
		if(pin!=correctPin) {
			throw new InvalidPinException("Invalid PIN entered!");
		}
	}
	public void startATM() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Insert card");
			System.out.println("Enter PIN: ");
			int pin = sc.nextInt();
			validatePin(pin);
			 System.out.println("PIN accepted. Access granted!");
		}
		catch (InvalidPinException e) {

            System.out.println("Exception: " + e.getMessage());
		}
		catch (Exception e) {

            System.out.println("Unexpected error occurred: " + e);
		}
		
		finally {
            System.out.println("Transaction logged. Thank you for using ATM.");

        }
		
	
}

}

public class atm_pin {
	public static void main(String[] args) {
		ATM atm = new ATM();
        atm.startATM();
	}
}

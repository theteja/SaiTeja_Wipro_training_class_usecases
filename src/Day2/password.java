package Day2;
import java.util.Scanner;
public class password {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int attempts= 1;
		String password = "1234";
		
		while(attempts<=3) {
			System.out.println("Enter password:");
			String correct=sc.nextLine();
			if(correct.equals(password)) {
				System.out.println("Login Succuessful");
				break;
			}
			else {
				System.out.println("Login usuccuessful");
				attempts++;
			}
		}
		

	}

}

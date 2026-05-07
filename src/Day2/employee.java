package Day2;

import java.util.Scanner;

public class employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);{
			System.out.println("Enter no of employees: ");
			int n = sc.nextInt();
			
			for(int i=1;i<=n;i++) {
				System.out.println("Enter Salary:");
				float salary=sc.nextFloat();
				double new_salary= salary+salary * 0.10;
				System.out.println("New Salary:"+new_salary);
			}
		}
	}

}

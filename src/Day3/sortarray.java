package Day3;
import java.util.*;
public class sortarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println("Ascending: ");
		for (int i : arr)
            System.out.print(i + " ");
		
		System.out.println("\nDescending: ");
		 for (int i = n - 1; i >= 0; i--) {
			 System.out.print(arr[i] + " ");		
		 }
		
		
	}

}

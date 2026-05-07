//11.Write a program to count the number of digits in a given number using a while loop.
package Day2;
import java.util.Scanner;
public class count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int count = 0;

        while (n != 0) {
            n /= 10;
            count++;
        }
        System.out.println(count);
    }

}

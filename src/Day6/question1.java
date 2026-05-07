package Day6;

public class question1 {
	static void change(int x) {

        x = 50;
        System.out.println("Inside method: " + x);
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println("Before: " + a);
        change(a);
        System.out.println("After: " + a);

    }

}

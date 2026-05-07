package Day6;
class Box {

    int length;

    Box(int length) {

        this.length = length;

    }

}
public class question2 {
	 static void modify(Box b) {

	        b.length = 100;
	    }
	 public static void main(String[] args) {
	        Box b = new Box(20);
	        System.out.println("Before: " + b.length);
	        modify(b);
	        System.out.println("After: " + b.length);

	    }
}

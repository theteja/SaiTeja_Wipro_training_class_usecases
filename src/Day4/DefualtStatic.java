package Day4;
interface Polygon {

    double getArea();

    default double getPerimeter(int... sides) {
        int sum = 0;
        for (int s : sides) {
            sum += s;
        }
        return sum;
    }

        static String shapeInfo() {
        return "Polygon Shape Interface";
    }
}

class Rectangle implements Polygon {
    int length, width;

    public Rectangle(int l, int w) {
        this.length = l;
        this.width = w;
    }

    public double getArea() {
        return length * width;
    }
}


class Triangle implements Polygon {
    int base, height;

    public Triangle(int b, int h) {
        this.base = b;
        this.height = h;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}


public class DefualtStatic {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(5, 4);
        System.out.println("Rectangle Area: " + r.getArea());
        System.out.println("Rectangle Perimeter: " + r.getPerimeter(5,4,5,4));

        Triangle t = new Triangle(6, 3);
        System.out.println("Triangle Area: " + t.getArea());
        System.out.println("Triangle Perimeter: " + t.getPerimeter(3,4,5));

       
        System.out.println(Polygon.shapeInfo());
    }
}
package day_04;
interface Polygon {
    double getArea();
    default double getPerimeter(int... sides) {
        int sum = 0;
        for (int side : sides) {
            sum += side;
        }
        return sum;
    }
    static String shapeInfo() {
        return "Polygons are closed shapes with multiple sides.";
    }
}
class Rectangle implements Polygon {
    int length, breadth;
    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }
    public double getArea() {
        return length * breadth;
    }
}
class Triangle implements Polygon {
    int base, height;
    Triangle(int b, int h) {
        base = b;
        height = h;
    }
    public double getArea() {
        return 0.5 * base * height;
    }
}
class Main2 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        Triangle t = new Triangle(6, 4);
        System.out.println("Rectangle Area: " + r.getArea());
        System.out.println("Triangle Area: " + t.getArea());
        System.out.println("Rectangle Perimeter: " + r.getPerimeter(10, 5, 10, 5));
        System.out.println("Triangle Perimeter: " + t.getPerimeter(3, 4, 5));
        System.out.println(Polygon.shapeInfo());
    }
}

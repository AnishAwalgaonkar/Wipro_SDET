package day_06;
class Box {
    int length;
}
public class TestBox {
    public static void modify(Box b) {
        b.length = 50;
    }
    public static void main(String[] args) {
        Box box = new Box();
        box.length = 10;
        System.out.println("Before the method call: " + box.length);
        modify(box);
        System.out.println("After the method call: " + box.length); // changed
    }
}

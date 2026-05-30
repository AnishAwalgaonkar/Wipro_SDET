package day_06;
class Pass_Value {
    public static void modify(int x) {
        x = x + 10;
        System.out.println("Inside method tha value changed to: " + x);
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Before: " + num);
        modify(num);
        System.out.println("After: " + num);
    }
}

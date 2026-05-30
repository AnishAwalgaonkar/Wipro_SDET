package day_05;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();
        calc.divide(10, 2);
        calc.divide(10, 0); 
    }
}

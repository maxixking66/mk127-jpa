package ir.maktabsharif127.jpa.util;

public class SimpleMath {

    public int add(int first, int second) {
        return first + second;
    }

    public double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException();
        }
        return first / second;
    }

}

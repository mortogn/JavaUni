
public class Overload {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultInt = add(1, 2);
        double resultDouble = add(1.2, 2.2);

        System.out.println("Int result: " + resultInt);
        System.out.println("Double result: " + resultDouble);
    }
}

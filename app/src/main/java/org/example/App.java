package org.example;

public class App {
    public static void main(String[] args) {
        int[] xs = {2, 3, 5, 10};
        int[] ns = {0, 1, 2, 3, 4, 5, 10};

        for (int x : xs) {
            for (int n : ns) {
                long a = Power.naivePower(x, n);
                long b = Power.unoptimizedDCPower(x, n);
                long c = Power.optimizedDCPower(x, n);
                boolean ok = (a == b) && (b == c);
                System.out.printf("x=%d, n=%d => %d (all match: %s)%n", x, n, c, ok);
            }
        }

        System.out.println("\nDisclaimer: results can overflow long for big n; but okay for our runtime comparison purposes");
    }
}

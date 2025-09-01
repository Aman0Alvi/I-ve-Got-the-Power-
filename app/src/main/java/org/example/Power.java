package org.example;

public final class Power {

    private Power() {}

    public static long naivePower(int x, int n) {
        if (x == 0) return (n == 0) ? 1L : 0L; 
        if (n == 0) return 1L;
        return x * naivePower(x, n - 1);
    }

    public static long unoptimizedDCPower(int x, int n) {
        if (x == 0) return (n == 0) ? 1L : 0L;
        if (n == 0) return 1L;
        if ((n & 1) == 0) { 
            return unoptimizedDCPower(x, n/2)*unoptimizedDCPower(x, n/2);
        } else { 
            return x*unoptimizedDCPower(x, n/2)*unoptimizedDCPower(x, n/2);
        }
    }
    
    public static long optimizedDCPower(int x, int n) {
        if (x == 0) return (n == 0) ? 1L : 0L;
        if (n == 0) return 1L;

        long half = optimizedDCPower(x, n/2);
        long sq = half*half;
        if ((n & 1) == 0) {
            return sq;
        } else {
            return x*sq;
        }
    }
}

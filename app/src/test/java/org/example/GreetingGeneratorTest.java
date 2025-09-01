package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowerTest {
  @Test
  void smallCasesAgreeAcrossImplementations() {
    int[] xs = {2, 3, 5};
    int[] ns = {0, 1, 2, 3, 4, 5, 10};
    for (int x : xs) {
      for (int n : ns) {
        long a = Power.naivePower(x, n);
        long b = Power.unoptimizedDCPower(x, n);
        long c = Power.optimizedDCPower(x, n);
        assertEquals(a, b, "naive vs unoptimizedDC mismatch at x=" + x + ", n=" + n);
        assertEquals(b, c, "unoptimizedDC vs optimizedDC mismatch at x=" + x + ", n=" + n);
      }
    }
  }
}

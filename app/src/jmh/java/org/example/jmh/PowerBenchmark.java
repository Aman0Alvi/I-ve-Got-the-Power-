package org.example.jmh;

import org.example.Power;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 10, time = 50, timeUnit = TimeUnit.MILLISECONDS)
public class PowerBenchmark {
    @Param({"2","3","5","7","11"})
    public int x;

    @Param({"1","2","4","8","16"})
    public int n;

    @Benchmark @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void naive(Blackhole bh) { bh.consume(Power.naivePower(x, n)); }

    @Benchmark @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void unoptimizedDC(Blackhole bh) { bh.consume(Power.unoptimizedDCPower(x, n)); }

    @Benchmark @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void optimizedDC(Blackhole bh) { bh.consume(Power.optimizedDCPower(x, n)); }
}

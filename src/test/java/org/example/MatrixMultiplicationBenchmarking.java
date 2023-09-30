package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(2)
public class MatrixMultiplicationBenchmarking {
    @Param({"2", "4", "8", "16", "32", "128", "256", "512", "1024", "2048"})
    public int n;

    @State(Scope.Thread)
    public static class Operands{
        private final int n = 2048;
        private final double[][] a = new double[n][n];
        private final double[][] b = new double[n][n];

        @Setup
        public void setup() {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = random.nextDouble();
                    b[i][j] = random.nextDouble();
                }
            }
        }

    }

    @Benchmark
    public void multiplication(Operands operands){
        new MatrixMultiplication().execute(operands.a, operands.b, n);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}











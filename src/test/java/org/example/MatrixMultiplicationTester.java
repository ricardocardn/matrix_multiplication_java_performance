package org.example;

import org.example.MatrixMultiplication;

import java.util.ArrayList;
import java.util.Random;

public class MatrixMultiplicationTester {
    static int n = 2048;
    static double[][] a = new double[n][n];
    static double[][] b = new double[n][n];
    static double[][] c = new double[n][n];

    public static void main(String[] args) {
        fillMatrices();

        ArrayList<Long> times = new ArrayList<Long>();
        for (int i=1; i<=n; i=i*2) {
            long start = System.currentTimeMillis();
            new MatrixMultiplication().execute(a, b, i);
            long stop = System.currentTimeMillis();

            times.add(stop-start);
        }

        System.out.println(times);
    }

    private static void fillMatrices() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextDouble();
                b[i][j] = random.nextDouble();
                c[i][j] = 0;
            }
        }
    }
}
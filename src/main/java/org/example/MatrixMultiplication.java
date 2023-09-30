package org.example;

import java.util.Random;

public class MatrixMultiplication {
    public double[][] execute(double[][] a, double[][] b, int n) {
        assert a.length != b.length;

        double[][] c = new double[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }

        return c;
    }
}

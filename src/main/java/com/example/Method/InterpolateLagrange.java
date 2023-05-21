package com.example.Method;

import java.util.Arrays;

public class InterpolateLagrange {
    public static double func(double[] x, double[] y, double target){
        int n = x.length;
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term *= (target - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }
}
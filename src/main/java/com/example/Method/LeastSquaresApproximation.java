package com.example.Method;

import java.util.Arrays;

public class LeastSquaresApproximation {
    public static double linearApproximation(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXX = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
        }

        double denominator = n * sumXX - sumX * sumX;
        double numerator = n * sumXY - sumX * sumY;

        double slope = numerator / denominator;
        double intercept = (sumY - slope * sumX) / n;

        double b = slope * x[n - 1] + intercept; // возвращаем аппроксимированное значение
        double a = (sumXY - (b * sumX)) / sumXX;
        System.out.println(a);
        System.out.println(b);

        double[] P1x = new double[n];
        double res  = 0;
        for(int i = 0; i < n; i++) {
            P1x[i] = linearSolve(x[i], a, b);
            res += Math.pow(y[i] - P1x[i], 2);
        }

        System.out.println(Arrays.toString(P1x));
        return res;
    }

    private static double linearSolve(double x, double a, double b) {
        return a * x + b;
    }

    public static double quadraticApproximation(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXX = 0;
        double sumXXX = 0;
        double sumXXXX = 0;
        double sumXYY = 0;

        for (int i = 0; i < n; i++) {
            double xi = x[i];
            double xiSquare = xi * xi;
            double yi = y[i];
            double xiCube = xi * xi * xi;
            double xiQuartic = xi * xi * xi * xi;

            sumX += xi;
            sumY += yi;
            sumXY += xi * yi;
            sumXX += xiSquare;
            sumXXX += xiCube;
            sumXXXX += xiQuartic;
            sumXYY += xiSquare * yi;
        }

        double[][] coefficients = {
                { sumXXXX, sumXXX, sumXX },
                { sumXXX, sumXX, sumX },
                { sumXX, sumX, n }
        };

        double[] constants = { sumXYY, sumXY, sumY };

        double[] result = gaussElimination(coefficients, constants);

        double a = result[0];
        double b = result[1];
        double c = result[2];
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        double[] P2x = new double[n];
        double res  = 0;
        for(int i = 0; i < n; i++) {
            P2x[i] = quadraticSolve(x[i], a, b, c);
            res += Math.pow(y[i] - P2x[i], 2);
        }

        System.out.println(Arrays.toString(P2x));
        return res;
    }

    private static double[] gaussElimination(double[][] coefficients, double[] constants) {
        int n = constants.length;

        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = coefficients[k][i] / coefficients[i][i];
                constants[k] -= factor * constants[i];
                for (int j = i; j < n; j++) {
                    coefficients[k][j] -= factor * coefficients[i][j];
                }
            }
        }
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += coefficients[i][j] * solution[j];
            }
            solution[i] = (constants[i] - sum) / coefficients[i][i];
        }

        return solution;
    }

    private static double quadraticSolve(double x, double a, double b, double c) {
        return a * x * x + b * x + c;
    }

}

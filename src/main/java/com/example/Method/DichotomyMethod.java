package com.example.Method;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

public class DichotomyMethod {
    static double[] vec;
    static ArrayList<String> answer = new ArrayList<>();

    public DichotomyMethod(double[] vector) {
        vec = vector;
        findRoot();
    }

    public void findRoot() {
        double a = -5; // початкова точка відрізку
        double b = 7; // кінцева точка відрізку
        double step = 0.1; // крок
        double epsilon = 0.0001; // точність розв'язку

        answer.add("Метод Дихотомії");

        for (double x = a; x <= b; x += step) {
            if (f(x) * f(x + step) < 0) {
                double root = solve(x, x + step, epsilon);
                System.out.printf("Знайдено корінь на відрізку [%.4f, %.4f]: %.4f\n", x, x + step, root);

                answer.add(String.valueOf(new Formatter().format("Знайдено корінь на відрізку [%.4f, %.4f]: %.4f\n", x, x + step, root)));
            }
        }
    }

    // функція, яка повертає значення f(x) для заданого x
    private static double f(double x) {
        return vec[0] * Math.pow(x, 3) + vec[1] * Math.pow(x, 2) + vec[2] * x + vec[3];
    }

    // метод дихотомії для пошуку кореня рівняння на заданому відрізку з заданою точністю
    private static double solve(double a, double b, double epsilon) {
        double c;
        while (b - a > epsilon) {
            c = (a + b) / 2;
            if (f(c) == 0) {
                return c;
            } else if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return (a + b) / 2;
    }

    public static ArrayList<String> getAnswer() {
        return answer;
    }

    public void clearAnswer(){
        answer.clear();
    }
}

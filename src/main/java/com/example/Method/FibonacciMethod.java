package com.example.Method;

import java.util.ArrayList;
import java.util.Formatter;

import static java.lang.Math.abs;

public class FibonacciMethod {

    static double[] vec;
    static ArrayList<String> answer = new ArrayList<>();
    public FibonacciMethod(double[] vector) {
        vec = vector;
        solveFibMethod();
    }
    public static void solveFibMethod() {
        double a = -5; // початкова точка відрізку
        double b = 7; // кінцева точка відрізку
        double step = 0.1; // крок
        double epsilon = 0.0001; // точність розв'язку
        answer.add("Метод фібочначі");

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

    // метод Фібоначчі для пошуку кореня рівняння на заданому відрізку з заданою точністю
    private static double solve(double a, double b, double epsilon) {
        int n = (int) Math.ceil((b - a) / epsilon); // кількість ітерацій
        int fibNMinusOne = 1;
        int fibNMinusTwo = 1;
        int fibN = 2;
        boolean flag = false;
        double c = (a+b)/2;

        if(f(a) * f(c) < 0) {
            b = c;
            flag = false;
        } else {
            flag = true;
            a = c;
        }

        double toch = abs(a - b);

        while(toch > epsilon) {

            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
            fibN = fibNMinusOne + fibNMinusTwo;

            toch = (toch*fibNMinusTwo)/fibN;
            if(flag) {
                c= b - toch;
            }
            else {
                c = toch + a;

            }
            if(f(a) * f(c) < 0) {
                b = c;
                flag = false;
            } else {
                a = c;
                flag = true;
            }

        }
        return c;
    }

    public static ArrayList<String> getAnswer() {
        return answer;
    }

    public void clearAnswer(){
        answer.clear();
    }
}

package com.example.Method;
public class Main {
    public static void main(String[] args) {
        int size = 5;
//        double[] x_values = {-4,-3,-2,-1,0};
//        double[] y_values = {-2,0,1,-1,-3};
        double[] x_values = {2,5,6,4,3};
        double[] y_values = {3,4,5,6,7};


        for (int i = 0; i < size; i++)
        {
            double y = InterpolateLagrange.func(x_values, y_values, x_values[i]);
            System.out.println("Ln(x) = [" + x_values[i] + ", " + y + "]");

        }


        System.out.println();
        System.out.println(LeastSquaresApproximation.quadraticApproximation(x_values,y_values));

    }

}

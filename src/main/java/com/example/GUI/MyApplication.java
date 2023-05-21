package com.example.GUI;


import com.example.Method.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;


public class MyApplication extends Application {
    Label result;

    @Override
    public void start(Stage stage) {
        GridPane formForVectorX = EnterFormForVector.enterFrom();

        Button solveButton1 = new Button("Розрахувати");
        solveButton1.setOnAction(event -> solve());
        solveButton1.setStyle("-fx-background-color: #BDD8ED;");

        result = BottomPanel.createBottomPanel();

        VBox box = new VBox(formForVectorX, solveButton1, result);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: #F3F8FB;");

        Scene scene = new Scene(box, 600, 600);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }



    private void solve() {
        result.setText("");
        TextField[][] textFieldsOurVector = EnterFormForVector.getAllFieldsForVector();
        double[] vectorX = new double[textFieldsOurVector.length];
        double[] vectorY = new double[textFieldsOurVector.length];


        for (int j = 0; j < textFieldsOurVector.length; j++) {
            vectorX[j] = Float.parseFloat(String.valueOf(textFieldsOurVector[j][0].getText()));
            vectorY[j] = Float.parseFloat(String.valueOf(textFieldsOurVector[j][1].getText()));
        }

        System.out.println(Arrays.toString(vectorX));
        System.out.println(Arrays.toString(vectorY));
        double fx = 0;
        StringBuilder res1 = new StringBuilder("Інтерполяція:\n\n");
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 5; i++) {
            fx = InterpolateLagrange.func(vectorX, vectorY, vectorX[i]);
            res1.append(new Formatter().format("Ln(x): [%.4f, %.4f]\n", vectorX[i], fx));
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Час виконання: " + totalTime + " мс");

        res1.append("\nАпроксімація:\n\n");
        startTime = System.currentTimeMillis();
        res1.append("Поліном першого ступеня: ");
        res1.append(LeastSquaresApproximation.linearApproximation(vectorX, vectorY)).append("\n");
        res1.append("Поліном другого ступеня: ");
        res1.append(LeastSquaresApproximation.quadraticApproximation(vectorX, vectorY)).append("\n");
        result.setText(String.valueOf(res1));

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Час виконання: " + totalTime + " мс");

        result.setVisible(true);
    }

    public static void main(String[] args) {
        launch();
    }
}
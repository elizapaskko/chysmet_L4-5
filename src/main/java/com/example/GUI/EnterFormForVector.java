package com.example.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class EnterFormForVector {

    public static TextField[][] vectorFields;

    public static GridPane enterFrom() {
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        form.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(7), new BorderWidths(2))));
        form.setStyle("-fx-background-color: #C4DCEE;");
        form.setPrefSize(150, 100);
        form.setMaxSize(400, 100);
        form.setPadding(new Insets(10));
        form.setVgap(10);
        form.setHgap(10);

        vectorFields = new TextField[5][2];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 2; j++) {
                vectorFields[i][j] = MyTextField.textField();
                form.add(vectorFields[i][j], i, j);

            }
        }

        return form;
    }

    public static TextField[][] getAllFieldsForVector() {
        return vectorFields;
    }
}

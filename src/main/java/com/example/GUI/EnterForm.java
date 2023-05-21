package com.example.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class EnterForm {
    public static TextField[][] allFields;
    public static GridPane enterFrom() {
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setStyle("-fx-background-color: #C4DCEE;");
        form.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        form.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(7), new BorderWidths(2))));
        form.setPrefSize(300, 150);
        form.setMaxSize(300,300);
        form.setPadding(new Insets(20));
        form.setVgap(10);
        form.setHgap(10);
        allFields = new TextField[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                allFields[i][j] = MyTextField.textField();
                form.add(allFields[i][j],j,i);
            }
        }

        return form;
    }

    public static TextField[][] getAllFields() {
        return allFields;
    }
}

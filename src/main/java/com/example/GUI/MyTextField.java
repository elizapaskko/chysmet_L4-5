package com.example.GUI;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MyTextField {

    public static TextField textField() {
        TextField textField = new TextField();
        textField.setPrefSize(60,30);
        textField.setMaxSize(60,30);
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2),new BorderWidths(2,2,2,2))));

        return textField;
    }
}

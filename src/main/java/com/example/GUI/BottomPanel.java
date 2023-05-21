package com.example.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BottomPanel {
    public static Label createBottomPanel() {

        Label res = new Label();
        res.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        res.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        res.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(7), new BorderWidths(2))));
        res.setStyle("-fx-background-color: #EBF3F9;");
        res.setMaxSize(500,400);
        res.setPrefSize(500,400);
        res.setAlignment(Pos.CENTER);

        return res;
    }
}

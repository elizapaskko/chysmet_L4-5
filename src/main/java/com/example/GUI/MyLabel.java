package com.example.GUI;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class MyLabel {

    public static Label getLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 20));

        return label;
    }
}

package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NumberConversionApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // vytvorenie GUI
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);

        Label decimalLabel = new Label("Desiatkova sústava:");
        TextField decimalField = new TextField();
        Label binaryLabel = new Label("Dvojková sústava:");
        TextField binaryField = new TextField();
        Button decimalToBinaryButton = new Button("Prevod do binárnej sústavy");
        Button binaryToDecimalButton = new Button("Prevod do desiatkovej sústavy");

        root.add(decimalLabel, 0, 0);
        root.add(decimalField, 1, 0);
        root.add(binaryLabel, 0, 1);
        root.add(binaryField, 1, 1);
        root.add(decimalToBinaryButton, 0, 2);
        root.add(binaryToDecimalButton, 1, 2);

        // napojenie funkcionalít na tlačidlá
        decimalToBinaryButton.setOnAction(event -> {
            String decimalString = decimalField.getText();
            try {
                int decimal = Integer.parseInt(decimalString);
                String binary = Integer.toBinaryString(decimal);
                binaryField.setText(binary);
            } catch (NumberFormatException e) {
                binaryField.setText("Neplatný vstup");
            }
        });

        binaryToDecimalButton.setOnAction(event -> {
            String binaryString = binaryField.getText();
            try {
                int decimal = Integer.parseInt(binaryString, 2);
                decimalField.setText(String.valueOf(decimal));
            } catch (NumberFormatException e) {
                decimalField.setText("Neplatný vstup");
            }
        });

        Scene scene = new Scene(root, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prevod sústav");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

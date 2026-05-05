package com.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;



import java.io.IOException;

public class CalculatorFX extends Application {

    double firstNumber = 0;
    String operator = "";

    // DIGIT STYLE
    void styleButton(Button btn) {
        btn.setStyle(
            "-fx-background-color: #00ff99;" +
            "-fx-text-fill: black;" +
            "-fx-font-size: 24px;" +
            "-fx-min-width: 60px;" +
            "-fx-min-height: 60px;" +
            "-fx-background-radius: 15px;" +
            "-fx-border-radius: 15px;" +
            "-fx-font-weight: bold;"
        );
    }

    // OPERATOR STYLE
    void styleOperator(Button btn) {
        btn.setStyle(
            "-fx-background-color: #ff9500;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 24px;" +
            "-fx-min-width: 60px;" +
            "-fx-min-height: 60px;" +
            "-fx-background-radius: 15px;" +
            "-fx-border-radius: 15px;" +
            "-fx-font-weight: bold;"
        );
    }

    @Override
    public void start(Stage stage) throws IOException {

        TextField display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefWidth(250);
        display.setPrefHeight(60);
        display.setStyle(
            "-fx-text-fill: white;" +
            "-fx-background-color: brown;" +
            "-fx-font-size: 28px;"
        );

        GridPane grid = new GridPane();

        // BUTTONS
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");

        Button btn10 = new Button("C");
        Button btn11 = new Button("+");
        Button btn12 = new Button("=");
        Button btn13 = new Button("-");
        Button btn14 = new Button("/");
        Button btn15 = new Button("%");

        // APPLY STYLE
        styleButton(btn0);
        styleButton(btn1);
        styleButton(btn2);
        styleButton(btn3);
        styleButton(btn4);
        styleButton(btn5);
        styleButton(btn6);
        styleButton(btn7);
        styleButton(btn8);
        styleButton(btn9);

        styleButton(btn10);
        styleOperator(btn11);
        styleOperator(btn12);
        styleOperator(btn13);
        styleOperator(btn14);
        styleOperator(btn15);

        // GRID
        grid.add(btn0, 0, 0);
        grid.add(btn1, 1, 0);
        grid.add(btn2, 2, 0);
        grid.add(btn3, 3, 0);

        grid.add(btn4, 0, 1);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 2, 1);
        grid.add(btn7, 3, 1);

        grid.add(btn8, 0, 2);
        grid.add(btn9, 1, 2);
        grid.add(btn10, 2, 2);
        grid.add(btn11, 3, 2);

        grid.add(btn12, 1, 3);
        grid.add(btn13, 2, 3);
        grid.add(btn14, 3, 3);
        grid.add(btn15, 0, 3);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(12);
        grid.setVgap(16);

        // DIGITS
        btn0.setOnAction(e -> display.setText(display.getText() + "0"));
        btn1.setOnAction(e -> display.setText(display.getText() + "1"));
        btn2.setOnAction(e -> display.setText(display.getText() + "2"));
        btn3.setOnAction(e -> display.setText(display.getText() + "3"));
        btn4.setOnAction(e -> display.setText(display.getText() + "4"));
        btn5.setOnAction(e -> display.setText(display.getText() + "5"));
        btn6.setOnAction(e -> display.setText(display.getText() + "6"));
        btn7.setOnAction(e -> display.setText(display.getText() + "7"));
        btn8.setOnAction(e -> display.setText(display.getText() + "8"));
        btn9.setOnAction(e -> display.setText(display.getText() + "9"));

        // CLEAR
        btn10.setOnAction(e -> {
            display.clear();
            firstNumber = 0;
            operator = "";
        });

        // +
        btn11.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "+";
                display.clear();
            }
        });

        // =
        btn12.setOnAction(e -> {
            if (display.getText().isEmpty() || operator.isEmpty()) return;

            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operator.equals("/")) {
                result = firstNumber / secondNumber;
            } else if (operator.equals("%")) {
                result = firstNumber % secondNumber;
            }

            display.setText(String.valueOf(result));
        });

        // -
        btn13.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "-";
                display.clear();
            }
        });

        // /
        btn14.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "/";
                display.clear();
            }
        }
        );

        // %
        btn15.setOnAction(e -> {
            if (!display.getText().isEmpty()) {
                firstNumber = Double.parseDouble(display.getText());
                operator = "%";
                
                display.clear();
            }
        });

        VBox root = new VBox(20, display, grid);
        root.setStyle("-fx-background-color: #1e1e1e;");
        
        root.setPadding(new Insets(25));

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        
       
        stage.setTitle("Taukiro 991 CW");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
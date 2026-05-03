package com.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.io.IOException;


public class CalculatorFX extends Application {

    double firstNumber = 0;
    String operator = "";

    @Override
    public void start(Stage stage) throws IOException {
       
        TextField display = new TextField();
        display.setEditable(false);
        //display.setPrefWidth(200);
        //display.setPrefHeight(50);
        //display.setAlignment(Pos.CENTER);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefWidth(250);
        display.setStyle("-fx-font-size: 24px;");

        GridPane grid = new GridPane();
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
        Button btn13= new Button("-");
        Button btn14= new Button("/");
        Button btn15 = new Button("%");

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
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(12);
        grid.setVgap(16);
        
        

        btn1.setOnAction(e->{
            display.setText(display.getText() + "1");
        });

        btn2.setOnAction(e->{
            display.setText(display.getText() + "2");
        });

        btn3.setOnAction(e->{
            display.setText(display.getText() + "3");
        });

        btn4.setOnAction(e->{
            display.clear();
        });

        btn5.setOnAction(e->{
            firstNumber = Double.parseDouble(display.getText());
            operator = "+";
            display.clear();
        });

        btn6.setOnAction(e->{
            Double secondNumber  = Double.parseDouble(display.getText());

            Double result = 0.0;
            if(operator == "+") {
                result = firstNumber+secondNumber;
            } 
            else if(operator == "-") {
                result = firstNumber-secondNumber;
            }
            else if(operator == "/") {
                result = firstNumber/secondNumber;
            }
            else if(operator == "%") {
                result = firstNumber%secondNumber;
            }
            

            display.setText(String.valueOf(result));
        });

        btn7.setOnAction(e->{
            firstNumber = Double.parseDouble(display.getText());
            operator = "-";
            display.clear();
        });

        btn8.setOnAction(e->{
            firstNumber = Double.parseDouble(display.getText());
            operator = "/";
            display.clear();
        });


        btn9.setOnAction(e->{
            firstNumber = Double.parseDouble(display.getText());
            operator = "%";
            display.clear();
        });


        VBox root = new VBox(20, display, grid);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
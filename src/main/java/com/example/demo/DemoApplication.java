package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class DemoApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Label l1 = new Label("Поиск смысла");
        l1.setLayoutX(20);

        TextField textField = new TextField();
        Text text1 = new Text();
        textField.setLayoutX(20);
        textField.setLayoutY(120);
        text1.setX(28);
        text1.setY(160);

        CheckBox checkBox1 = new CheckBox("да");
        CheckBox checkBox2 = new CheckBox("нет");
        Text text = new Text();

        checkBox1.setLayoutX(20);
        checkBox1.setLayoutY(40);
        checkBox2.setLayoutX(20);
        checkBox2.setLayoutY(60);
        text.setX(20);
        text.setY(100);

        pane.getChildren().addAll(checkBox1,checkBox2,text,textField,text1,l1);

        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                text1.setText(textField.getText());
            }
        });

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (checkBox1.isSelected() && !checkBox2.isSelected())
                    text.setText("выбрано да");
                else if (checkBox1.isSelected() && checkBox2.isSelected())
                    text.setText("выбрано да и нет");
                else if (!checkBox1.isSelected() && checkBox2.isSelected())
                    text.setText("выбрано нет");
                else text.setText("ничего не выбрано");
            }
        };

        checkBox1.setOnAction(handler);
        checkBox2.setOnAction(handler);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Добро пожаловать!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
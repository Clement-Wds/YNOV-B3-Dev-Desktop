package com.example.devdeskstopb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Rectangle rectangle = new Rectangle();
        rectangle.setX(20);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        rectangle.setFill(Color.BLUE);

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(25);
        circle.setFill(Color.WHITE);

        Group root = new Group();
        root.getChildren().add(rectangle);
        root.getChildren().add(circle);

        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
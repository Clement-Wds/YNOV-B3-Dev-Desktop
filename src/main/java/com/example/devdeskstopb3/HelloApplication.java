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

    //Width and height of stage
    static int stageWidth = 1080;
    static int stageHeight = 720;

    //Width, height, position x y, color
    static int recWidth = 200;
    static int recHeight = 50;

    static int rec1PosX = 50;
    static int rec1PosY = 50;
    static int rec2PosX = 750;
    static int rec2PosY = 50;

    static int ballSize = 50;
    static int ballPosX = 400;
    static int ballPosY = 400;

    static String rec1Color = "BLUE";
    static String rec2Color = "GREEN";
    static String ballColor = "RED";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Circle ball = new Circle(ballPosX, ballPosY, ballSize);

        Rectangle r1 = new Rectangle(rec1PosX, rec1PosY, recHeight, recWidth);
        Rectangle r2 = new Rectangle(rec2PosX, rec2PosY, recHeight, recWidth);

        Group root = new Group(ball, r1, r2);

        Scene scene = new Scene(root, stageWidth, stageHeight, Color.WHITE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
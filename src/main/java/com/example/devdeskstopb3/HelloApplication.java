package com.example.devdeskstopb3;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    static int circleSize = 50;

    static int stageWidth = 1280;
    static int stageHeight = 720;

    static int recHeight = 25;
    static int recWidth = 150;

    static int rec1posX = 1;
    static int rec1posY = 50;

    static int rec2posX = 1254;
    static int rec2posY = 325;

    static int ballSize = 25;
    static int ballPosX = 640;
    static int ballPosY = 325;

    static int directionBallX = 1;
    static int directionBallY = 1;

    Timeline tl;
    Rectangle ball;
    Rectangle r1;
    Rectangle r2;

    TextArea t1;
    Text score1, score2;

    int scoreInt1 = 0, scoreInt2 = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        ball = new Rectangle(ballPosX, ballPosY, ballSize, ballSize);
        r1 = new Rectangle(rec1posX, rec1posY, recHeight, recWidth);
        r2 = new Rectangle(rec2posX, rec2posY, recHeight, recWidth);

        t1 = new TextArea("text?");
        score1 = new Text(100, 100, String.valueOf(scoreInt1));
        score1.setStyle("-fx-font-size: 50");

        score2 = new Text(500, 100, String.valueOf(scoreInt2));
        score2.setStyle("-fx-font-size: 50");

        Group group = new Group(ball, r1, r2, score1, score2);

        tl = new Timeline(new KeyFrame(Duration.millis(100), e -> run()));
        tl.setCycleCount(Timeline.INDEFINITE);

        Scene scene = new Scene(group, stageWidth, stageHeight, Color.WHITE);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        //TODO: Move R1 by mouse event

        stage.show();
        tl.play();
    }

    public void run() {

        if((ball.getX() + ball.getWidth() + 1 >= r2.getX()) && (ball.getY()>=r2.getY() && ball.getY()<=(r2.getY()+r2.getHeight()))
                || (ball.getX()-1 <= r1.getX() + r1.getWidth()) && (ball.getY()>=r1.getY() && ball.getY()<=(r1.getY()+r1.getHeight()))) {
            directionBallX = -directionBallX;
            System.out.println("Bim Bam Boum");
        }

        if(ball.getY() <= 0 || ball.getY() + ball.getWidth() >= stageHeight){
            directionBallY = -directionBallY;
        }

        if(ball.getX() <= 0 || ball.getY() + ball.getWidth() >= stageHeight){
            if(ball.getX()<=0){
                scoreInt2 = ++scoreInt2;
                score2.setText(String.valueOf(scoreInt2));
            }
        }

        ball.setX(ball.getX() + ball.getWidth() * directionBallX);
        ball.setY(ball.getY() + ball.getHeight() * directionBallY);
        r2.setY(ball.getY());
        r1.setY(ball.getY());

        tl.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(5000),
                        new KeyValue(ball.translateXProperty(), ball.getX() + ball.getWidth()),
                        new KeyValue(ball.translateYProperty(), ball.getY() + ball.getWidth()),
                        new KeyValue(r2.translateYProperty(), ball.getY())

                )

        );

        tl.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
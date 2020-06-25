package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class Drawing extends Application {
    GraphicsContext gc;
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
    int colorIdx = 0;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bezpośrednie rysowanie na płótnie");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode,450,450);
        primaryStage.setScene(myScene);
        Canvas myCanvas = new Canvas(400,450);
        gc = myCanvas.getGraphicsContext2D();
        Button btnChangeColor = new Button("Zmień kolor");
        btnChangeColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.setStroke(colors[colorIdx]);
                gc.setFill(colors[colorIdx]);

                gc.strokeLine(0,0,200,200);
                gc.fillText("Tekst wyświetlany na płótnie.",60,50);
                gc.fillRect(100,320,300,40);

                colorIdx++;
                if (colorIdx == colors.length) colorIdx= 0;

            }
        });
        gc.strokeLine(0,0,200,200);
        gc.strokeOval(100,100,300,200);
        gc.strokeRect(0,200,50,200);
        gc.fillOval(0,0,20,20);
        gc.fillRect(100,320,300,40);

        gc.setFont(new Font(20));
        gc.fillText("Tekst wyświetlany na płótnie.", 60,50);
        rootNode.getChildren().addAll(myCanvas,btnChangeColor);
        primaryStage.show();
    }
}

package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sun.font.Decoration;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.Scanner;

public class Main extends Application {
    Button buttonAlp;
    Button buttonBet;
    Label response;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("Hello World");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 300, 250);
      buttonAlp = new Button("ALFA");
      buttonBet = new Button("BETA");
//      StackPane layout = new StackPane();
//      layout.getChildren().add(button);
        response = new Label("Kliknij przycisk!");
        buttonAlp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Kliknięto przycisk Alfa.");
            }
        });
        buttonBet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Kliknięto przycisk Beta.");
            }
        });
        rootNode.getChildren().addAll(buttonAlp, buttonBet, (Node) response);


      primaryStage.setScene(scene);
      primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

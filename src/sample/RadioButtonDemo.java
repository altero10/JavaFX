package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Prezentacja przycisków opcji");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode,290,120);
        myStage.setScene(myScene);
        response = new Label("");

        RadioButton rbTrain = new RadioButton("Pociąg");
        RadioButton rbCar = new RadioButton("Samochód");
        RadioButton rbPlane = new RadioButton("Samolot");

        ToggleGroup tg = new ToggleGroup();
        rbTrain.setToggleGroup(tg);
        rbCar.setToggleGroup(tg);
        rbPlane.setToggleGroup(tg);

        rbTrain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Wybranym środkiem transportu jest pociąg.");
            }
        });
        rbCar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Wybranym środkiem transportu jest samochód.");
            }
        });
        rbPlane.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Wybranym środkiem transportu jest samolot.");
            }
        });

        rbTrain.fire();

        rootNode.getChildren().addAll(rbTrain, rbCar, rbPlane, response);
        myStage.show();

    }
}

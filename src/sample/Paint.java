package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Paint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Wyświetlanie obrazu");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode,700,500);
        myStage.setScene(myScene);


        Image facture = new Image("file:///C:/Users/Pawel/.IntelliJIdea2019.3/config/FirstPaint.png");
        ImageView factureOne = new ImageView(facture);
        Label factureLabel = new Label("PierwszyObraz", factureOne);
        rootNode.getChildren().add(factureLabel);
        myStage.show();

    }
}

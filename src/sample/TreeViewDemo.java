package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TreeView;
import java.awt.*;

public class TreeViewDemo extends Application {
   Label response;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Prezentacja kontrolki TreeView.");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode,340,650);
        myStage.setScene(myScene);

        response = new Label("Jeszcze nic nie wybrano.");


        TreeItem<String> tiRoot = new TreeItem<String>("Pożywienie");

        TreeItem<String> tiFruit = new TreeItem<String>("Owoce");

        TreeItem<String> tiApples = new TreeItem<String>("Jabłka");

        tiApples.getChildren().add(new TreeItem<String>("Koksa"));
        tiApples.getChildren().add(new TreeItem<String>("Jonatan"));
        tiApples.getChildren().add(new TreeItem<String>("Antonówka"));

        tiFruit.getChildren().add(tiApples);
        tiFruit.getChildren().add(new TreeItem<String>("Gruszki"));
        tiFruit.getChildren().add(new TreeItem<String>("Pomarańcze"));

        tiRoot.getChildren().add(tiFruit);

        TreeItem<String> tiVegetables = new TreeItem<String>("Warzywa");
        tiVegetables.getChildren().add(new TreeItem<String >("Kukurydza"));
        tiVegetables.getChildren().add(new TreeItem<String>("Groszek"));
        tiVegetables.getChildren().add(new TreeItem<String>("Brokuły"));
        tiVegetables.getChildren().add(new TreeItem<String>("Fasola"));
        tiRoot.getChildren().add(tiVegetables);

        TreeItem<String> tiNuts = new TreeItem<String>("Orzechy");
        tiNuts.getChildren().add(new TreeItem<String>("Laskowe"));
        tiNuts.getChildren().add(new TreeItem<String>("Ziemne"));
        tiNuts.getChildren().add(new TreeItem<String>("Włoskie"));
        tiRoot.getChildren().add(tiNuts);


        TreeView<String> tvFood = new TreeView<String>(tiRoot);

        MultipleSelectionModel <TreeItem<String>> tvSelModel = tvFood.getSelectionModel();

        tvSelModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> changed , TreeItem<String> oldVal, TreeItem<String> newVal) {

                if (newVal != null){
                    String path = newVal.getValue();
                    TreeItem<String> tmp = newVal.getParent();
                    while (tmp != null) {
                        path = tmp.getValue() + " -> " + path;
                        tmp = tmp.getParent();
                    }
                    response.setText("Wybrano element: " + newVal.getValue() + "\nPełna ścieżka: " + path);
                }

            }
        });
        rootNode.getChildren().addAll(tvFood, response);
        myStage.show();






    }


}

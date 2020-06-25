package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.security.Key;

public class MenuDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Prezentacja menu");

        BorderPane rootNode = new BorderPane();

        Scene myScene = new Scene(rootNode, 300, 300);

        myStage.setScene(myScene);

        response = new Label("Prezentacja menu.");

        MenuBar mb = new MenuBar();

        Menu fileMenu = new Menu("_Plik");
        MenuItem open = new MenuItem("Otwórz");
        MenuItem close = new MenuItem("Zamknij");
        MenuItem save = new MenuItem("Zapisz");
        MenuItem exit = new MenuItem("Zakończ");
        fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);

        mb.getMenus().add(fileMenu);

        Menu optionsMenu = new Menu("Opcje");

        Menu colorsMenu = new Menu("Kolory");
        MenuItem red = new MenuItem("Czerwony");
        MenuItem green = new MenuItem("Zielony");
        MenuItem blue = new MenuItem("Niebieski");
        colorsMenu.getItems().addAll(red, green, blue);
        optionsMenu.getItems().add(colorsMenu);

        Menu priorityMenu = new Menu("Priorytet");
        MenuItem high = new Menu("Wysoki");
        MenuItem low = new Menu("Niski");
        priorityMenu.getItems().addAll(high, low);
        optionsMenu.getItems().add(priorityMenu);

        optionsMenu.getItems().add(new SeparatorMenuItem());

        MenuItem reset = new MenuItem("Resetuj");
        optionsMenu.getItems().add(reset);

        mb.getMenus().add(optionsMenu);

        Menu helpMenu = new Menu("Pomoc");
        MenuItem about = new MenuItem("O programie");
        optionsMenu.getItems().add(about);

        mb.getMenus().add(helpMenu);

        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+M"));
        save.setAccelerator(KeyCombination.keyCombination("shortcut+Z"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+K"));




        EventHandler<ActionEvent> MEhandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = ((MenuItem) event.getTarget()).getText();
                if (name.equals("Zakończ")) Platform.exit();

                response.setText("Wybrano " + name);
            }
        };
        open.setOnAction(MEhandler);
        close.setOnAction(MEhandler);
        save.setOnAction(MEhandler);
        exit.setOnAction(MEhandler);
        red.setOnAction(MEhandler);
        green.setOnAction(MEhandler);
        blue.setOnAction(MEhandler);
        high.setOnAction(MEhandler);
        low.setOnAction(MEhandler);
        reset.setOnAction(MEhandler);
        about.setOnAction(MEhandler);



        rootNode.setTop(mb);
        rootNode.setCenter(response);

        myStage.show();


    }
}

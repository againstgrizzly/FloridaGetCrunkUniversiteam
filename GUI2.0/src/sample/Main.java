package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Scene mainScene;
    Button startButton, exitButton;
    Text componentsTitle, inspectorTitle;
    Button batteryButton, ledButton, resistorButton, switchButton;
    Label startLabel, objectProperties;
    TextField properties0, properties1, properties2, properties3;
    MenuBar menuBar;




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        mainScene = new Scene(new Group(), 1040, 570, Color.GRAY);
        window.setTitle("Circuit Simulator");


        BorderPane borderGUI = new BorderPane();
        borderGUI.setLeft(componentsGUI());
        borderGUI.setRight(inspectorGUI());
        Scene buildScene = new Scene(borderGUI, 1040, 570);

        VBox mainBox = new VBox();
        mainBox.setLayoutX(400);
        mainBox.setLayoutY(200);

        startLabel = new Label("Welcome to Circuit Simulator");
        startLabel.setFont(Font.font("Calibri", FontWeight.BLACK, 20));

        startButton = new Button("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               window.setScene(buildScene);
            }
        });

        exitButton = new Button("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });

        mainBox.getChildren().addAll(startLabel, startButton, exitButton);
        mainBox.setSpacing(10);
        mainBox.setAlignment(Pos.CENTER);

        menuBar = new MenuBar();
        menuBar.setMinWidth(1040);
        Menu menuFile = new Menu("File");
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Saves
            }
        });

        MenuItem clear = new MenuItem("Clear Scene");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // clears scene
            }
        });

        MenuItem exit = new MenuItem("Exit Application");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Exits application
            }
        });

        MenuItem help = new MenuItem("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Does not Help
            }
        });

        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aboutDisplay.aboutDisplay("About us", "Florida Get Crunk Universiteam\n"
                        +"Group members: \n"
                        +"Brannon Centeno\n"
                        +"Giovanni Gastaldo\n"
                        +"Isaac Cox\n"
                        +"Kira Herb\n"
                        +"Shane Jones");
            }
        });

        menuFile.getItems().addAll(saveFile, clear, exit, help, about);

        Menu menuEdit = new Menu("Edit");
        MenuItem delete = new MenuItem("Delete");
        delete.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Destroys object
            }
        });

        menuEdit.getItems().addAll(delete);

        // Menu Settings
        Menu menuSettings = new Menu("Settings");
        MenuItem environment = new MenuItem("Environment");
        environment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Alters environment
            }
        });

        menuSettings.getItems().addAll(environment);
        menuBar.getMenus().addAll(menuFile, menuEdit, menuSettings);
        borderGUI.setTop(menuBar);


        ((Group)mainScene.getRoot()).getChildren().addAll(mainBox);

        window.setScene(mainScene);
        window.show();

    }
    public VBox componentsGUI() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #808080");
        vbox.setMaxHeight(400);

        Text componentsTitle = new Text("Components List");
        componentsTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 12));

        batteryButton = new Button("Battery");
        batteryButton.setPrefSize(100, 20);

        ledButton = new Button("LED");
        ledButton.setPrefSize(100, 20);

        resistorButton = new Button("Resistor");
        resistorButton.setPrefSize(100, 20);

        switchButton = new Button("Switch");
        switchButton.setPrefSize(100, 20);
        vbox.getChildren().addAll(componentsTitle, batteryButton, ledButton, resistorButton, switchButton);
        return vbox;
    }
    public VBox inspectorGUI() {
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(15, 12, 15, 12));
        vbox1.setSpacing(8);
        vbox1.setStyle("-fx-background-color: #808080");
        vbox1.setMaxHeight(400);

        inspectorTitle = new Text("Inspector");
        inspectorTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 12));

        objectProperties = new Label("Object Properties");
        properties0 = new TextField();
        properties1 = new TextField();
        properties2 = new TextField();
        properties3 = new TextField();

        properties0.setMaxWidth(50);
        properties1.setMaxWidth(50);
        properties2.setMaxWidth(50);
        properties3.setMaxWidth(50);


        vbox1.getChildren().addAll(inspectorTitle, objectProperties, properties0,
                properties1, properties2, properties3);
        return vbox1;
    }
}




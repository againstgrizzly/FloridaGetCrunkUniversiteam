package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.awt.SystemColor.window;

public class Main extends Application {

    MenuBar menuBar;
    BorderPane borderGUI;
    Button batteryButton, ledButton, resistorButton, switchButton;
    Label startLabel, objectProperties;
    Button startButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Circuit Simulator");
        Scene scene = new Scene(new VBox(),1280, 760, Color.BLUE);


        BorderPane borderGUI = new BorderPane();
        borderGUI.setLeft(addVbox());
        borderGUI.setRight(addVbox1());

        Scene scene1 = new Scene(borderGUI, 1280, 760);
        startLabel = new Label("Welcome to Circuit Simulation");
        startLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        startButton = new Button("Start Simulation");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);
            }
        });

        menuBar = new MenuBar();

        VBox clearBox = new VBox(20);

        // Menu File
        Menu menuFile = new Menu("File");
        MenuItem saveFile = new MenuItem("Save");
        saveFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Saves File
            }
        });
        MenuItem clear = new MenuItem("Clear scene");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                clearBox.setVisible(false);
            }
        });

        MenuItem exit = new MenuItem("Exit application");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Exits the application
            }
        });

        MenuItem help = new MenuItem("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Does not help
            }
        });

        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        menuFile.getItems().addAll(clear, saveFile, exit, help, about);

        // Menu Edit
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

        //Displays message About Us, implements class aboutDisplay
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aboutDisplay.aboutDisplay("About us", "Florida Get Crunk Universiteam\n"
                        +"Group members: \n"
                        + "Brannon Centeno\n"
                        + "Giovanni Gastaldo\n"
                        +"Isaac Cox\n"
                        +"Kira Herb\n"
                        + "Shane Jones");
            }
        });

        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, startLabel, startButton);

        window.setScene(scene);
        window.show();
    }


    public VBox addVbox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #808080");
        vbox.setMaxHeight(400);

        Text title = new Text("Components List");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        batteryButton = new Button("Battery");
        batteryButton.setPrefSize(100, 20);

        ledButton = new Button("LED");
        ledButton.setPrefSize(100, 20);

        resistorButton = new Button("Resistor");
        resistorButton.setPrefSize(100, 20);

        switchButton = new Button("Switch");
        switchButton.setPrefSize(100, 20);
        vbox.getChildren().addAll(title, batteryButton, ledButton, resistorButton, switchButton);
        return vbox;
        }
    public VBox addVbox1() {
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(15, 12, 15, 12));
        vbox1.setSpacing(8);
        vbox1.setStyle("-fx-background-color: #808080");
        vbox1.setMaxHeight(400);

        Text title = new Text("Inspector");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        objectProperties = new Label("Object Properties");
        TextField properties0 = new TextField();
        TextField properties1 = new TextField();
        TextField properties2 = new TextField();
        TextField properties3 = new TextField();

        vbox1.getChildren().addAll(title, objectProperties, properties0,
                properties1, properties2, properties3);
        return vbox1;
    }
}

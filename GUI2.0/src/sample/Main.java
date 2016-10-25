package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    Scene mainScene;
    Button startButton, exitButton;
    Text componentsTitle, inspectorTitle;
    Button batteryButton, ledButton, resistorButton, switchButton;
    Label startLabel, objectProperties, textFieldLabel0, textFieldLabel1, textFieldLabel2, textFieldLabel3;
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
        borderGUI.setStyle("-fx-background: #F5F5DC");
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

        MenuItem exit = new MenuItem("Exit to Main Menu");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(mainScene);
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


        Text componentsTitle = new Text("Components List");
        componentsTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 16));

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
    public GridPane inspectorGUI() {
        GridPane gridGUI = new GridPane();
        gridGUI.setAlignment(Pos.TOP_CENTER);
        gridGUI.setVgap(8);
        HBox hbox1 = new HBox();
        gridGUI.setPadding(new Insets(15, 12, 15, 12));
        gridGUI.setStyle("-fx-background-color: #808080");
        gridGUI.setMaxHeight(200);
        gridGUI.setMinWidth(150);


        inspectorTitle = new Text("Inspector");
        inspectorTitle.setTextAlignment(TextAlignment.RIGHT);
        inspectorTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 16));





        objectProperties = new Label();
        objectProperties.setText("Object Properties");


        textFieldLabel0 = new Label("Label:");
        textFieldLabel1 = new Label("Label:");
        textFieldLabel2 = new Label("Label:");
        textFieldLabel3 = new Label("Label:");
        properties0 = new TextField();
        properties1 = new TextField();
        properties2 = new TextField();
        properties3 = new TextField();


        hbox1.getChildren().addAll(inspectorTitle, objectProperties);
        gridGUI.add(inspectorTitle, 0, 0);
        gridGUI.add(objectProperties, 0, 1);
        gridGUI.add(textFieldLabel0, 0, 2);
        gridGUI.add(properties0, 2, 2);
        gridGUI.add(textFieldLabel1, 0, 3);
        gridGUI.add(properties1, 2, 3);
        gridGUI.add(textFieldLabel2, 0, 4);
        gridGUI.add(properties2, 2, 4);
        gridGUI.add(textFieldLabel3, 0, 5);
        gridGUI.add(properties3, 2, 5);

        return gridGUI;
    }
}




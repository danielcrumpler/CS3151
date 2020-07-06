package edu.westga.cs3151.project3.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AnimalGameController {

    @FXML
    private AnchorPane pane;

    @FXML
    private MenuBar manuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private Menu menuHelp;

    @FXML
    private Pane startPane;

    @FXML
    private Button startButton;

    @FXML
    private Pane quessPane;

    @FXML
    private Text quessText;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

}


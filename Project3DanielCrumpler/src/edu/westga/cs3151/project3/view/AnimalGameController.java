package edu.westga.cs3151.project3.view;

import edu.westga.cs3151.project3.model.BinaryTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Window;

/**
 * The class AnimalGameController
 * 
 * @author Daniel Crumpler
 *
 */
public class AnimalGameController {

	BinaryTree tree;
	
    @FXML
    private AnchorPane pane;

    @FXML
    private MenuBar manuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private Menu menuHelp;

    @FXML
    private Button startButton;

    @FXML
    private Text quessText;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    /**
     * Instantiates a new BinaryTree
     */
    public AnimalGameController() {
		this.tree = new BinaryTree("Is your animal a cat?");
	}

	@FXML
	private void initialize() {
		this.setVisableGuessPane(false);
	}

	private void setVisableGuessPane(boolean bool) {
		this.yesButton.setVisible(bool);
		this.noButton.setVisible(bool);
		this.quessText.setVisible(bool);
	}
	
	@FXML
	private void startButton(ActionEvent event) {
		this.setVisableGuessPane(true);
	}
	
	@FXML
	private void yesButton(ActionEvent event) {
		this.tree
	}
	
	@FXML
	private void noButton(ActionEvent event) {

	}
	
	@FXML
	private void aboutItem(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		Window owner = this.pane.getScene().getWindow();
		alert.initOwner(owner);
		alert.setTitle("About");
		alert.setHeaderText("Animal Game by Daniel Crumpler");
		alert.setContentText("Version 1.0");
		alert.showAndWait();
	}
}


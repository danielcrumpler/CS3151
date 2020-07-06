package edu.westga.cs3151.project3.view;

import edu.westga.cs3151.project3.model.BinaryTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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

	private BinaryTree tree;
	

    @FXML
    private AnchorPane pane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private MenuItem loadItem;
    
    @FXML
    private MenuItem saveItem;

    @FXML
    private Menu menuHelp;

    @FXML
    private MenuItem aboutItem;

    @FXML
    private Text titleText;

    @FXML
    private Text captionText;

    @FXML
    private Button startButton;

    @FXML
    private Text guessText;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Text wonText;

    @FXML
    private Text wonText2;

    @FXML
    private Text wonText3;

    @FXML
    private TextField animalSuggest;

    @FXML
    private TextField questionSuggest;

    @FXML
    private Text wonText4;

    @FXML
    private RadioButton radioYes;

    @FXML
    private RadioButton radioNo;

    @FXML
    private Text loseText;
    
    /**
     * Instantiates a new BinaryTree
     */
    public AnimalGameController() {
		this.tree = new BinaryTree("Is your animal a cat?", "Animal");
	}

	@FXML
	private void initialize() {
		this.setVisableStartPane(true);
		this.setVisableGuessPane(false);
		this.setVisableWinPane(false);
		this.setVisableLossPane(false);
	}

	private void setVisableGuessPane(boolean bool) {
		this.yesButton.setVisible(bool);
		this.noButton.setVisible(bool);
		this.guessText.setVisible(bool);
	}
	
	private void setVisableStartPane(boolean bool) {
		this.startButton.setVisible(bool);
		this.titleText.setVisible(bool);
		this.captionText.setVisible(bool);
	}
	
	private void setVisableWinPane(boolean bool) {
		this.wonText.setVisible(bool);
		this.wonText2.setVisible(bool);
		this.wonText3.setVisible(bool);
		this.wonText4.setVisible(bool);
		this.animalSuggest.setVisible(bool);
		this.questionSuggest.setVisible(bool);
		this.radioYes.setVisible(bool);
		this.radioNo.setVisible(bool);
	}
	
	private void setVisableLossPane(boolean bool) {
		this.startButton.setVisible(bool);
		this.loseText.setVisible(bool);
		this.captionText.setVisible(bool);
	}
	
	@FXML
	private void startButton(ActionEvent event) {
		this.setVisableStartPane(false);
		this.setVisableGuessPane(true);
		this.guessText.textProperty().setValue("Is your animal a cat?");
	}
	
	@FXML
	private void yesButton(ActionEvent event) {
		if (this.tree.getLeft() == null) {
			this.setVisableGuessPane(false);
			this.setVisableLossPane(true);
		}
		this.guessText.textProperty().setValue(this.tree.getLeft().getValue());
	}
	
	@FXML
	private void noButton(ActionEvent event) {
		if (this.tree.getRight() == null) {
			this.setVisableGuessPane(false);
			this.setVisableWinPane(true);
		}
		this.guessText.textProperty().setValue(this.tree.getLeft().getValue());
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


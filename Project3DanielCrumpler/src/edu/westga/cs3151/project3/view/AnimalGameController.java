package edu.westga.cs3151.project3.view;

import java.io.File;
import java.io.PrintWriter;

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
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * The class AnimalGameController
 * 
 * @author Daniel Crumpler
 *
 */
public class AnimalGameController {

	private static final String ANIMAL = "Animal";

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
	private Button submitButton;

	@FXML
	private Text loseText;

	@FXML
	private Text thanksText;

	/**
	 * Instantiates a new BinaryTree
	 */
	public AnimalGameController() {
		this.tree = new BinaryTree("Is your animal a cat?", ANIMAL);
	}

	@FXML
	private void initialize() {
		this.setupRadioButtonListeners();
		this.setVisableGuessPane(false);
		this.setVisableWinPane(false);
		this.setVisableLossPane(false);
		this.setVisableThanksPane(false);
		this.setVisableStartPane(true);
	}

	private void setupRadioButtonListeners() {
		this.radioYes.selectedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				this.radioNo.selectedProperty().setValue(false);
			}
		});
		this.radioNo.selectedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				this.radioYes.selectedProperty().setValue(false);
			}
		});
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
		this.submitButton.setVisible(bool);
	}

	private void clearTextFields() {
		this.animalSuggest.textProperty().setValue("");
		this.questionSuggest.textProperty().setValue("");
	}

	private void setVisableLossPane(boolean bool) {
		this.startButton.setVisible(bool);
		this.loseText.setVisible(bool);
		this.captionText.setVisible(bool);
	}

	private void setVisableThanksPane(boolean bool) {
		this.startButton.setVisible(bool);
		this.captionText.setVisible(bool);
		this.thanksText.setVisible(bool);
	}

	@FXML
	private void startButton(ActionEvent event) {
		this.setVisableStartPane(false);
		this.setVisableLossPane(false);
		this.setVisableThanksPane(false);
		this.setVisableGuessPane(true);
		this.guessText.textProperty().setValue(this.tree.getRoot().getValue());
		this.tree.resetCurrent();
	}

	@FXML
	private void yesButton(ActionEvent event) {
		if (this.tree.getCurrent().getType() == ANIMAL) {
			this.setVisableGuessPane(false);
			this.setVisableLossPane(true);
		} else {
			this.guessText.textProperty().setValue(this.tree.getLeft().getValue());
		}
	}

	@FXML
	private void noButton(ActionEvent event) {
		if (this.tree.getCurrent().getType() == ANIMAL) {
			this.setVisableGuessPane(false);
			this.setVisableWinPane(true);
		} else {
			this.guessText.textProperty().setValue(this.tree.getRight().getValue());
		}
	}

	@FXML
	private void submitButton(ActionEvent event) {
		if (!this.animalSuggest.textProperty().getValue().equals("")
				&& !this.questionSuggest.textProperty().getValue().equals("") && this.atLeastOneRadioSelected()) {
			boolean selected = false;
			if (this.radioYes.isSelected()) {
				selected = true;
			}
			if (this.radioNo.isSelected()) {
				selected = false;
			}
			this.tree.addNewQuestion(this.questionSuggest.textProperty().getValue(),
					this.animalSuggest.textProperty().getValue(), selected);
			this.setVisableWinPane(false);
			this.clearTextFields();
			this.setVisableThanksPane(true);
		} else {
			throw new IllegalArgumentException("A Text Field is empty or a Button is not selected.");
		}
	}

	private boolean atLeastOneRadioSelected() {
		return this.radioYes.isSelected() || this.radioNo.isSelected();
	}

	private void setLoadFileFilters(FileChooser fileChooser) {
		ExtensionFilter filter = new ExtensionFilter("Animal Game Tree", "*.agt");
		fileChooser.getExtensionFilters().add(filter);
		filter = new ExtensionFilter("All Files", "*.*");
		fileChooser.getExtensionFilters().add(filter);
	}
	
	@FXML
	private void loadItem(ActionEvent event) {

	}

	@FXML
	private void saveItem(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		this.setLoadFileFilters(fileChooser);

		Window owner = this.pane.getScene().getWindow();
		File selectedFile = fileChooser.showSaveDialog(owner);

		if (selectedFile != null) {
			try (PrintWriter writer = new PrintWriter(selectedFile)) {
				String output = this.tree.traverseTree(this.tree.getRoot());
				writer.println(output);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

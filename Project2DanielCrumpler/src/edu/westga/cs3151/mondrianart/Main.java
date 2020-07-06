package edu.westga.cs3151.mondrianart;

import java.util.Optional;

import edu.westga.cs3151.mondrianart.model.MondrianArt;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Entry point for application.
 * 
 * @author Daniel Crumpler
 */
public class Main extends Application {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) {
		int minLength;
		int minWidth;
		try {
			minLength = this.displayDialogForLength();
			minWidth = this.displayDialogForWidth();
			Canvas canvas = new Canvas(600, 600);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			MondrianArt mondrianArt = new MondrianArt();
			mondrianArt.generateRectangles(minLength, minWidth, gc);
			Group group = new Group();
			group.getChildren().add(canvas);
			Scene scene = new Scene(new BorderPane(group), WIDTH, HEIGHT);
			primaryStage.setTitle("Mondrian Art by Daniel Crumpler");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param args Not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The text dialog box for the length input
	 * 
	 * @return the length entered
	 */
	private int displayDialogForLength() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Dialog for length");
		dialog.setHeaderText("Enter the minimum box length greater than 0.");
		dialog.setContentText("Length:");
		Optional<String> result = dialog.showAndWait();
		int input = 0;

		try {
			input = Integer.parseInt(result.get());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Error");
			alert.setContentText("The provided input is not an integer.");
			alert.showAndWait();
			input = this.displayDialogForLength();
		}
		if (input <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Error");
			alert.setContentText("The provided input is not greater then zero.");
			alert.showAndWait();
			input = this.displayDialogForLength();
		}
		return input;
	}

	/**
	 * The text dialog box for the width input
	 * 
	 * @return the width entered
	 */
	private int displayDialogForWidth() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Dialog for width");
		dialog.setHeaderText("Enter the minimum box width greater than 0.");
		dialog.setContentText("Width:");
		Optional<String> result = dialog.showAndWait();
		int input = 0;

		try {
			input = Integer.parseInt(result.get());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Error");
			alert.setContentText("The provided input is not an integer.");
			alert.showAndWait();
			input = this.displayDialogForWidth();
		}
		if (input <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Error");
			alert.setContentText("The provided input is not greater then zero.");
			alert.showAndWait();
			input = this.displayDialogForWidth();
		}
		return input;
	}

}

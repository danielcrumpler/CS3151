package edu.westga.cs3151.mondrianart.model;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 * The class MondrianArt
 * 
 * @author Daniel Crumpler
 */
public class MondrianArt {

	private Random random = new Random();

	/**
	 * Draws rectangles by taking the minimum width and length and randomizing color
	 * putting it onto the canvas.
	 * 
	 * @precondition minLength > 0 && minWidth > 0
	 * @postcondition A canvas filled with rectangles is created.
	 *
	 * @param minLength the minimum length of a rectangle
	 * @param minWidth  the minimum width of a rectangle
	 * @param gc        the graphics context
	 */
	public void generateRectangles(int minLength, int minWidth, GraphicsContext gc) {
		if (minLength <= 0) {
			throw new IllegalArgumentException("Minimum length cannot be less then zero.");
		}
		if (minWidth <= 0) {
			throw new IllegalArgumentException("Minimum width cannot be less then zero.");
		}
		Rectangle rectangle = new Rectangle(-2, -2, gc.getCanvas().getWidth() + 10, gc.getCanvas().getHeight() + 10);
		this.drawLineInRectangle(rectangle, gc, minLength, minWidth);
	}

	private void drawLineInRectangle(Rectangle rectangle, GraphicsContext gc, int minLength, int minWidth) {
		int randomOffset, firstX, firstY, secondX, secondY;
		Rectangle rectangle0, rectangle1;
		if (rectangle.getWidth() <= minWidth || rectangle.getHeight() <= minLength) {
			return;
		}
		if (rectangle.getWidth() < rectangle.getHeight()) {
			randomOffset = this.random.nextInt((int) rectangle.getHeight());
			rectangle0 = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), randomOffset);
			rectangle1 = new Rectangle(rectangle.getX(), rectangle.getY() + randomOffset, rectangle.getWidth(),
					rectangle.getHeight() - randomOffset);
			firstX = (int) rectangle.getX();
			firstY = (int) (rectangle.getY() + randomOffset);
			secondX = (int) (firstX + rectangle.getWidth());
			secondY = firstY;
		} else {
			randomOffset = this.random.nextInt((int) rectangle.getWidth());
			rectangle0 = new Rectangle(rectangle.getX(), rectangle.getY(), randomOffset, rectangle.getHeight());
			rectangle1 = new Rectangle(rectangle.getX() + randomOffset, rectangle.getY(),
					rectangle.getWidth() - randomOffset, rectangle.getHeight());
			firstX = (int) (rectangle.getX() + randomOffset);
			firstY = (int) rectangle.getY();
			secondX = firstX;
			secondY = (int) (rectangle.getY() + rectangle.getHeight());
		}
		this.fillRectangle(rectangle0, 2, gc);
		this.fillRectangle(rectangle1, 2, gc);
		this.drawLine(gc, firstX, firstY, secondX, secondY);
		this.drawLineInRectangle(rectangle0, gc, minLength, minWidth);
		this.drawLineInRectangle(rectangle1, gc, minLength, minWidth);
	}

	/**
	 * Draws the black lines for rectangle
	 * 
	 * @param gc      the graphic context
	 * @param firstX  the first X coordinate
	 * @param firstY  the first Y coordinate
	 * @param secondX the second X coordinate
	 * @param secondY the second Y coordinate
	 */
	private void drawLine(GraphicsContext gc, int firstX, int firstY, int secondX, int secondY) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		gc.strokeLine(firstX, firstY, secondX, secondY);
	}

	/**
	 * Gives the rectangle a random color.
	 * 
	 * @param rectangle the rectangle to give color
	 * @param gap       the offset of color
	 * @param gc        the graphic context
	 */
	private void fillRectangle(Rectangle rectangle, int gap, GraphicsContext gc) {
		int red1 = this.random.nextInt(256);
		int green1 = this.random.nextInt(256);
		int blue1 = this.random.nextInt(256);
		int red2 = this.random.nextInt(256);
		int green2 = this.random.nextInt(256);
		int blue2 = this.random.nextInt(256);
		boolean choice = this.random.nextBoolean();
		if (!choice) {
			Color randomColor = Color.rgb(red1, green1, blue1);
			gc.setFill(randomColor);
		} else {
			Stop[] stops = new Stop[] { new Stop(0, Color.rgb(red1, green1, blue1)),
					                   new Stop(1, Color.rgb(red2, green2, blue2)) };
			LinearGradient randomGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
			gc.setFill(randomGradient);
		}
		gc.fillRect(rectangle.getX() + gap, rectangle.getY() + gap, rectangle.getWidth() - 2 * gap,
				rectangle.getHeight() - 2 * gap);
	}
}

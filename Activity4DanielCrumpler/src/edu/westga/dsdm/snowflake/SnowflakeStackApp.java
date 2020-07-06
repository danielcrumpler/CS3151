package edu.westga.dsdm.snowflake;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import edu.westga.dsdm.model.LinkedListStack;
import edu.westga.dsdm.model.SinglyLinkedList;

/**
 * SnowflakeApp - display of fractal snowflake
 *
 * @author CS3151
 * @version Spring 2020
 */
public class SnowflakeStackApp extends Frame {

	private LinkedListStack<Line> lines = new LinkedListStack<Line>();
	private SinglyLinkedList<Line> done;
	private static final long serialVersionUID = 1234;

	/**
	 * Instantiates a new snowflake application
	 */
	public SnowflakeStackApp() {
		this.lines = new LinkedListStack<Line>();
		this.done = new SinglyLinkedList<Line>();

		setTitle("Fractal Snowflake");
		setSize(400, 400);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
	}

	/**
	 * Runs the snowflake application
	 */
	public void run() {
		Point pointA = new Point(50, 140);
		Point pointB = new Point(350, 140);
		Point pointC = new Point(200, 360);

		// insert initial lines
		this.lines.push(new Line(pointA, pointB));
		this.lines.push(new Line(pointB, pointC));
		this.lines.push(new Line(pointC, pointA));

		// now make the snowflake
		while (!this.lines.isEmpty()) {
			Line line = this.lines.pop();
			this.processLine(line);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.err.println("Thread.sleep() - something went wrong");
			}
			repaint();
		}
	}

	private void processLine(Line line) {
		// first compute line lengths
		int dx = (line.stop.x - line.start.x) / 3;
		int dy = (line.stop.y - line.start.y) / 3;
		if ((dx * dx + dy * dy) < 10) {
			// line is too small to be drawn
			this.done.addHead(line);
		} else {
			Point pointA = new Point(line.start.x + dx, line.start.y + dy);
			Point pointB = new Point(line.start.x + 3 * dx / 2 + dy, line.start.y + 3 * dy / 2 - dx);
			Point pointC = new Point(line.start.x + 2 * dx, line.start.y + 2 * dy);
			this.lines.push(new Line(line.start, pointA));
			this.lines.push(new Line(pointA, pointB));
			this.lines.push(new Line(pointB, pointC));
			this.lines.push(new Line(pointC, line.stop));
		}
	}

	/**
	 * Paints the graphics
	 * 
	 * @param graphics the graphics of this application
	 */
	public void paint(Graphics graphics) {
        for (Line line : this.lines) {
            line.draw(graphics);
        }

		for (Line line : this.done) {
			line.draw(graphics);
		}
	}
	
	private class Line {
		private Point start;
		private Point stop;

		Line(Point startPoint, Point endPoont) {
			this.start = startPoint;
			this.stop = endPoont;
		}

		public void draw(Graphics graphics) {
			graphics.drawLine(this.start.x, this.start.y, this.stop.x, this.stop.y);
		}
	}
}
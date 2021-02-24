import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class Main {
	static final int CANVAS_WIDTH = 500;
	static final int CANVAS_HEIGHT = 500;
	static final int SHAPES_TO_CREATE = 100;

	// The canvas that we draw on
	public static JComponent canvas;
	// The global list of shapes
	public static ArrayList<Shape> shapes;

	public static void main(String[] args) {
		// Create empty array list of shapes.
		shapes = new ArrayList<Shape>();

		Random rand = new Random();

		Circle myRedShape = new Circle(20, 55, 39, Colour.RED);
		shapes.add(myRedShape);

		Circle myBlueShape = new Circle(2, 10, 52, Colour.BLUE);
		shapes.add(myBlueShape);

		Circle myGreenShape = new Circle(6, 51, 102, Colour.GREEN);
		shapes.add(myGreenShape);

		for (int i = 1; i < SHAPES_TO_CREATE; i++) {
			if (rand.nextBoolean()) {
				Rectangle myShape = new Rectangle(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), Colour.getRandomColour());
				shapes.add(myShape);
			}
			
			else {
				Circle myShape = new Circle(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), Colour.getRandomColour());
				shapes.add(myShape);
			}
		}

		setupGUI();
	}

	/**
	 * This method draws all shapes on to the canvas. This method will be
	 * automatically called each time Java need to draw the canvas. Do NOT call this
	 * method manually.
	 * 
	 * @param g The graphics context to draw with.
	 */

	public static void drawAllShapes(Graphics g) {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
		}
	}

	/**
	 * This method changes the colours of all the shapes to random colours. This is
	 * called when the "Change Colours" button is clicked.
	 */
	public static void changeColorAllShapes() {
		Random rand = new Random();

		for (int i = 0; i < shapes.size(); i++) {
			int red = rand.nextInt(256);
			int green = rand.nextInt(256);
			int blue = rand.nextInt(256);

			shapes.get(i).setColour(red, green, blue);
		}

		// Force java to draw canvas
		canvas.repaint();
	}

	/**
	 * This method increases the size of all the shapes. This is called when the
	 * "Increase Size" button is clicked.
	 */
	public static void increaseSizeAllShapes() {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).increaseSize();
		}

		// Force java to draw canvas
		canvas.repaint();
	}

	/**
	 * This method decreases the size of all the shapes. This is called when the
	 * "Decrease Size" button is clicked.
	 */
	public static void decreaseSizeAllShapes() {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).decreaseSize();
		}

		// Force java to draw canvas
		canvas.repaint();
	}

	// ************************************************************
	// Do not alter or worry about code below this line
	// ************************************************************

	/**
	 * This method sets up the GUI.
	 */
	public static void setupGUI() {
		// Create new window
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Add a graphic canvas to draw on
		canvas = new JComponent() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				drawAllShapes(g);
			}
		};
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		frame.add(canvas, BorderLayout.CENTER);

		// Panel for buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		frame.add(buttonsPanel, BorderLayout.EAST);

		// Add the buttons
		JButton changeColorsButton = new JButton("Change Colors");
		changeColorsButton.addActionListener(event -> changeColorAllShapes());
		buttonsPanel.add(changeColorsButton);

		JButton increaseSizeButton = new JButton("Increase Size");
		increaseSizeButton.addActionListener(event -> increaseSizeAllShapes());
		buttonsPanel.add(increaseSizeButton);

		JButton decreaseSizeButton = new JButton("Decrease Size");
		decreaseSizeButton.addActionListener(event -> decreaseSizeAllShapes());
		buttonsPanel.add(decreaseSizeButton);

		// Make GUI visible
		frame.pack();
		frame.setVisible(true);
	}
}

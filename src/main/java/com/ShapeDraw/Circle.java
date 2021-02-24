import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius, int posX, int posY) {
        super(posX, posY);
        this.radius = radius;
    }

    public Circle(int radius, int posX, int posY, int colourR, int colourG, int colourB) {
        super(posX, posY, new Colour(colourR, colourG, colourB));
        this.radius = radius;
    }

    public Circle(int radius, int posX, int posY, Colour colour) {
        super(posX, posY, colour);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "This circle has a radius of " + radius + ", an area of " + this.getCircleArea()
                + " and a circumference of " + this.getCircleCircumference() + ". Its RGB colour is ("
                + this.getRedValue() + ", " + this.getGreenValue() + ", " + this.getBlueValue()
                + "). Its X position is " + this.getXPos() + " and its Y position is " + this.getYPos() + ".";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColour().toSwingColor());
        g.fillOval(this.getXPos(), this.getYPos(), radius, radius);
    }

    @Override
    public void centreAtCoordinate(int centreX, int centreY) {
        this.setXPos(centreX);
        this.setYPos(centreY);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getCircleArea() {
        return Math.PI * radius * radius;
    }

    public double getCircleCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void increaseSize() {
        radius += 5;
    }

    @Override
    public void decreaseSize() {
        radius -= 5;
    }
}

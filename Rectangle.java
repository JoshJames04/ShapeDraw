import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width, int posX, int posY) {
        super(posX, posY);
        this.height = height;
        this.width = width;
    }

    public Rectangle(int height, int width, int posX, int posY, int colourR, int colourG, int colourB) {
        super(posX, posY, colourR, colourG, colourB);
        this.height = height;
        this.width = width;
    }

    public Rectangle(int height, int width, int posX, int posY, Colour colour) {
        super(posX, posY, colour);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "This rectangle has a height of " + height + ", a width of " + width + " and an area of "
                + this.getRectangleArea() + ". Its RGB colour is (" + this.getRedValue() + ", " + this.getGreenValue()
                + ", " + this.getBlueValue() + "). Its X position is " + this.getXPos() + " and its Y position is "
                + this.getYPos() + ".";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColour().toSwingColor());
        g.fillRect(this.getXPos(), this.getYPos(), this.width, this.height);
    }

    @Override
    public void centreAtCoordinate(int centreX, int centreY) {
        centreX += width / 2;
        centreY += height / 2;

        this.setXPos(centreX);
        this.setYPos(centreY);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getRectangleArea() {
        return height * width;
    }

    @Override
    public void increaseSize() {
        width += 5;
        height += 5;
    }

    @Override
    public void decreaseSize() {
        width -= 5;
        height -= 5;
    }
}

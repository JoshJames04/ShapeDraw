import java.awt.Graphics;

public abstract class Shape {
    private int posX;
    private int posY;
    private Colour colour;

    private static final int DEFAULT_POS_VAL = 0;
    private static final int DEFAULT_COLOUR_VAL = 0;

    public Shape() {
        this(DEFAULT_POS_VAL, DEFAULT_POS_VAL, DEFAULT_COLOUR_VAL, DEFAULT_COLOUR_VAL, DEFAULT_COLOUR_VAL);
    }

    public Shape(int posX, int posY) {
        this(posX, posY, DEFAULT_COLOUR_VAL, DEFAULT_COLOUR_VAL, DEFAULT_COLOUR_VAL);
    }

    public Shape(int posX, int posY, int colourR, int colourG, int colourB) {
        this.posX = posX;
        this.posY = posY;
        this.colour = new Colour(colourR, colourG, colourB);
    }

    public Shape(int posX, int posY, Colour colour) {
        this.posX = posX;
        this.posY = posY;
        this.colour = colour;
    }

    public String toString() {
        return "This shape has an RGB colour of (" + this.getRedValue() + ", " + this.getGreenValue() + ", "
                + this.getBlueValue() + "). Its X position is " + this.getXPos() + " and its Y position is "
                + this.getYPos() + ".";
    }

    public abstract void draw(Graphics g);

    public abstract void centreAtCoordinate(int centreX, int centreY);

    public void setXPos(int posX) {
        this.posX = posX;
    }

    public void setYPos(int posY) {
        this.posY = posY;
    }

    public void setColour(int colourR, int colourG, int colourB) {
        this.colour = new Colour(colourR, colourG, colourB);
    }

    public int getXPos() {
        return posX;
    }

    public int getYPos() {
        return posY;
    }

    public int getRedValue() {
        return colour.getRedVal();
    }

    public int getGreenValue() {
        return colour.getGreenVal();
    }

    public int getBlueValue() {
        return colour.getBlueVal();
    }

    public Colour getColour() {
        return this.colour;
    }

    public abstract void increaseSize();

    public abstract void decreaseSize();
}
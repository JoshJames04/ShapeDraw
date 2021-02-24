import java.util.List;
import java.awt.Color;
import java.util.Random;

public class Colour {

    public static final Colour RED = new Colour(255, 0, 0);
    public static final Colour GREEN = new Colour(0, 255, 0);
    public static final Colour BLUE = new Colour(0, 0, 255);

    private int colourR;
    private int colourG;
    private int colourB;

    public Colour(int colourR, int colourG, int colourB) {
        setColour(colourR, colourG, colourB);
    }

    public int getRedVal() {
        return colourR;
    }

    public int getGreenVal() {
        return colourG;
    }

    public int getBlueVal() {
        return colourB;
    }

    public void setColour(int colourR, int colourG, int colourB) {
        this.colourR = colourR;
        this.colourG = colourG;
        this.colourB = colourB;
    }

    public Color toSwingColor() {
        Color myColor = new Color(this.colourR, this.colourG, this.colourB);
        return myColor;
    }

    public static Colour getRandomColour() {
		Random rand = new Random();

        return new Colour(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
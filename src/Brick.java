// Brick Breaker By: Jake Sonsini
import java.awt.Color;
import java.awt.Graphics;
public class Brick {
    // Instance Variables
    // Coordinates
    private int x;
    private int y;
    // Point value
    private final int point = 10;
    // Dimensions
    public final static int WIDTH = 20;
    public final static int HEIGHT = 20;
    // Empty status
    private boolean isEmpty;
    public Brick(int x, int y){
        // Set x and y values and make sure the new bricks aren't empty
        this.x = x;
        this.y = y;
        isEmpty = false;
    }
    // Sets the status to empty
    public void setEmpty(){
        isEmpty = true;
    }
    // Returns status
    public boolean isEmpty() {
        return isEmpty;
    }
    // Returns width
    public int getWIDTH() {
        return WIDTH;
    }
    // Returns height
    public int getHEIGHT() {
        return HEIGHT;
    }
    // Returns x
    public int getX() {
        return x;
    }
    // Returns y
    public int getY() {
        return y;
    }
    // Returns point value
    public int getPoint() {
        return point;
    }
    // Draw brick if it isn't empty
    public void draw(Graphics g){
        if(!isEmpty){
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }
    public boolean checkBrickBounceX(BrickWall w, Ball b){
        // Compare the brick coordinates with ball coordinates
        if (((((b.getY() - getHEIGHT() <= (y + 20)) && (b.getY() - getHEIGHT() >= y) && b.getDy() < 0) && (b.getX() > x && b.getX() < x + 20))
                || (((b.getY() + getHEIGHT() >= y) && (b.getY() + getHEIGHT() <= (y + 20) && b.getDy() > 0)) && (b.getX() > x && b.getX() < x + 20)))){
            // If they contact return true
            return true;
        }
        return false;
    }
    public boolean checkBrickBounceY(BrickWall w, Ball b){
        // Same process but checks y coordinates
        if (((((b.getX() - getWIDTH() <= (x + 20)) && (b.getX() - getWIDTH() >= x) && b.getDx() < 0) && (b.getY() > y && b.getY() < y + 20))
                || (((b.getX() + getWIDTH() >= x) && (b.getX() + getWIDTH() <= (x + 20) && b.getDx() > 0)) && (b.getY() > y && b.getY() < y + 20)))){
            return true;
        }
        return false;
    }
}


// Brick Breaker By: Jake Sonsini
import java.awt.Color;
import java.awt.Graphics;
public class Paddle {
    // Instance Variables
    // Coordinates
    private int x;
    final int y = 700;
    // Dimensions
    final int WIDTH = 100;
    final int HEIGHT = 20;
    // Set x location
    public Paddle(){
        x = 350;
    }
    // Set the location of the paddle
    public void setLocation(int x){
        this.x = x;
    }
    public void draw(Graphics g){
        // Draw the paddle
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    // Returns x value
    public int getX() {
        return x;
    }
    // Returns width
    public int getWIDTH() {
        return WIDTH;
    }
}

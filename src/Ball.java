// Brick Breaker By: Jake Sonsini
import java.awt.Color;
import java.awt.Graphics;
public class Ball {
    // Instance Variables
    // Coordinates
    private int y = 400;
    private int x;
    // Movement speeds
    private int dx = 5;
    private int dy = 5;
    // Out status
    private boolean out = false;
    // Dimensions
    public final static int WIDTH = 20;
    public final static int HEIGHT = 20;
    // Class variables for communication between classes
    Paddle p;
    BrickWall w;
    public Ball(Paddle p, BrickWall w){
        // Initialize random starting point and set Paddle BrickWall variables
        x = (int)(Math.random() * 400);
        this.p = p;
        this.w = w;
    }

    public boolean isOut() {
        // Returns status of the ball
        return out;
    }

    public void move(){
        // Increase ball location
        x += dx;
        y += dy;
    }

    public int getX() {
        // Returns x value
        return x;
    }

    public int getY() {
        // Return y value
        return y;
    }

    public int getDx() {
        // Returns dx
        return dx;
    }

    public int getDy() {
        // Returns dy
        return dy;
    }

    public void bounce(){
        // Check if the ball exits the window then bounce
        if ((x - WIDTH <= 0 && dx < 0) || (x + WIDTH >= 1000 && dx > 0)){
            dx = -dx;
        }

        // Now check for a y bounce.
        if ((y - WIDTH <= 0 && dy < 0)){

            dy = -dy;
        }
        // If the ball exits the lower part of the window set the status of the ball out
        if (y + WIDTH >= 800 && dy > 0){
            out = true;
        }
        // Check for paddle bounce by comparing location of paddle to ball
        if (((((x - WIDTH <= (p.getX() + p.getWIDTH())) && (x - WIDTH >= p.getX()) && dx < 0) && (y > 690 && y < 720)) || (((x + WIDTH >= (p.getX())) && (x + WIDTH <= (p.getX() + p.getWIDTH()) && dx > 0)) && (y > 690 && y < 720)))){
            dy = -dy;
        }
        // Call the BrickBounce for both x and y to check if the ball contacts the bricks
        if (w.checkBricksBounceY(this)){
            dy = -dy;
        }
        if (w.checkBricksBounceX(this)){
            dx = -dx;
        }

    }
    public void draw(Graphics g){
        // Draw the ball at the set coordinates and shift so that the bounces align properly
        g.setColor(Color.WHITE);
        g.fillOval(x - 10, y - 10, WIDTH, HEIGHT);
    }
}

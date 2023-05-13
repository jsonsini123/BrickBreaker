// Brick Breaker By: Jake Sonsini
import java.awt.Color;
import java.awt.Graphics;
public class gBrick extends Brick{
    // Unique point value
    private final int point = 50;
    public gBrick(int x, int y){
        // Call the super class to import the coordinates
        super(x, y);
    }

    @Override
    public int getPoint() {
        // Returns gBrick point value
        return point;
    }

    @Override
    // Draws a different colored brick
    public void draw(Graphics g){
        if(!super.isEmpty()){
            g.setColor(Color.RED);
            g.fillRect(this.getX(), this.getY(), WIDTH, HEIGHT);
        }
    }
}

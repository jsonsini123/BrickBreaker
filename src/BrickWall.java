// Brick Breaker By: Jake Sonsini
import java.util.ArrayList;
import java.awt.Graphics;

public class BrickWall {
    // Instance Variables
    // Total points
    public int points;
    // ArrayList to contain all bricks
    ArrayList<Brick> wall = new ArrayList<>();
    public BrickWall(){
        // First add the gBricks to wall
        points = 0;
        for (int i = 0; i < 30; i++){
            wall.add(new gBrick(i * 25 + 125, 100));
        }
        // Then add normal bricks to wall
        for (int i = 0; i < 8; i++){
            for (int y = 0; y < 30; y++){
                wall.add(new Brick(y * 25 + 125, 125 + i * 25));
            }
        }
    }
    public String sGetPoints() {
        // Returns the string value of points for printing
        String point = String.valueOf(points);
        return point;
    }
    public int getPoints(){
        // Returns points
        return points;
    }

    public boolean checkBricksBounceY(Ball b){
        // Iterate through every brick and call the BrickBounce methods for Y
        for (int i = 0; i < wall.size(); i++){
            if(!wall.get(i).isEmpty()){
                if (wall.get(i).checkBrickBounceY(this, b)){
                    wall.get(i).setEmpty();
                    points += wall.get(i).getPoint();
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkBricksBounceX(Ball b){
        // Iterate through every brick and call the BrickBounce methods for X
        for (int i = 0; i < wall.size(); i++){
            if(!wall.get(i).isEmpty()){
                if (wall.get(i).checkBrickBounceX(this, b)){
                    wall.get(i).setEmpty();
                    points += wall.get(i).getPoint();
                    return true;
                }
            }
        }
        return false;
    }
    public void draw(Graphics g){
        // Draw every brick by calling their draw methods
        for (int i = 0; i < wall.size(); i++){
            wall.get(i).draw(g);
        }
    }
}

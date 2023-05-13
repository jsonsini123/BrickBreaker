// Brick Breaker By: Jake Sonsini
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

public class GameViewer extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
    // Instance Variables
    // Window Size
    public final static int WINDOW_HEIGHT = 800;
    public final static int WINDOW_WIDTH = 1000;
    // Start status
    private boolean start = false;
    // Variables to communicate between each other
    private Paddle p;
    private Ball b;
    private BrickWall w;
    // Clock to run the game
    Timer clock = new Timer(10, this);
    public GameViewer(Paddle p, Ball b, BrickWall w){
        // Intialize variables and create window
        this.w = w;
        this.p = p;
        this.b = b;
        this.setTitle("Brick Breaker!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Set mouse listener
        addMouseListener(this);         // # 5: Required for MouseListeners
        addMouseMotionListener(this);   // # 6: Required for MouseMotionListeners

        this.setVisible(true);
        // Set buffer strategy and start a repeating clock
        createBufferStrategy(2);
        clock.start();
    }
    public void mypaint(Graphics g){
        // Check game status then draw what is needed
        if (!start){
            displayStart(g);
        }
        else{
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("Points: " + w.sGetPoints(), 900, 80);
            p.draw(g);
            b.move();
            b.bounce();
            b.draw(g);
            w.draw(g);
            // Check if the ball is out after starting the game
            if (b.isOut()){
                displayLoss(g);
            }
            // Check if the game is won by comparing max points
            if (w.getPoints() == 3900){
                displayWin(g);
                clock.stop();
            }
        }
    }
    public void displayLoss(Graphics g){
        // Draw important image of the losing screen and then add final points
        g.drawImage(new ImageIcon("Resources/Lose.jpg").getImage(), 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.RED);
        g.setFont(new Font("font", 1, 40));
        g.drawString("Your Final Score: " + w.sGetPoints(), 300, 650);
    }
    public void displayStart(Graphics g){
        // Draw imported start screen
        g.drawImage(new ImageIcon("Resources/Background.png").getImage(), 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void displayWin(Graphics g){
        // Draw imported win screen
        g.drawImage(new ImageIcon("Resources/Win.png").getImage(), 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void paint(Graphics g) {
        // Call double buffer strategy to smooth the games framerate
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;

        Graphics g2 = null;

        try {
            g2 = bf.getDrawGraphics();
            // myPaint does the actual drawing, as described in ManyBallsView
            mypaint(g2);
        }
        finally {
            // It is best to dispose() a Graphics object when done with it.
            g2.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();

        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        //Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
    }
    @Override
    // # 7: Required of a MouseListener
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    // # 8: Required of a MouseListener
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    // # 9: Required of a MouseListener
    public void mouseClicked(MouseEvent e)
    {
        start = true;
    }

    @Override
    // # 10: Required of a MouseListener
    public void mouseEntered(MouseEvent e)
    {
        //test
    }

    @Override
    // # 11: Required of a MouseListener
    public void mouseExited(MouseEvent e)
    {

    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/

    @Override
    // # 12: Required of a MouseMotionListener
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    // #13: Required of a MouseMotionListener
    public void mouseMoved(MouseEvent e)
    {
        // Changes the paddles x location
        p.setLocation(e.getX());
    }
    // put in mouse functions
    public static void main(String[] args) {
        // Create all the variables for the game to run
        Paddle p = new Paddle();
        BrickWall w = new BrickWall();
        Ball b = new Ball(p, w);
        // Gameviewer starts timer and runs the game
        GameViewer view = new GameViewer(p, b, w);
    }
    public void actionPerformed(ActionEvent e){
        // Everytime the timer goes off repaint the game
        this.repaint();
    }
}

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    Characters player2;
    GameFrame gameFrame;
    TileManager tm;
    Timer gameTimer;
    Image grass;
    Image ground;
    Image sky;
    Image wood;
    Image playerImg;

    public GamePanel(GameFrame frame) {
        gameFrame = frame;
        //this.setBounds(0, 0, gameFrame.GameWidth, gameFrame.GameHeight);
        //this.setSize(new Dimension(gameFrame.GameWidth, gameFrame.GameHeight));
        this.setBackground(Color.black);
        initImages();
        tm = new TileManager(gameFrame);
        player2 = new Characters(0, gameFrame.TileSize * 6, this.playerImg, this);
        addKeyListener(player2);
        setFocusable(true);

        gameTimer = new Timer(16, this);
        gameTimer.start();
    }

    public void initImages() {
        try {
            playerImg = ImageIO.read(getClass().getClassLoader().getResource("player.png"));

            if (playerImg == null) {
                System.out.println("player is null");
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        tm.draw(g2d);
        player2.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player2.move();
        repaint();
    }

}

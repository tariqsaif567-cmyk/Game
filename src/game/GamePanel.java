package game;

import java.awt.Color;
import java.awt.Dimension;
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
    Timer gameTimer;
    Image grass;
    Image ground;
    Image sky;
    Image playerImg;

    public GamePanel(GameFrame frame) {
        gameFrame = frame;
        //this.setBounds(0, 0, gameFrame.GameWidth, gameFrame.GameHeight);
        //this.setSize(new Dimension(gameFrame.GameWidth, gameFrame.GameHeight));
        this.setBackground(Color.black);
        initImages();
        player2 = new Characters(0, gameFrame.TileSize * 6, this.playerImg, this);
        addKeyListener(player2);
        setFocusable(true);

        gameTimer = new Timer(16, this);
        gameTimer.start();
    }

    public void initImages() {
        try {
            // Use getResource() instead of getResourceAsStream()
            grass = ImageIO.read(getClass().getClassLoader().getResource("grass.png"));
            ground = ImageIO.read(getClass().getClassLoader().getResource("ground.png"));
            sky = ImageIO.read(getClass().getClassLoader().getResource("sky.png"));
            playerImg = ImageIO.read(getClass().getClassLoader().getResource("player.png"));

            // Verify images loaded
            if (grass == null) {
                System.out.println("grass is null");
            }
            if (ground == null) {
                System.out.println("ground is null");
            }
            if (sky == null) {
                System.out.println("sky is null");
            }
            if (playerImg == null) {
                System.out.println("player is null");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int width = 0;
        int height = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                g2d.drawImage(sky, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
                width += gameFrame.TileSize;
            }
            height += gameFrame.TileSize;
            width = 0;
        }

        for (int i = 0; i < 24; i++) {
            g2d.drawImage(grass, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
            width += gameFrame.TileSize;
        }

        height += gameFrame.TileSize;
        width = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 24; j++) {
                g2d.drawImage(ground, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
                width += gameFrame.TileSize;
            }
            height += gameFrame.TileSize;
            width = 0;
        }
        player2.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player2.move();
        repaint();
    }

}

package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    GameFrame gameFrame;
    Image grass;
    Image ground;
    Image sky;
    Image player;

    public GamePanel(GameFrame frame) {
        gameFrame = frame;
        //this.setBounds(0, 0, gameFrame.GameWidth, gameFrame.GameHeight);
        this.setSize(new Dimension(gameFrame.GameWidth, gameFrame.GameHeight));
        this.setBackground(Color.black);
        initImages();
    }

    public void initImages() {
        try {
            // Use getResource() instead of getResourceAsStream()
            grass = ImageIO.read(getClass().getClassLoader().getResource("grass.png"));
            ground = ImageIO.read(getClass().getClassLoader().getResource("ground.png"));
            sky = ImageIO.read(getClass().getClassLoader().getResource("sky.png"));
            player = ImageIO.read(getClass().getClassLoader().getResource("player.png"));

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
            if (player == null) {
                System.out.println("sky is null");
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
        g2d.drawImage(player, gameFrame.TileSize * 12, gameFrame.TileSize * 5, gameFrame.TileSize, gameFrame.TileSize, null);
        g2d.dispose();
    }

}

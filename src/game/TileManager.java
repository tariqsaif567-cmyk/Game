package game;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TileManager {

    public Tile[] allTiles = new Tile[4];
    public GameFrame gameFrame;

    public TileManager(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        initializeTiles();
        initializeImages();
        initializeSolidness();
    }

    public void draw(Graphics2D gd) {
        int width = 0;
        int height = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                if (i == 5 && j > 10 && j < 21) {
                    gd.drawImage(allTiles[3].tileImage, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
                } else {
                    gd.drawImage(allTiles[2].tileImage, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
                }
                width += gameFrame.TileSize;
            }
            height += gameFrame.TileSize;
            width = 0;
        }

        for (int i = 0; i < 24; i++) {
            gd.drawImage(allTiles[0].tileImage, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
            width += gameFrame.TileSize;
        }

        height += gameFrame.TileSize;
        width = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 24; j++) {
                gd.drawImage(allTiles[1].tileImage, width, height, gameFrame.TileSize, gameFrame.TileSize, null);
                width += gameFrame.TileSize;
            }
            height += gameFrame.TileSize;
            width = 0;
        }
    }

    public void initializeTiles() {
        for (int i = 0; i < allTiles.length; i++) {
            allTiles[i] = new Tile();

        }
    }

    public void initializeSolidness() {
        allTiles[0].isSolid = true;
        allTiles[1].isSolid = true;
        allTiles[2].isSolid = false;
        allTiles[3].isSolid = true;

    }

    public void initializeImages() {
        try {
            // Use getResource() instead of getResourceAsStream()
            allTiles[0].tileImage = ImageIO.read(getClass().getClassLoader().getResource("grass.png"));
            allTiles[1].tileImage = ImageIO.read(getClass().getClassLoader().getResource("ground.png"));
            allTiles[2].tileImage = ImageIO.read(getClass().getClassLoader().getResource("sky.png"));
            allTiles[3].tileImage = ImageIO.read(getClass().getClassLoader().getResource("wood.png"));

            // Verify images loaded
            if (allTiles[0].tileImage == null) {
                System.out.println("grass is null");
            }
            if (allTiles[1].tileImage == null) {
                System.out.println("ground is null");
            }
            if (allTiles[2].tileImage == null) {
                System.out.println("sky is null");
            }
            if (allTiles[3].tileImage == null) {
                System.out.println("wood is null");
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}

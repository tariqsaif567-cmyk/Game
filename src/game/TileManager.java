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

    public void draw(Graphics2D gd, Camera camera) {
    // Calculate which tiles are visible
    int startCol = camera.x / gameFrame.TileSize;
    int endCol = (camera.x + gameFrame.ScreenWidth) / gameFrame.TileSize + 1;
    int startRow = camera.y / gameFrame.TileSize;
    int endRow = (camera.y + gameFrame.ScreenHeight) / gameFrame.TileSize + 1;
    
    // Clamp to world bounds
    startCol = Math.max(0, Math.min(startCol, gameFrame.WorldCol));
    endCol = Math.max(0, Math.min(endCol, gameFrame.WorldCol));
    startRow = Math.max(0, Math.min(startRow, gameFrame.WorldRows));
    endRow = Math.max(0, Math.min(endRow, gameFrame.WorldRows));
    
    // Draw only visible tiles
    for (int row = startRow; row < endRow; row++) {
        for (int col = startCol; col < endCol; col++) {
            // Calculate screen position
            int screenX = col * gameFrame.TileSize - camera.x;
            int screenY = row * gameFrame.TileSize - camera.y;
            
            // Determine which tile to draw based on your existing logic
            if (row == 5 && col > 10 && col < 21) {
                gd.drawImage(allTiles[3].tileImage, screenX, screenY, 
                            gameFrame.TileSize, gameFrame.TileSize, null);
            } else if (row < 7) {
                gd.drawImage(allTiles[2].tileImage, screenX, screenY, 
                            gameFrame.TileSize, gameFrame.TileSize, null);
            } else if (row == 7) {
                gd.drawImage(allTiles[0].tileImage, screenX, screenY, 
                            gameFrame.TileSize, gameFrame.TileSize, null);
            } else {
                gd.drawImage(allTiles[1].tileImage, screenX, screenY, 
                            gameFrame.TileSize, gameFrame.TileSize, null);
            }
        }
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

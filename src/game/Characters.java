package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Characters implements KeyListener {

    public final int XSPEED = 6;

    public int playerX;
    public int playerY;
    public Image playerImage;
    public GamePanel gp;
    public final int YSPEED;
    public boolean leftPressed, rightPressed, upPressed, downPressed;

    public Characters(int playerX, int playerY, Image playerImage, GamePanel gp) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerImage = playerImage;
        this.gp = gp;
        YSPEED = 12;

    }

    public void move() {
        // Store old position
        int oldX = playerX;
        int oldY = playerY;

        // Move in WORLD coordinates
        if (leftPressed) {
            playerX -= XSPEED;
        }
        if (rightPressed) {
            playerX += XSPEED;
        }
        if (upPressed) {
            playerY -= YSPEED;
        }
        if (downPressed) {
            playerY += YSPEED;
        }

        // Keep player within world bounds
        playerX = Math.max(0, Math.min(playerX, gp.gameFrame.GameWidth - gp.gameFrame.TileSize));
        playerY = Math.max(0, Math.min(playerY, gp.gameFrame.GameHeight - gp.gameFrame.TileSize));
    }

    public void draw(Graphics2D gd, Camera camera) {
//        gd.drawImage(playerImage, playerX, playerY, gp.gameFrame.TileSize, gp.gameFrame.TileSize, gp);

// Convert world position to screen position
        int screenX = camera.worldToScreenX(playerX);
        int screenY = camera.worldToScreenY(playerY);

        // Draw player (if image exists, otherwise draw a colored square)
        if (playerImage != null) {
            gd.drawImage(playerImage, screenX, screenY,
                    gp.gameFrame.TileSize, gp.gameFrame.TileSize, gp);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (key == KeyEvent.VK_UP) {
            upPressed = true;
        }

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (key == KeyEvent.VK_UP) {
            upPressed = false;
            if (playerY != gp.gameFrame.TileSize * 6) {
                playerY = gp.gameFrame.TileSize * 6;
            }
        }

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

}

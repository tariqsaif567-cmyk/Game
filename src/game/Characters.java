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
        YSPEED = gp.gameFrame.TileSize;
        

    }

    public void move() {
        if (leftPressed && playerX - XSPEED >= 0) {
            playerX -= XSPEED;
        }
        if (rightPressed && playerX + XSPEED <= gp.gameFrame.GameWidth - gp.gameFrame.TileSize) {
            playerX += XSPEED;
        }
        if (upPressed && playerY >= gp.gameFrame.TileSize * 6 - YSPEED) {
            playerY -= YSPEED;
        }
//        if (downPressed) {
//            playerY += SPEED;
//        }
    }

    public void draw(Graphics2D gd) {
        gd.drawImage(playerImage, playerX, playerY, gp.gameFrame.TileSize, gp.gameFrame.TileSize, gp);
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

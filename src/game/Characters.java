package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Characters implements KeyListener {

    public final int SPEED = 6;
    public int playerX;
    public int playerY;
    public Image playerImage;
    public GamePanel gp;
    public boolean leftPressed, rightPressed, upPressed, downPressed;

    public Characters(int playerX, int playerY, Image playerImage, GamePanel gp) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerImage = playerImage;
        this.gp = gp;
       
    }

    public void move() {
        if (leftPressed) {
            playerX -= SPEED;
        }
        if (rightPressed) {
            playerX += SPEED;
        }
//        if (upPressed) {
//            playerY -= SPEED;
//        }
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
        }

        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

}

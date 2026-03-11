package game;

public class Camera {

    public int x;
    public int y;

    public int screenWidth;
    public int screenHeight;
    public int worldWidth;
    public int worldHeight;

    public Camera() {
    }

    public Camera(int screenWidth, int screenHeight, int worldWidth, int worldHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;

        x = 0;
        y = 0;
    }

    public void center(int targetX, int targetY) {

        x = targetX - screenWidth / 2;
        y = targetY - screenHeight / 2;

        clamp();
    }

    public void clamp() {
        if (x < 0) {
            x = 0;
        }
        if (x > worldWidth - screenWidth) {
            x = worldWidth - screenWidth;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > worldHeight - screenHeight) {
            y = worldHeight - screenHeight;
        }
    }

    public int worldToScreenX(int worldX) {
        return worldX - x;
    }

    public int worldToScreenY(int worldY) {
        return worldY - y;
    }

}

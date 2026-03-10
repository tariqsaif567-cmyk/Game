package game;

import java.awt.Image;

public class Tile {

    public Image tileImage;
    public boolean isSolid;

    public Tile() {
        tileImage = null;
        isSolid = false;
    }

    public Tile(Image tileImage, boolean isSolid) {
        this.tileImage = tileImage;
        this.isSolid = isSolid;
    }

}

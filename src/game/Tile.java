package game;

import java.awt.Image;

public class Tile {

    public Image tileImage;
    public boolean isSolid;

    public Tile() {
    }
    
    

    public Tile(Image tileImage, boolean isSolid) {
        this.tileImage = tileImage;
        this.isSolid = isSolid;
    }

}

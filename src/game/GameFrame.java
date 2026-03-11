package game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public final int OrignalTileSize = 16;
    public final int Scale = 3;
    public final int TileSize = OrignalTileSize * Scale;
    
    public final int WorldCol = 200;
    public final int WorldRows = 12;
    public final int GameWidth = TileSize * WorldCol;
    public final int GameHeight = TileSize * WorldRows;
    
    public final int Col = 24;
    public final int Rows = 12;
    public final int ScreenWidth = TileSize * Col;
    public final int ScreenHeight = TileSize * Rows;

    public GameFrame() {

        GamePanel gamePanel = new GamePanel(this);
        this.add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(null);
        this.pack();
        this.setVisible(true);
    }

}

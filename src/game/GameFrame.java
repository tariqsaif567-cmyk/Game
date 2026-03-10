package game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public final int OrignalTileSize = 16;
    public final int Scale = 3;
    public final int TileSize = OrignalTileSize * Scale;
    public final int GameWidth = TileSize * 24;
    public final int GameHeight = TileSize * 12;

    public GameFrame() {
        this.setPreferredSize(new Dimension(GameWidth, GameHeight));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel(this);

        this.add(gamePanel);
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
    }

}

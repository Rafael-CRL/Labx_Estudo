package TesouroGame;

import javax.swing.*;
import java.awt.*;

import static TesouroGame.GameConstants.TILE_SIZE;

public class GameScreen extends JPanel {
    private MainFrame parent;

    public GameScreen(MainFrame parent){
        this.parent = parent;
        setBackground(Color.black);
    }

    public void paintComponent(Graphics g){

        int centerY = (getHeight() - TILE_SIZE)/2;
        int centerX = (getWidth() - TILE_SIZE)/2;

        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillRect(centerX, centerY , TILE_SIZE, TILE_SIZE);
    }


}
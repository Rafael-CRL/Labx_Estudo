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
        Player jogador = new Player(315, 315, Color.cyan);
        //Treasure tesouro = new Treasure(350, 350, Color.yellow);

        int centerY = (getHeight() - jogador.size)/2;
        int centerX = (getWidth() - jogador.size)/2;

        super.paintComponent(g);
        //g.setColor(tesouro.color);
        //g.fillRect();
        g.setColor(jogador.color);
        g.fillRect(jogador.x, jogador.y, jogador.size, jogador.size);
    }

}
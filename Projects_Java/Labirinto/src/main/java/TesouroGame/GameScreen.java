package TesouroGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameScreen extends JPanel {
    private MainFrame parent;
    private GameBoard gameBoard;

    public GameScreen(MainFrame parent){
        this.parent = parent;
        this.gameBoard = new GameBoard();
        setBackground(Color.black);
        setFocusable(true);
        move();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        startPaint(g);
    }

    public void startPaint(Graphics g){
        Treasure treasure = gameBoard.getTesouro();
        g.setColor(treasure.getColor());
        g.fillRect(treasure.getX(), treasure.getY(), treasure.getSize(), treasure.getSize());

        Player player = gameBoard.getJogador();

        g.setColor(player.color);
        g.fillRect(player.getX(), player.getY(), player.getSize(), player.getSize());
    }

    public void move(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                gameBoard.inputPlayer(keyCode);
                repaint();
            }
        });
    }
}
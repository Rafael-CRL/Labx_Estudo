package TesouroGame.View;

import TesouroGame.Control.GameBoard;
import TesouroGame.Model.Obstacle;
import TesouroGame.Model.Player;
import TesouroGame.Model.Treasure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameScreen extends JPanel {
    private MainFrame parent;
    private GameBoard gameBoard;

    public GameScreen(MainFrame parent){
        this.parent = parent;
        this.gameBoard = new GameBoard();
        setBackground(Color.white);
        setFocusable(true);
        startKeyBinds();
    }
   /* public void addNotify(){
        super.addNotify();
        requestFocusInWindow();
    }*/

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        startPaint(g);
        drawLines(g);
    }

    public void startPaint(Graphics g){
        Treasure treasure = gameBoard.getTesouro();
        g.setColor(treasure.getColor());
        g.fillRect(treasure.getX(), treasure.getY(), treasure.getSize(), treasure.getSize());

        Player player = gameBoard.getJogador();

        g.setColor(player.getColor());
        g.fillRect(player.getX(), player.getY(), player.getSize(), player.getSize());

        Obstacle obstacle = gameBoard.getObstaculo();

        g.setColor(obstacle.getColor());
        g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getSize(), obstacle.getSize());
    }
//descontinuado
   /* public void move(){
     v   addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                gameBoard.inputPlayer(keyCode);
                repaint();
            }
        });
    }*/
    
    public void drawLines(Graphics g){
        g.setColor(Color.black);
        for (int i = 0; i < 700; i+=35){
            g.drawLine(i, 0, i, 700);
            g.drawLine(0, i, 700, i);
        }
    }


    public void startKeyBinds(){
        InputMap mapaEntrada = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaAção = getActionMap();

        mapaEntrada.put(KeyStroke.getKeyStroke("W"),"cima");
        mapaEntrada.put(KeyStroke.getKeyStroke("S"),"baixo");
        mapaEntrada.put(KeyStroke.getKeyStroke("D"),"direita");
        mapaEntrada.put(KeyStroke.getKeyStroke("A"),"esquerda");

        mapaAção.put("cima", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameBoard.inputPlayer(KeyEvent.VK_W);
                repaint();
            }
        });

        mapaAção.put("baixo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameBoard.inputPlayer(KeyEvent.VK_S);
                repaint();
            }
        });

        mapaAção.put("direita", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameBoard.inputPlayer(KeyEvent.VK_D);
                repaint();
            }
        });

        mapaAção.put("esquerda", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameBoard.inputPlayer(KeyEvent.VK_A);
                repaint();
            }
        });

    }

}
package TesouroGame.View;

import TesouroGame.Control.GameBoard;
import TesouroGame.Model.Obstacle;
import TesouroGame.Model.Player;
import TesouroGame.Model.Treasure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static TesouroGame.Model.GameConstants.*;

public class GameScreen extends JPanel {
    private MainFrame parent;
    private GameBoard gameBoard;
    private JPanel pausePane = new JPanel();
    private boolean pause = false;

    public GameScreen(MainFrame parent){
        this.parent = parent;
        this.gameBoard = new GameBoard();
        setBackground(Color.white);
        setFocusable(true);
        startKeyBinds();
        add(pausePane);
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
        mapaEntrada.put(KeyStroke.getKeyStroke("ESCAPE"),"pause");

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

        mapaAção.put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pause = true;
                pausePaneConfig();
                repaint();
            }
        });



    }
    private void pausePaneConfig(){
        JButton sair = styleButton("Sair");;
        JButton continuar = styleButton("Continuar");

       pausePane.setVisible(false);
        pausePane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 300));
        pausePane.add(sair);
        pausePane.add(continuar);

        pausePane.setLayout(new FlowLayout());

        if(pause)
            pausePane.setVisible(true);

    }
    private JButton styleButton(String texto){
        JButton button = new JButton(texto);
        button.setFont(TYPE_FONT);
        button.setBackground(BACKGROUND);
        button.setForeground(TEXT_COLOR);
        button.setPreferredSize(BUTTON_SIZE);

        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TEXT_COLOR, 2, true),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(TEXT_COLOR);
                button.setForeground(BACKGROUND);
            }


            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BACKGROUND);
                button.setForeground(TEXT_COLOR);
            }
        });
        return button;
    }

}
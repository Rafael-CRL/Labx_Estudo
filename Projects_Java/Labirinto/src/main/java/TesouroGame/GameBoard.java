package TesouroGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameBoard {
    private Treasure tesouro;
    private Player jogador;
    
    public GameBoard(){
        startEntity();
    }

    private void startEntity() {
        int startX = 315;
        int startY = 315;

        jogador = new Player(startX, startY, Color.cyan );

        tesouro =  new Treasure(Color.orange);
    }

    public Player getJogador() {
        return jogador;
    }

    public Treasure getTesouro() {
        return tesouro;
    }

    public void inputPlayer(int keyCode){
        int speed = 5;
        switch(keyCode){
            case KeyEvent.VK_W -> movePlayer(0, -speed); //cima
            case KeyEvent.VK_S -> movePlayer(0, speed); //baixo
            case KeyEvent.VK_D -> movePlayer(speed, 0); //direita
            case KeyEvent.VK_A -> movePlayer(-speed, 0); //esquerda
        };
    }

    private void movePlayer(int dX, int dY) {
        int newX = jogador.getX() + dX;
        int newY = jogador.getY() + dY;

        if (newX <= 670 && newX > 0) jogador.setX(newX);
        if (newY <= 670 && newY > 0) jogador.setY(newY);
    }
}

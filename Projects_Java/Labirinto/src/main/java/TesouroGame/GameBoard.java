package TesouroGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static TesouroGame.GameConstants.FRAME_SIZE;
import static TesouroGame.GameConstants.TILE_SIZE;

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
        int speed = 35;
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

        int maxPosition = FRAME_SIZE.width - TILE_SIZE;

        if (newX >= 0 && newX <= maxPosition) jogador.setX(newX);
        if (newY >= 0 && newY <= maxPosition) jogador.setY(newY);
    }

    private boolean treasureColision(){
        if(jogador.getX() == tesouro.getX() && jogador.getY() == tesouro.getY())
            return true;
        return false;
    }
}

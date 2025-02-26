package TesouroGame.Control;

import TesouroGame.Model.Obstacle;
import TesouroGame.Model.Player;
import TesouroGame.Model.Treasure;

import java.awt.*;
import java.awt.event.KeyEvent;

import static TesouroGame.Model.GameConstants.FRAME_SIZE;
import static TesouroGame.Model.GameConstants.TILE_SIZE;

public class GameBoard {
    private Treasure tesouro;
    private Player jogador;
    private Obstacle obstaculo;
    
    public GameBoard(){
        startEntity();
    }

    private void startEntity() {
        int startX = 315;
        int startY = 315;

        jogador = new Player(startX, startY, Color.darkGray );

        tesouro =  new Treasure(Color.BLACK);

        obstaculo = new Obstacle(70, 70, Color.blue);
    }

    public Player getJogador() {
        return jogador;
    }

    public Treasure getTesouro() {
        return tesouro;
    }

    public Obstacle getObstaculo(){return obstaculo;}

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

        boolean atTheLimit = newX >= 0 && newX <= maxPosition && newY >= 0 && newY <= maxPosition;

        boolean treasureFound = checkTreasureColision(newX, newY);
        boolean check = checkColision(newX, newY);

        if (!check && atTheLimit) {
            jogador.setX(newX);
            jogador.setY(newY);
            if(treasureFound)
                System.out.println("Tesouro encontrado");
        }else{
            System.out.println("Não é possível se movimentar");
        }
    }

    private boolean checkColision(int newX, int newY){
        return newX == obstaculo.getX() && newY == obstaculo.getY();
    }

    private boolean checkTreasureColision(int newX, int newY){
        return  newX == tesouro.getX() && newY == tesouro.getY();
    }
}
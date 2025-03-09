package TesouroGame.Control;

import TesouroGame.Model.Entity;
import TesouroGame.Model.Obstacle;
import TesouroGame.Model.Player;
import TesouroGame.Model.Treasure;

import java.awt.*;
import java.awt.event.KeyEvent;

import static TesouroGame.Model.GameConstants.*;

public class GameBoard {

    private Entity[][] matrix = new Entity[ROW][COl];
    private Treasure tesouro;
    private Player jogador;
    private Obstacle obstaculo;

    public GameBoard(){
        startEntity();
    }

    private void startEntity() {
        int startRow = 9;
        int startCol = 9;

        jogador = new Player(startRow, startCol, Color.darkGray );
        tesouro =  new Treasure(Color.BLACK);
        obstaculo = new Obstacle(2, 2, Color.blue);

        addMAtrix(jogador);
        addMAtrix(tesouro);
        addMAtrix(obstaculo);

    }

    private void addMAtrix(Entity entidade){
        matrix[entidade.getRow()][entidade.getCol()] = entidade;
    }

    public void matrixMovePlayer(Entity entity, int newRow, int newCol){
       matrix[entity.getRow()][entity.getCol()] = null;
       matrix[newRow][newCol] = entity;
       entity.setPosition(newRow, newCol);
    }


    public void inputPlayer(int keyCode){
        int newRow = jogador.getRow();
        int newCol = jogador.getCol();

        switch(keyCode){
            case KeyEvent.VK_W -> newCol--;//cima
            case KeyEvent.VK_S -> newCol++;//baixo
            case KeyEvent.VK_D -> newRow++;//direita
            case KeyEvent.VK_A -> newRow--;//esquerda
        };


        boolean atTheLimit = newRow >= 0 && newRow < ROW && newCol >= 0 && newCol < COl;

        if(atTheLimit){
           Entity newPosition = matrix[newRow][newCol];
           if(newPosition == null){
              matrixMovePlayer(jogador, newRow, newCol);
           }
           else if(newPosition == tesouro){
               System.out.println("Parabéns você encontrou o tesouro");
               matrixMovePlayer(jogador, newRow, newCol);
           }
           else if(newPosition == obstaculo){
               System.out.println("não é possível se mover, obstáculo na frente");
           }

        }else{
            System.out.println("Você está fora dos limites");
        }



    }

    public Entity[][] getMatrix() {
        return matrix;
    }

    public Player getJogador() {
        return jogador;
    }

    public Treasure getTesouro() {
        return tesouro;
    }

    public Obstacle getObstaculo(){return obstaculo;}
}
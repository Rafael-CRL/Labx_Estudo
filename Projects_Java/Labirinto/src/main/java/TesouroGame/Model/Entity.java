package TesouroGame.Model;

import java.awt.*;

import static TesouroGame.Model.GameConstants.TILE_SIZE;

public abstract class Entity {
    protected int x, y;
    protected int row, col;
    protected Color color;
    protected int size = 35;

    public Entity(int row, int col, Color color){
        this.color = color;
        setPosition(row, col);
    }


    public int getX() {return x;}
    public int getY() {return y;}

    public int getRow() {return row;}
    public int getCol() {return col;}

    public int getSize() {return size;}
    public Color getColor(){return color;}



    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setPosition(int row, int col){
        this.row = row;
        this.col = col;

        this.x = row * TILE_SIZE;
        this.y = col * TILE_SIZE;
    }
}
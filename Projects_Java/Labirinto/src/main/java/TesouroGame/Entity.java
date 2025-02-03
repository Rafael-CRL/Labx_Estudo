package TesouroGame;

import java.awt.*;

public abstract class Entity {
    protected int x, y;
    protected Color color;
    protected int size = 35;

    public Entity(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getSize() {return size;}
    public Color getColor(){return color;}


}
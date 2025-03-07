package TesouroGame.Model;

import java.awt.*;
import java.util.Random;

public class Treasure extends Entity {
    public static final Random randomXY = new Random();

    public Treasure(Color color){
        super(randomXY.nextInt(20), randomXY.nextInt(20), color) ;
    }

    public Treasure(int row, int col, Color color){
        super(row, col, color);
    }
}
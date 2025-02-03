package TesouroGame;

import java.awt.*;
import java.util.Random;

public class Treasure extends Entity{
    Random random = new Random();

    public Treasure(int x, int y, Color color){
        super(x, y, color);
    }
}

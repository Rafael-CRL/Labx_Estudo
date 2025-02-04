package TesouroGame;

import java.awt.*;
import java.util.Random;

public class Treasure extends Entity{
    public static final Random randomXY = new Random();

    public Treasure(Color color){
        super(randomXY.nextInt(671), randomXY.nextInt(671), color );
    }
}
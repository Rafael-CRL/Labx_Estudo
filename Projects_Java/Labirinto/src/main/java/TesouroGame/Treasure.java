package TesouroGame;

import java.awt.*;
import java.util.Random;

public class Treasure extends Entity{
    public static final Random randomXY = new Random();

    public Treasure(Color color){
        super(randomXY.nextInt((20) * 35), randomXY.nextInt((20) * 35), color );
    }
}
package TesouroGame;

import TesouroGame.View.MainFrame;

import javax.swing.*;

import static TesouroGame.Model.Treasure.randomXY;

public class Main {
    public static void main(String[] args){
        //SwingUtilities.invokeLater(HomeScreen::new);
        SwingUtilities.invokeLater(() -> new MainFrame());

        int x1 = randomXY.nextInt(20) * 35;
        int x2 = randomXY.nextInt(20) * 35;

        System.out.println(x1 +" "+ x2);

    }
}
package TesouroGame;

import TesouroGame.Control.LevelManager;
import TesouroGame.Model.LevelStatus;
import TesouroGame.View.MainFrame;

import javax.swing.*;

import static TesouroGame.Model.Treasure.randomXY;

public class Main {
    public static void main(String[] args){
        //SwingUtilities.invokeLater(HomeScreen::new);
        SwingUtilities.invokeLater(() -> new MainFrame());

        LevelManager levelManager = new LevelManager();
        LevelStatus levelStatus = levelManager.getLevelStatus();

        System.out.println(levelStatus);

    }
}
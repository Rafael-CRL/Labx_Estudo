package TesouroGame;


import javax.swing.*;

public class GameScreen  {
    private JFrame gameWindow;

    public void startGameScreen(boolean b) {
        gameWindow = new JFrame("LabirintoGame");
        gameWindow.setVisible(b);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void configGameScreen(){
        gameWindow.setSize(700, 700);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setResizable(false);
    }
}
package TesouroGame;


import javax.swing.*;

public class GameScreen  {
    private JFrame gameWindow;

    public GameScreen(){
        startGameScreen();
        configGameScreen();
    }
    private void startGameScreen() {
        gameWindow = new JFrame();
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void configGameScreen(){
        gameWindow.setSize(700, 700);
        gameWindow.setTitle("Tesouro Game");
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setResizable(false);
    }
}
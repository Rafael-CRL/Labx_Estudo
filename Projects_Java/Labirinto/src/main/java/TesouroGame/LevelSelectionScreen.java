package TesouroGame;

import javax.swing.*;

public class LevelSelectionScreen {

    private JPanel panel;
    private JFrame levelSelection;

    public LevelSelectionScreen(){
        startSelectionScreen();
        configSelectionScreen();
    }

    private void startSelectionScreen() {
        levelSelection = new JFrame();
        levelSelection.setVisible(true);
        levelSelection.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void configSelectionScreen(){
        levelSelection.setSize(700, 700);
        levelSelection.setTitle("Seleção de Fase");
        levelSelection.setLocationRelativeTo(null);
        levelSelection.setResizable(false);
    }
}

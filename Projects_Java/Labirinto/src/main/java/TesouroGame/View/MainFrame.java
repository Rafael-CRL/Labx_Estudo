package TesouroGame.View;

import javax.swing.*;
import java.awt.*;

import static TesouroGame.Model.GameConstants.FRAME_SIZE;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame(){
        setTitle("Tesouro Game");
        setPreferredSize(FRAME_SIZE);
        //setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        //requestFocusInWindow();

        cardLayout = new CardLayout();
        mainPanel = new JPanel((cardLayout));

        mainPanel.add(new HomeScreen(this), "HomeScreen");
        mainPanel.add(new GameScreen(this), "GameScreen");
        mainPanel.add(new LevelSelectionScreen(this), "LevelSelection");

        add(mainPanel);

        cardLayout.show(mainPanel, "HomeScreen");
        setVisible(true);
    }

    public void switchPanel(String screenName){
        cardLayout.show(mainPanel, screenName);
    }
}

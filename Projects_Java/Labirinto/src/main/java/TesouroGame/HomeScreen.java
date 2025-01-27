package TesouroGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static TesouroGame.GameConstants.*;

public class HomeScreen extends JFrame {

    private JFrame window;
    private JPanel mainPane;

    public HomeScreen() {
        startWindow();
        startPanel();
        addButton();
        configWindow();
    }

    private void startWindow(){
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void startPanel(){
        mainPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 300));
    }
    private JButton styleButton(String texto){
        JButton button = new JButton(texto);
        button.setFont(TYPE_FONT);
        button.setBackground(BACKGROUND);
        button.setForeground(TEXT_COLOR);
        button.setPreferredSize(BUTTON_SIZE);

        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TEXT_COLOR, 2, true),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(TEXT_COLOR);
                button.setForeground(BACKGROUND);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BACKGROUND);
                button.setForeground(TEXT_COLOR);
            }
        });
        return button;
    }

    private void addButton(){
        JButton startButton = styleButton("Iniciar");
        JButton levelButton = styleButton("Escolher Nível");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new GameScreen();
                window.dispose();
            }
        });

        levelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LevelSelectionScreen();
            }
        });

        mainPane.add(levelButton);
        mainPane.add(startButton);

        window.add(mainPane);
    }

    private void configWindow(){
        window.setVisible(true);
        window.setSize(700, 700);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setTitle("Treasure Game");
        //window.setBackground(Color.white);
    }

}

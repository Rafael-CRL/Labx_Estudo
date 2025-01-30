package TesouroGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static TesouroGame.GameConstants.*;

public class HomeScreen extends JPanel {

    private MainFrame parent;

    public HomeScreen(MainFrame parent) {
        this.parent = parent;
        setLayout(new FlowLayout(FlowLayout.CENTER, 50,300));

        JButton startButton = styleButton("Iniciar");
        JButton levelButton = styleButton("Escolher Nível");

        startButton.addActionListener(e -> parent.switchPanel("GameScreen"));
        levelButton.addActionListener(e -> parent.switchPanel("LevelSelection"));

        add(startButton);
        add(levelButton);

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


    }

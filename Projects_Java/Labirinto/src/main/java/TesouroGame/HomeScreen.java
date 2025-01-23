package TesouroGame;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    public HomeScreen() {
        SetupWindow();
        SetupPanel();

    }

    private void SetupWindow(){

        setVisible(true);
        setSize(700, 700);
        setTitle("TesouroGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

    }

    private void SetupPanel(){

        JButton jButton = new JButton("Clique aqui");
        jButton.setFont(new Font("Arial", Font.BOLD, 25 ));
        jButton.setForeground(new Color(86, 134, 65));
        jButton.setBackground(new Color(223, 208, 248));
        add(jButton, BorderLayout.CENTER);
    }
}

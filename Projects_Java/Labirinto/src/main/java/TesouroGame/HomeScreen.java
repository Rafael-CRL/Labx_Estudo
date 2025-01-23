package TesouroGame;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {

    private static final Dimension BUTTON_SIZE = new Dimension(150, 50);
    private static final Font TYPE_FONT = new Font("Roboto", Font.BOLD, 12);
    private static final Color BACKGROUND =  new Color(59, 30, 84);
    private static final Color TEXT_COLOR = new Color(212, 190, 228);

    private JFrame window;
    private JPanel mainPane;

    public HomeScreen() {
        startWindow();
        startPanel();
        addButton();
        configWindow();
    }

    private void startWindow(){
        window = new JFrame("Tesouro Game");
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

        return button;
    }

    private void addButton(){
        mainPane.add(styleButton("Iniciar"));
        mainPane.add(styleButton("Escolher Nível"));

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

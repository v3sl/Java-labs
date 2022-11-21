import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab8_2Panel extends JPanel {
    private static final int MARGIN = 10;
    private static final int NUMBER_OF_ROWS = 4;
    private static final int NUMBER_OF_COLUMNS = 5;
    private static final String DEFAULT_FONT_NAME = "Courier";
    private static final int DEFAULT_FONT_SIZE = 10;
    private static final int DEFAULT_FONT_STYLE = Font.PLAIN;
    private static final int DEFAULT_BUTTON_WIDTH = 100;
    private static final int DEFAULT_BUTTON_HEIGHT = 100;

    public Lab8_2Panel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        mainPanel.setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
        for (int i = 0; i < NUMBER_OF_ROWS * NUMBER_OF_COLUMNS; ++i) {
            JButton button = new JButton(Integer.toString(i + 1));
            button.setPreferredSize(new Dimension(DEFAULT_BUTTON_WIDTH,DEFAULT_BUTTON_HEIGHT));
            button.setBackground(Color.GREEN);
            button.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE));
            connectButton(button);
            mainPanel.add(button);
        }
        add(mainPanel);
    }

    void connectButton(JButton button) {
        button.addMouseListener(new MouseListener() {
            String text;

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                text = button.getText();
                button.setText("Clicked");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setText(text);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.GREEN);
            }
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab7Frame1 extends JFrame {

    private JPanel mainPanel;
    private JLabel label;
    private JButton button;

    public Lab7Frame1(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        createMainPanel();
        createLabel();
        add(mainPanel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        createButton();
        mainPanel.add(button);
        addListeners();
    }

    private void addListeners() {
        addMouseListener();
        addMouseMotionListener();

    }

    private void addMouseListener() {
        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText(e.getX() + ", " + e.getY());
                button.setLocation((int)(e.getX() - 0.5 * button.getWidth()) , (int)(e.getY() - 0.5 * button.getHeight()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    private void addMouseMotionListener() {
        MouseAdapter mouseDrag = new MouseAdapter() {
            int clickX, clickY;
            @Override
            public void mousePressed(MouseEvent e) {
                if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0) {
                    clickX = e.getX();
                    clickY = e.getY();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0) {
                    int dx = e.getX() - clickX;
                    int dy = e.getY() - clickY;
                    button.setLocation(button.getX() + dx, button.getY() + dy);
                }
                    
            }
        };

        button.addMouseListener(mouseDrag);
        button.addMouseMotionListener(mouseDrag);
    }

    private void createButton() {
        button = new JButton("tut mojet bit' vasha reklama");
        button.setBounds(100, 100, 300, 100);
        button.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    button.setText(button.getText().substring(0, button.getText().length() - 1));
                    return;
                }
                if (Character.isDefined(e.getKeyChar())) {
                    button.setText(button.getText() + e.getKeyChar());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
    }

    public void createLabel() {
        label = new JLabel("Click or drag your mouse to get coords");
        label.setBorder(BorderFactory.createTitledBorder("coords"));
        label.setSize(500, 500);

    }

}
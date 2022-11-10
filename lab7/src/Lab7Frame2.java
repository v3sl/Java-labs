import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Lab7Frame2 extends JFrame{

    JButton yesButton;
    JButton noButton;
    JLabel question;
    public Lab7Frame2(String title) throws HeadlessException {
        super(title);
        yesButton = new JButton("yes");
        noButton = new JButton("no");
        question = new JLabel("Do you like your stipuha?");
        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        question.setBounds(175, 50, 150,50);
        yesButton.setBounds(190,100 , 60, 20);
        noButton.setBounds(250,100 , 60, 20);
        add(question);
        add(yesButton);
        add(noButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        noButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random generator = new Random();
                noButton.setLocation(generator.nextInt(getWidth() - 150), generator.nextInt(getHeight() - 150));
            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        yesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Lab7Frame2.this, "ok");
            }

        });
    }
}
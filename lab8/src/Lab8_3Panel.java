import javax.swing.*;
import java.awt.*;

public class Lab8_3Panel extends JPanel {
        private static final int MARGIN = 20;
        private static final ImageIcon firstIcon = new ImageIcon(
                        new ImageIcon("img/1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        private static final ImageIcon secondIcon = new ImageIcon(
                        new ImageIcon("img/2.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        private static final ImageIcon thirdIcon = new ImageIcon(
                        new ImageIcon("img/3.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        private static final ImageIcon fourthIcon = new ImageIcon(
                        new ImageIcon("img/4.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        private static final ImageIcon fifthIcon = new ImageIcon(
                        new ImageIcon("img/5.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        private JPanel mainPanel;
        private JRadioButton firstButton;
        private JRadioButton secondButton;
        private JRadioButton thirdButton;
        private JRadioButton fourthButton;

        public Lab8_3Panel() {
                firstButton = new JRadioButton(firstIcon);
                secondButton = new JRadioButton(firstIcon);
                thirdButton = new JRadioButton(firstIcon);
                fourthButton = new JRadioButton(firstIcon);
                mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
                setButtonIcons(firstButton);
                setButtonIcons(secondButton);
                setButtonIcons(thirdButton);
                setButtonIcons(fourthButton);
                mainPanel.add(firstButton);
                mainPanel.add(secondButton);
                mainPanel.add(thirdButton);
                mainPanel.add(fourthButton);
                add(mainPanel);
        }

        void setButtonIcons(JRadioButton button) {
                button.setSelectedIcon(secondIcon);
                button.setDisabledIcon(thirdIcon);
                button.setPressedIcon(fourthIcon);
                button.setRolloverIcon(fifthIcon);
        }
}
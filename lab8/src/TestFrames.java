import javax.swing.*;
import java.awt.event.*;

public class TestFrames {
    public static void main(String[] args) {
        Object[] first = {1,2,3,"a","b","c"};
        Object[] second = {4,5,6,"d","e","f"};
        JFrame test = new JFrame();
        JTabbedPane componentsPanel = new JTabbedPane();
        test.add(componentsPanel);
        test.setSize(500, 500);
        test.setResizable(false);
        test.setLocationRelativeTo(null);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentsPanel.addTab("first",new Lab8_1Panel(first, second));
        componentsPanel.addTab("second",new Lab8_2Panel());
        componentsPanel.addTab("third",new Lab8_3Panel());
        componentsPanel.setMnemonicAt(0, KeyEvent.VK_1);
        componentsPanel.setMnemonicAt(1, KeyEvent.VK_2);
        componentsPanel.setMnemonicAt(2, KeyEvent.VK_3);
        test.add(componentsPanel);
        test.setVisible(true);
    }
}

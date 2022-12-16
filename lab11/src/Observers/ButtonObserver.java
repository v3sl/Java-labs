package Observers;

import java.awt.event.*;
import javax.swing.JLabel;

public class ButtonObserver extends JLabel implements Observer {

    @Override
    public void update(KeyEvent event) {
        setText(KeyEvent.getKeyText(event.getKeyCode()));
    }
}
package Observers;

import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;

public class LogObserver extends DefaultListModel<String> implements Observer {
    @Override
    public void update(KeyEvent event) {
        addElement(KeyEvent.getKeyText(event.getKeyCode()));
    }
}
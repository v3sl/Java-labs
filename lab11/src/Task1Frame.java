import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;
import Observers.ButtonObserver;
import Observers.LogObserver;
import Subjects.KeySubject;

public class Task1Frame extends JFrame {
    private static final int ROWS = 1;
    private static final int COLS = 2;
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 800;
    private ButtonObserver label = new ButtonObserver();
    private LogObserver model = new LogObserver();
    private JList<String> log = new JList<>();
    private KeySubject subject = new KeySubject();
    private JScrollPane scroll;

    public Task1Frame() {
        setDefaultSettings();
        setLayout(new GridLayout(ROWS, COLS));
        log.setModel(model);
        log.setFocusable(false);
        subject.attach(model);
        subject.attach(label);
        scroll = new JScrollPane(log);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(label);
        add(scroll);
        connect();
    }

    public void connect() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                subject.notifyObservers(e);
            }
        });
    }

    public void setDefaultSettings() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
    }
}
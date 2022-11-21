import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class QueueFrame<T> extends JFrame {
    private JPanel mainPanel;
    private JPanel queueInfoPanel;
    private JLabel sizeLabel;
    private JLabel emptyLabel;
    private JLabel frontElementLabel;
    private JLabel backElementLabel;
    private JPanel queueUtilsPanel;
    private JButton clearButton;
    private JButton pushButton;
    private JButton pushAllButton;
    private JButton popButton;
    private static final int DEFAULT_FONT_SIZE = 40;
    private static final String DEFAULT_FONT_NAME = "Courier";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 200;
    private static final int MARGIN = 20;
    private MyQueue<String> queue = new MyQueue<>();
    private JList<String> list;
    private JScrollPane scroll;
    private JPanel queuePanel;

    public QueueFrame() {
        setDefaultSettings();
        initFields();
        add(mainPanel);
    }

    private void setDefaultSettings() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initFields() {
        sizeLabel = new JLabel("Size: 0");
        emptyLabel = new JLabel("empty");
        frontElementLabel = new JLabel("Front: ");
        backElementLabel = new JLabel("Back: ");
        pushButton = createPushButton();
        clearButton = createClearButton();
        pushAllButton = createPushAllButton();
        popButton = createPopButton();
        list = createQueue();
        scroll = createScroll();
        queueInfoPanel = createQueueInfoPanel();
        queueUtilsPanel = createQueueUtilsPanel();
        queuePanel = createQueuePanel();
        mainPanel = createMainPanel();
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane(list);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }

    private JList<String> createQueue() {
        JList<String> list = new JList<>(queue.toDefaultListModel());
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(1);
        list.setFont(new Font(DEFAULT_FONT_NAME, Font.PLAIN, DEFAULT_FONT_SIZE));
        return list;
    }

    private JPanel createQueueInfoPanel() {
        JPanel queueInfoPanel = new JPanel();
        queueInfoPanel.setLayout(new BoxLayout(queueInfoPanel, BoxLayout.X_AXIS));
        queueInfoPanel.add(sizeLabel);
        queueInfoPanel.add(Box.createHorizontalStrut(MARGIN));
        queueInfoPanel.add(emptyLabel);
        queueInfoPanel.add(Box.createHorizontalStrut(MARGIN));
        queueInfoPanel.add(frontElementLabel);
        queueInfoPanel.add(Box.createHorizontalStrut(MARGIN));
        queueInfoPanel.add(backElementLabel);
        return queueInfoPanel;
    }

    private  JPanel createQueueUtilsPanel() {
        JPanel queueUtilsPanel = new JPanel();
        queueUtilsPanel.setLayout(new BoxLayout(queueUtilsPanel, BoxLayout.X_AXIS));
        queueUtilsPanel.setLayout(new BoxLayout(queueUtilsPanel, BoxLayout.X_AXIS));
        queueUtilsPanel.add(clearButton);
        queueUtilsPanel.add(Box.createHorizontalStrut(MARGIN));
        queueUtilsPanel.add(pushButton);
        queueUtilsPanel.add(Box.createHorizontalStrut(MARGIN));
        queueUtilsPanel.add(pushAllButton);
        queueUtilsPanel.add(Box.createHorizontalStrut(MARGIN));
        queueUtilsPanel.add(popButton);
        return queueUtilsPanel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(queuePanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    private JPanel createQueuePanel() {
        JPanel queuePanel = new JPanel();
        queuePanel.setLayout(new BoxLayout(queuePanel, BoxLayout.Y_AXIS));
        queuePanel.add(queueInfoPanel);
        queuePanel.add(Box.createVerticalStrut(MARGIN));
            queuePanel.add(queueUtilsPanel);
        return queuePanel;
    }

    private JButton createClearButton() {
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.clear();
                list.setModel(queue.toDefaultListModel());
                updateState();
            }
        });
        return clearButton;
    }

    private JButton createPushButton() {
        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = JOptionPane.showInputDialog(
                        QueueFrame.this,
                        "element to push",
                        "Input element:",
                        JOptionPane.QUESTION_MESSAGE);
                queue.push(result);
                list.setModel(queue.toDefaultListModel());
                updateState();
            }
        });
        return pushButton;
    }

    private JButton createPushAllButton() {
        JButton pushAllButton = new JButton("Push all");
        pushAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String delimiter = JOptionPane.showInputDialog(
                        QueueFrame.this,
                        "delimiter",
                        "Input delimiter:",
                        JOptionPane.QUESTION_MESSAGE);
                String result = JOptionPane.showInputDialog(
                        QueueFrame.this,
                        "elements to push",
                        "Input elements using delimiter " + delimiter + " :",
                        JOptionPane.QUESTION_MESSAGE);
                queue.pushAll(Arrays.asList(result.split(delimiter)));
                list.setModel(queue.toDefaultListModel());
                updateState();
            }
        });
        return pushAllButton;
    }

    private JButton createPopButton() {
        popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.pop();
                list.setModel(queue.toDefaultListModel());
                updateState();
            }
        });
        return popButton;
    }

    private void updateState() {
        sizeLabel.setText("Size: " + queue.size());
        emptyLabel.setText(queue.isEmpty() ? "empty" : "not empty");
        frontElementLabel.setText(!queue.isEmpty() ? "Front: " + queue.front() : "Front: ");
        backElementLabel.setText(!queue.isEmpty() ? "Back: " + queue.back() : "Back: ");
    }
}
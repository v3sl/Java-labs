import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ListSelectionModel;

public class Lab8_1Panel extends JPanel {
    private static final int DEFAULT_WINDOW_HEIGHT = 800;
    private static final int MARGIN = 20;
    private static final int DEFAULT_LIST_WIDTH = 200;
    private static final int DEFAULT_BUTTON_HEIGHT = 100;
    private static final String DEFAULT_FONT_NAME = "Courier";
    private static final int DEFAULT_FONT_SIZE = 20;
    private static final int DEFAULT_FONT_STYLE = Font.PLAIN;
    private JList<Object> rightList;
    private DefaultListModel<Object> rightListModel;
    private JList<Object> leftList;
    private DefaultListModel<Object> leftListModel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton topButton;
    private JButton bottomButton;

    Lab8_1Panel(Object[] rightListData, Object[] leftListData) {
        setLayout(new BorderLayout());
        rightListModel = new DefaultListModel<>();
        leftListModel = new DefaultListModel<>();
        rightList = CreateList(rightListModel, rightListData);
        leftList = CreateList(leftListModel, leftListData);
        buttonPanel = createCustomizedPanel();
        connectButtons();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(leftList, BorderLayout.WEST);
        mainPanel.add(rightList, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
    }

    private JButton createCustomizedButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(button.getWidth(), DEFAULT_BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(button.getWidth(), DEFAULT_BUTTON_HEIGHT));
        button.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE));
        return button;
    }

    private JPanel createCustomizedPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        topButton = createCustomizedButton(">");
        bottomButton = createCustomizedButton("<");
        panel.add(topButton, BorderLayout.NORTH);
        panel.add(bottomButton, BorderLayout.SOUTH);
        return panel;
    }

    private JList<Object> CreateList(DefaultListModel<Object> model, Object[] args) {
        JList<Object> list = new JList<>(model);
        for (Object value : args) {
            model.addElement(value);
        }
        list.setPreferredSize(new Dimension(DEFAULT_LIST_WIDTH, DEFAULT_WINDOW_HEIGHT));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        list.setFont(new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE));
        list.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        return list;
    }

    private void connectButtons() {
        topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightListModel.addAll(leftList.getSelectedValuesList());
                int[] indices = leftList.getSelectedIndices();
                for(int i = indices.length - 1; i >= 0; --i) {                          
                    leftListModel.remove(indices[i]);
                }
            }
        });
        bottomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftListModel.addAll(rightList.getSelectedValuesList());
                int[] indices = rightList.getSelectedIndices();
                for(int i = indices.length - 1; i >= 0; --i) {                          
                    rightListModel.remove(indices[i]);
                }
            }
        });
    }
}
package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import strategy.DefaultStrategy;
import strategy.Strategy;
import strategy.StreamStrategy;
import studentInfo.StudentInfo;
import xml.xml_student_info.Info;
import xml.xml_student_info.XMLStudentInfo;
import xml.strategy.DOMStrategy;
import xml.strategy.SAXStrategy;
import xml.strategy.XMLStrategy;
import xml.writers.StudentInfoDOMWriter;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Task3Frame extends JFrame {
    private static final int DEFAULT_HEIGHT = 800;
    private static final int DEFAULT_WIDTH = 1000;
    private ArrayList<StudentInfo> studentInfo = new ArrayList<>();
    private JPanel mainPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem openItem = new JMenuItem("Open");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll;
    private JLabel termInputTitle = new JLabel("Term: ");
    private JTextField termInput = new JTextField();
    private JLabel subjectsInputTitle = new JLabel("Subjects: ");
    private JTextField subjectsInput = new JTextField();
    private JPanel inputPanel = new JPanel();
    private JButton findNecessaryStudentsButton = new JButton("find necessary students");
    private JButton addButton = new JButton("add");
    private Strategy strategy;
    private JRadioButton streamStrategyButton = new JRadioButton("Stream Strategy");
    private JRadioButton defaultStrategyButton = new JRadioButton("Default Strategy");
    private ButtonGroup strategyGroup = new ButtonGroup();
    private JRadioButton domStrategyButton = new JRadioButton("DOM strategy");
    private JRadioButton saxStrategyButton = new JRadioButton("SAX strategy");
    private ButtonGroup xmlStrategyGroup = new ButtonGroup();

    public Task3Frame() {
        setDefaultSettings();
        createInputPanel();
        createMainPanel();
        add(mainPanel);
        createMenu();
        connectButtons();
    }

    private void createInputPanel() {
        addButtonsToGroups();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(streamStrategyButton);
        inputPanel.add(defaultStrategyButton);
        inputPanel.add(termInputTitle);
        inputPanel.add(termInput);
        inputPanel.add(subjectsInputTitle);
        inputPanel.add(subjectsInput);
        inputPanel.add(findNecessaryStudentsButton);
        inputPanel.add(addButton);
        inputPanel.add(domStrategyButton);
        inputPanel.add(saxStrategyButton);
    }

    private void addButtonsToGroups() {
        strategyGroup.add(streamStrategyButton);
        streamStrategyButton.setSelected(true);
        strategyGroup.add(defaultStrategyButton);
        xmlStrategyGroup.add(domStrategyButton);
        domStrategyButton.setSelected(true);
        xmlStrategyGroup.add(saxStrategyButton);
    }

    private void createMainPanel() {
        mainPanel.setLayout(new BorderLayout());
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
    }

    private void createMenu() {
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void connectButtons() {
        connectOpenItem();
        connectSaveItem();
        connectOpenButton();
        connectFindNecessaryStudentsButton();
    }

    private void connectSaveItem() {
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooser = new JFileChooser(".");
                    int result = chooser.showSaveDialog(Task3Frame.this);
                    if (result != JFileChooser.APPROVE_OPTION) {
                        return;
                    }
                    StudentInfoDOMWriter.write(chooser.getSelectedFile(), studentInfo);
                } catch (Exception ex) {
                    return;
                }
            }
        });
    }

    private void connectFindNecessaryStudentsButton() {
        findNecessaryStudentsButton.addActionListener(createActionListenerStream());
    }

    private ActionListener createActionListenerStream() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int term = Integer.parseInt(termInput.getText());
                String[] subjects = subjectsInput.getText().split(" ");
                ArrayList<StudentInfo> temp = new ArrayList<>(studentInfo);
                if (streamStrategyButton.isSelected()) {
                    strategy = new StreamStrategy(term, subjects, temp);
                } else {
                    strategy = new DefaultStrategy(term, subjects, temp);
                }
                strategy.findNecessaryStudents();
                showInfo(temp);
            }
        };
    }

    private void showInfo(ArrayList<StudentInfo> info) {
        JOptionPane.showMessageDialog(Task3Frame.this,
                getInfo(info.stream().sorted(new Comparator<StudentInfo>() {
                    @Override
                    public int compare(StudentInfo o1, StudentInfo o2) {
                        if (o1.getSubject().equals(o2.getSubject())) {
                            return o1.getName().compareTo(o2.getName());
                        }
                        return o1.getSubject().compareTo(o2.getSubject());
                    }
                }).toList()));
    }

    private void connectOpenButton() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = JOptionPane.showInputDialog(Task3Frame.this, "add info: ", "new info",
                        JOptionPane.QUESTION_MESSAGE);
                String[] args = result.split(" ");
                studentInfo.add(new StudentInfo(Integer.parseInt(args[0]), args[1], Integer.parseInt(args[2]), args[3],
                        Integer.parseInt(args[4])));
                textArea.setText(getInfo(studentInfo));
            }
        });
    }

    private void connectOpenItem() {
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    studentInfo.clear();
                    JFileChooser chooser = new JFileChooser(".");
                    int result = chooser.showOpenDialog(Task3Frame.this);
                    if (result != JFileChooser.APPROVE_OPTION) {
                        return;
                    }
                    XMLStrategy strategy;
                    if (domStrategyButton.isSelected()) {
                        textArea.setText("made by DOM\n\n");
                        strategy = new DOMStrategy(chooser.getSelectedFile());
                    } else {
                        textArea.setText("made by SAX\n\n");
                        strategy = new SAXStrategy(chooser.getSelectedFile());
                    }
                    Info resultInfo = strategy.getInfo();
                    List<XMLStudentInfo> xmlStudentInfo = resultInfo.getInfoList();
                    textArea.setText(textArea.getText() + addStudentsAndGetInfo(xmlStudentInfo));
                } catch (Exception ex) {
                    return;
                }
            }
        });
    }

    private void setDefaultSettings() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private String addStudentsAndGetInfo(List<XMLStudentInfo> xmlStudentInfo) {
        String result = "";
        for (XMLStudentInfo info : xmlStudentInfo) {
            String id = normalizeXMLINfo(info.getId());
            String name = normalizeXMLINfo(info.getName());
            String term = normalizeXMLINfo(info.getTerm());
            String subject = normalizeXMLINfo(info.getSubject());
            String mark = normalizeXMLINfo(info.getMark());
            result += id + '\n' + name + '\n' + term + '\n' + subject + '\n' + mark + "\n\n";
            studentInfo.add(new StudentInfo(Integer.parseInt(id), name, Integer.parseInt(term), subject,
                    Integer.parseInt(mark)));
        }
        return result;
    }

    private String normalizeXMLINfo(String info) {
        return info.replaceAll("\s|\n", "");
    }

    private String getInfo(List<StudentInfo> info) {
        String strInfo = "";
        for (StudentInfo i : info) {
            strInfo += i.getId() + " " + i.getName() + " " + i.getTerm() + " " + i.getSubject() + " " + i.getMark()
                    + '\n';
        }
        return strInfo;
    }
}
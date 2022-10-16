import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class SeriesFrame extends JFrame {

    public SeriesFrame(String title) throws HeadlessException {
        super(title);
        firstInit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel radioButtonsPanel = createRadioButtonsPanel();
        JPanel inputPanel = createInputPanel();
        JPanel buttonsPanel = createButtonsPanel();
        JScrollPane textArea = createTextArea();
        JPanel main = new JPanel();
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(radioButtonsPanel);
        main.add(Box.createVerticalStrut(10));
        main.add(inputPanel);
        main.add(Box.createVerticalStrut(10));
        main.add(buttonsPanel);
        main.add(Box.createVerticalStrut(10));
        main.add(textArea);
        add(main);
    }

    private void firstInit() {
        output = new JTextArea();
        series = new Liner();
        inputNumberOfElements = new JTextField();
        inputFirstElement = new JTextField();
        inputStep = new JTextField();
    }

    private JPanel createRadioButtonsPanel() {
        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.X_AXIS));
        ButtonGroup typesOfProgressionGroup = new ButtonGroup();
        radioButtonsPanel.setBorder(BorderFactory.createTitledBorder("Type of progression"));
        JRadioButton linerTypeButton = createLinerTypeButton();
        linerTypeButton.setSelected(true);
        JRadioButton exponentialTypeButton = createExponentialTypeButton();
        radioButtonsPanel.add(Box.createHorizontalStrut(60));
        radioButtonsPanel.add(linerTypeButton);
        typesOfProgressionGroup.add(linerTypeButton);
        radioButtonsPanel.add(Box.createHorizontalStrut(180));
        radioButtonsPanel.add(exponentialTypeButton);
        typesOfProgressionGroup.add(exponentialTypeButton);
        radioButtonsPanel.add(Box.createHorizontalStrut(60));
        radioButtonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        return radioButtonsPanel;
    }

    private JRadioButton createLinerTypeButton() {
        JRadioButton linerTypeButton = new JRadioButton("Liner");
        linerTypeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                series = new Liner();
                output.setText("");
            }
        });
        return linerTypeButton;
    }

    private JRadioButton createExponentialTypeButton() {
        JRadioButton exponentialTypeButton = new JRadioButton("Exponential");
        exponentialTypeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                series = new Exponential();
                output.setText("");
            }
        });
        return exponentialTypeButton;
    }

    private JPanel createNumberOfElementsPanel() {
        JPanel numberOfElementsPanel = new JPanel();
        numberOfElementsPanel.setLayout(new BoxLayout(numberOfElementsPanel, BoxLayout.Y_AXIS));
        numberOfElementsPanel.add(new JLabel("Number of elements"));
        numberOfElementsPanel.add(inputNumberOfElements);
        numberOfElementsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        inputNumberOfElements.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                output.setText("");
            }
        });
        return numberOfElementsPanel;
    }

    private JPanel createFirstElementPanel() {
        JPanel firstElementPanel = new JPanel();
        firstElementPanel.setLayout(new BoxLayout(firstElementPanel, BoxLayout.Y_AXIS));
        firstElementPanel.add(new JLabel("First element"));
        inputFirstElement = new JTextField();
        inputFirstElement.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                output.setText("");
            }
        });
        firstElementPanel.add(inputFirstElement);
        firstElementPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        return firstElementPanel;
    }

    private JPanel createStepPanel() {
        JPanel stepPanel = new JPanel();
        stepPanel.setLayout(new BoxLayout(stepPanel, BoxLayout.Y_AXIS));
        stepPanel.add(new JLabel("Step"));
        inputStep = new JTextField();
        stepPanel.add(inputStep);
        stepPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        inputStep.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                output.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                output.setText("");
            }
        });
        return stepPanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        JPanel numberOfElementsPanel = createNumberOfElementsPanel();
        JPanel firstElementPanel = createFirstElementPanel();
        JPanel stepPanel = createStepPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(numberOfElementsPanel);
        inputPanel.add(Box.createHorizontalStrut(20));
        inputPanel.add(firstElementPanel);
        inputPanel.add(Box.createHorizontalStrut(20));
        inputPanel.add(stepPanel);
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        return inputPanel;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        JButton calculateButton = createCalculateButton();
        JButton saveButton = createSaveButton();
        JButton clearButton = createClearButton();
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(Box.createHorizontalStrut(20));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(Box.createHorizontalStrut(20));
        buttonsPanel.add(clearButton);
        buttonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        return buttonsPanel;
    }

    private JButton createCalculateButton() {
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (updateSeries()) {
                    output.setText(series.toString());
                }
            }
        });
        return calculateButton;
    }

    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save as");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(SeriesFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (updateSeries()) {
                        try {
                            series.writeToFile(file.toString());
                        } catch (IOException exception) {
                            return;
                        }
                    }
                }
            }
        });
        return saveButton;
    }

    private JButton createClearButton() {
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputNumberOfElements.setText("");
                inputFirstElement.setText("");
                inputStep.setText("");
                output.setText("");
            }
        });
        return clearButton;
    }

    private JScrollPane createTextArea() {
        output.setEditable(false);
        output.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }

    private boolean updateSeries() {
        int numberOfElements;
        double firstElement;
        double step;
        try {
            numberOfElements = Integer.parseInt(inputNumberOfElements.getText());
            firstElement = Double.parseDouble(inputFirstElement.getText());
            step = Double.parseDouble(inputStep.getText());
        } catch (Exception exception) {
            return false;
        }
        series.setNumberOfElements(numberOfElements);
        series.setFirstElement(firstElement);
        series.setStep(step);
        return true;
    }

    private JTextField inputNumberOfElements;
    private JTextField inputFirstElement;
    private JTextField inputStep;
    private JTextArea output;
    private Series series;
}
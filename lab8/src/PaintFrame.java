import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.geom.Line2D;

public class PaintFrame extends JFrame {
    private static final int DEFAULT_WINDOW_WIDTH = 800;
    private static final int DEFAULT_WINDOW_HEIGHT = 800;
    private static final int DEFAULT_PAINT_WINDOW_SIZE = 5000;
    private JPanel mainPanel;
    private PaintPanel paintPanel;
    private JPanel buttonsPanel;
    private JButton chooseColorButton;
    private JButton addImageButton;
    private JButton saveImageButton;

    public PaintFrame() {
        setDefaultSetting();
        paintPanel = new PaintPanel();
        paintPanel.setLayout(new BoxLayout(paintPanel, BoxLayout.Y_AXIS));
        paintPanel.setPreferredSize(new Dimension(DEFAULT_PAINT_WINDOW_SIZE, DEFAULT_PAINT_WINDOW_SIZE));
        JScrollPane scrolls = new JScrollPane(paintPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        chooseColorButton = new JButton("choose color");
        addImageButton = new JButton("add image");
        saveImageButton = new JButton("save image");
        connectButtons();
        buttonsPanel = new JPanel();
        buttonsPanel.add(chooseColorButton);
        buttonsPanel.add(addImageButton);
        buttonsPanel.add(saveImageButton);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scrolls, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void connectButtons() {
        connectColorChooseButton();
        connectAddImageButton();
        connectSaveImageButton();
    }

    private void connectColorChooseButton() {
        chooseColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setColor(JColorChooser.showDialog(null, "choose color", null));
            }
        });
    }

    private void connectAddImageButton() {
        addImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(".");
                int result = chooser.showOpenDialog(PaintFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        paintPanel.setImage(ImageIO.read(file));
                    } catch (Exception ex) {
                        return;
                    }
                }
            }
        });
    }

    private void connectSaveImageButton() {
        saveImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new BufferedImage(DEFAULT_PAINT_WINDOW_SIZE, DEFAULT_PAINT_WINDOW_SIZE,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                paintPanel.print(g2d);
                g2d.dispose();
                JFileChooser chooser = new JFileChooser(".");
                int result = chooser.showSaveDialog(PaintFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(image, "png", chooser.getSelectedFile());
                    } catch (IOException e1) {
                        return;
                    }
                }
            }
        });
    }

    private void setDefaultSetting() {
        setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class PaintPanel extends JPanel {
        private List<List<Pair<Point, Color>>> linesWithColor = new ArrayList<>();
        private List<Pair<Point, Color>> currentLineWithColor;
        private Color color;
        private Image image;

        public PaintPanel() {
            MouseAdapter adapter = createMouseAdapter();
            addMouseMotionListener(adapter);
            addMouseListener(adapter);
            color = Color.BLACK;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics = (Graphics2D) g.create();
            if (!Objects.isNull(image)) {
                graphics.drawImage(image, null, null);
            }
            graphics.setColor(color);
            for (List<Pair<Point, Color>> line : linesWithColor) {
                Pair<Point, Color> previous = null;
                for (Pair<Point, Color> point : line) {
                    graphics.setColor(point.second);
                    if (previous != null) {
                        graphics.draw(new Line2D.Float(previous.first, point.first));
                    }
                    previous = point;
                }
            }
            graphics.dispose();
        }

        private MouseAdapter createMouseAdapter() {
            return new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    currentLineWithColor.add(new Pair<Point, Color>(e.getPoint(), color));
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    currentLineWithColor = new ArrayList<>();
                    linesWithColor.add(currentLineWithColor);
                }
            };
        }

        public void setColor(Color color) {
            this.color = color;
        }

        private class Pair<F, S> {
            public final F first;
            public final S second;

            public Pair(F first, S second) {
                this.first = first;
                this.second = second;
            }
        }

        private void setImage(Image image) {
            this.image = image;
            paintComponent(getGraphics());
        }
    }
}
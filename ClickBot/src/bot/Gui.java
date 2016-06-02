package bot;

import bot.DetectionBotEntry;
import bot.EntryInformation;
import bot.LocateButton;
import bot.PeriodicBotEntry;
import bot.StartButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Gui extends JFrame implements ActionListener {
    private final int width = 500;
    private final Dimension standardSize = new Dimension(500, 55);
    private final Dimension bigButton = new Dimension(140, 40);
    private EntryInformation entryInformation;
    private JPanel window;
    private int entries = 0;
    private JFrame abortFrame;
    private JButton pause;
    private JTextArea log;

    public Gui() {
        this.entryInformation = new EntryInformation(this);
        this.window = new JPanel(new FlowLayout());
        this.window.setPreferredSize(new Dimension(500, 60));
        this.add(this.window);
        this.setupAddEntry();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.pack();
    }

    private void setupAddEntry() {
        JPanel container = new JPanel();
        container.setPreferredSize(this.standardSize);
        container.setBorder(BorderFactory.createLineBorder(Color.decode("#4682B4")));
        StartButton startButton = new StartButton(this, this.entryInformation, "Launch");
        startButton.addActionListener(startButton);
        this.styleComponent(startButton);
        JButton addDetectionEntryButton = new JButton("Add Detection Entry");
        addDetectionEntryButton.addActionListener(this);
        this.styleComponent(addDetectionEntryButton);
        JButton addPeriodicEntryButton = new JButton("Add Periodic Entry");
        addPeriodicEntryButton.addActionListener(this);
        this.styleComponent(addPeriodicEntryButton);
        addDetectionEntryButton.setPreferredSize(this.bigButton);
        addPeriodicEntryButton.setPreferredSize(this.bigButton);
        startButton.setPreferredSize(this.bigButton);
        container.add(addDetectionEntryButton);
        container.add(addPeriodicEntryButton);
        container.add(startButton);
        this.window.add(container);
    }

    public void actionPerformed(ActionEvent arg0) {
        JButton button = (JButton)arg0.getSource();
        if (button.getText().equals("Add Periodic Entry")) {
            PeriodicBotEntry justAddedEntry = this.entryInformation.writePeriodicEntry();
            this.addNewPeriodicEntry(justAddedEntry);
        } else {
            DetectionBotEntry justAddedEntry = this.entryInformation.writeDetectionEntry();
            this.addNewDetectionEntry(justAddedEntry);
        }
    }

    private void addNewDetectionEntry(DetectionBotEntry entry) {
        ++this.entries;
        this.window.setPreferredSize(new Dimension(500, 60 + 60 * this.entries));
        JPanel container = new JPanel();
        container.setPreferredSize(this.standardSize);
        container.setBorder(BorderFactory.createLineBorder(Color.decode("#4682B4")));
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(240, 43));
        JTextField xCoord = new JTextField("na");
        xCoord.setPreferredSize(new Dimension(70, 15));
        xCoord.setEnabled(false);
        JTextField yCoord = new JTextField("na");
        yCoord.setPreferredSize(new Dimension(70, 15));
        yCoord.setEnabled(false);
        JTextField xSource = new JTextField("na");
        xSource.setPreferredSize(new Dimension(70, 15));
        xSource.setEnabled(false);
        JTextField ySource = new JTextField("na");
        ySource.setPreferredSize(new Dimension(70, 15));
        ySource.setEnabled(false);
        JTextField keyField = new JTextField("Key");
        keyField.setPreferredSize(new Dimension(70, 25));
        JTextField clicksField = new JTextField("# clicks");
        clicksField.setPreferredSize(new Dimension(70, 25));
        clicksField.setEnabled(false);
        LocateButton locate = new LocateButton(xCoord, yCoord, clicksField, keyField, "Locate");
        locate.setName("Locate");
        locate.addActionListener(locate);
        locate.setPreferredSize(new Dimension(80, 15));
        LocateButton source = new LocateButton(xSource, ySource, "Source");
        source.setName("Source");
        source.addActionListener(source);
        source.setPreferredSize(new Dimension(80, 15));
        left.add(xCoord);
        left.add(yCoord);
        left.add(locate);
        left.add(xSource);
        left.add(ySource);
        left.add(source);
        container.add(left);
        container.add(keyField);
        container.add(clicksField);
        JPanel filler = new JPanel();
        filler.setPreferredSize(new Dimension(70, 10));
        container.add(filler);
        this.window.add(container);
        this.styleComponent(xCoord);
        this.styleComponent(yCoord);
        this.styleComponent(xSource);
        this.styleComponent(ySource);
        this.styleComponent(keyField);
        this.styleComponent(clicksField);
        this.styleComponent(locate);
        this.styleComponent(source);
        entry.setXSource(xSource);
        entry.setYSource(ySource);
        entry.setNbrOfClicksSource(clicksField);
        entry.setKeyTypeSource(keyField);
        entry.setXTargetSource(xCoord);
        entry.setYTargetSource(yCoord);
        this.pack();
    }

    public void addNewPeriodicEntry(PeriodicBotEntry entry) {
        ++this.entries;
        this.window.setPreferredSize(new Dimension(500, 60 + 60 * this.entries));
        JPanel container = new JPanel();
        container.setPreferredSize(this.standardSize);
        container.setBorder(BorderFactory.createLineBorder(Color.decode("#4682B4")));
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(240, 43));
        JTextField xCoord = new JTextField("na");
        xCoord.setPreferredSize(new Dimension(70, 15));
        xCoord.setEnabled(false);
        JTextField yCoord = new JTextField("na");
        yCoord.setPreferredSize(new Dimension(70, 15));
        yCoord.setEnabled(false);
        JTextField keyField = new JTextField("Key");
        keyField.setPreferredSize(new Dimension(70, 25));
        JTextField periodField = new JTextField("Period");
        periodField.setPreferredSize(new Dimension(70, 25));
        JTextField clicksField = new JTextField("# clicks");
        clicksField.setPreferredSize(new Dimension(70, 25));
        clicksField.setEnabled(false);
        LocateButton locate = new LocateButton(xCoord, yCoord, clicksField, keyField, "Locate");
        locate.setName("Locate");
        locate.addActionListener(locate);
        locate.setPreferredSize(new Dimension(80, 15));
        left.add(xCoord);
        left.add(yCoord);
        left.add(locate);
        container.add(left);
        container.add(keyField);
        container.add(clicksField);
        container.add(periodField);
        this.window.add(container);
        this.styleComponent(periodField);
        this.styleComponent(xCoord);
        this.styleComponent(yCoord);
        this.styleComponent(keyField);
        this.styleComponent(clicksField);
        this.styleComponent(locate);
        entry.setPeriodsource(periodField);
        entry.setNbrOfClicksSource(clicksField);
        entry.setKeyTypeSource(keyField);
        entry.setXTargetSource(xCoord);
        entry.setYTargetSource(yCoord);
        this.pack();
    }

    public void showAbort(final EntryInformation entryList) {
        this.abortFrame = new JFrame();
        this.abortFrame.setDefaultCloseOperation(0);
        this.abortFrame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(470, 400));
        JButton terminate = new JButton("Terminate");
        terminate.setFocusable(false);
        terminate.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                entryList.setPauseAll(false);
                entryList.finishAll();
                Gui.this.abortFrame.dispose();
            }
        });
        terminate.setPreferredSize(this.bigButton);
        this.pause = new JButton("Pause");
        this.pause.setFocusable(false);
        this.pause.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                if (!entryList.isPaused()) {
                    Gui.this.pause.setText("Unpause");
                    entryList.setPauseAll(true);
                    Gui.this.log.setEnabled(false);
                } else {
                    Gui.this.pause.setText("Pause");
                    entryList.setPauseAll(false);
                    Gui.this.log.setEnabled(true);
                }
            }

        });
        this.pause.setPreferredSize(this.bigButton);
        this.log = new JTextArea("", 20, 40);
        this.log.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#4682B4")), "Log"));
        this.log.setLineWrap(true);
        this.log.setEditable(false);
        LoggingThread logger = new LoggingThread(log);
        entryList.setLog(logger);
        logger.start();
        JScrollPane logScroll = new JScrollPane(this.log);
        logScroll.setVerticalScrollBarPolicy(22);
        this.styleComponent(terminate);
        this.styleComponent(this.pause);
        this.styleComponent(logScroll);
        this.abortFrame.add(panel);
        panel.add(terminate);
        panel.add(this.pause);
        panel.add(logScroll);
        this.abortFrame.setVisible(true);
        this.abortFrame.pack();
    }

    private void styleComponent(JComponent comp) {
        comp.setBackground(Color.decode("#4682B4"));
        comp.setForeground(Color.decode("#FFFAFA"));
        comp.setBorder(BorderFactory.createEtchedBorder());
    }

}


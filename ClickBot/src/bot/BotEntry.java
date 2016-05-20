package bot;

import bot.EntryInformation;
import javax.swing.JTextField;

public abstract class BotEntry
extends Thread {
    private JTextField xTargetSource;
    private JTextField yTargetSource;
    private JTextField nbrOfClicksSource;
    private EntryInformation monitor;
    private boolean finish;
    private JTextField keyTypeSource;
    private boolean pause;

    public BotEntry(EntryInformation monitor) {
        this.monitor = monitor;
        this.finish = false;
        this.pause = false;
    }

    public void setXTargetSource(JTextField xTargetSource) {
        this.xTargetSource = xTargetSource;
    }

    public void setYTargetSource(JTextField yTargetSource) {
        this.yTargetSource = yTargetSource;
    }

    public void setNbrOfClicksSource(JTextField nbrOfClicksSource) {
        this.nbrOfClicksSource = nbrOfClicksSource;
    }

    public void setKeyTypeSource(JTextField keyField) {
        this.keyTypeSource = keyField;
    }

    public void finish() {
        this.finish = true;
    }

    public void setPause(boolean b) {
        this.pause = b;
    }

    @Override
    public abstract void run();

    public EntryInformation getMonitor() {
        return this.monitor;
    }

    public void setMonitor(EntryInformation monitor) {
        this.monitor = monitor;
    }

    public boolean isFinished() {
        return this.finish;
    }

    public boolean isPaused() {
        return this.pause;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public JTextField getXTargetSource() {
        return this.xTargetSource;
    }

    public JTextField getYTargetSource() {
        return this.yTargetSource;
    }

    public JTextField getNbrOfClicksSource() {
        return this.nbrOfClicksSource;
    }

    public JTextField getKeyTypeSource() {
        return this.keyTypeSource;
    }
}


package bot;

import bot.BotEntry;
import bot.EntryInformation;
import java.awt.Color;
import javax.swing.JTextField;

public class DetectionBotEntry
extends BotEntry
implements Runnable {
    private JTextField ySource;
    private JTextField xSource;

    public DetectionBotEntry(EntryInformation entryInformation) {
        super(entryInformation);
    }

    @Override
    public void run() {
        int x = Integer.valueOf(this.xSource.getText());
        int y = Integer.valueOf(this.ySource.getText());
        Color c = this.getMonitor().establishCondition(x, y);
        if (this.getXTargetSource().getText().equals("na")) {
            this.doKey(x, y, c);
        } else {
            int clicks = Integer.valueOf(this.getNbrOfClicksSource().getText());
            this.doClick(x, y, c, clicks);
        }
    }

    private void doClick(int x, int y, Color c, int clicks) {
        int xTarget = Integer.valueOf(this.getXTargetSource().getText());
        int yTarget = Integer.valueOf(this.getYTargetSource().getText());
        while (!this.isFinished()) {
            if (!this.isPaused() && this.getMonitor().detectedColorChange(x, y, c)) {
                this.getMonitor().moveAndClick(x, y, clicks);
            }
            try {
                DetectionBotEntry.sleep(2000);
                continue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doKey(int x, int y, Color c) {
        String keyType = this.getKeyTypeSource().getText();
        while (!this.isFinished()) {
            if (!this.isPaused() && this.getMonitor().detectedColorChange(x, y, c)) {
                this.getMonitor().pushKey(keyType);
            }
            try {
                DetectionBotEntry.sleep(2000);
                continue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setXSource(JTextField xSource) {
        this.xSource = xSource;
    }

    public void setYSource(JTextField ySource) {
        this.ySource = ySource;
    }
}



package bot;

import bot.BotEntry;
import bot.EntryInformation;
import javax.swing.JTextField;

public class PeriodicBotEntry
extends BotEntry
implements Runnable {
    private JTextField periodsource;

    public PeriodicBotEntry(EntryInformation monitor) {
        super(monitor);
    }

    public void setPeriodsource(JTextField periodsource) {
        this.periodsource = periodsource;
    }

    @Override
    public void run() {
        long period = Integer.valueOf(this.periodsource.getText()).intValue();
        period *= 1000;
        if (this.getXTargetSource().getText().equals("na")) {
            this.doKey(period);
        } else {
            int clicks = Integer.valueOf(this.getNbrOfClicksSource().getText());
            this.doClick(period, clicks);
        }
    }

    private void doKey(long period) {
        String keyType = this.getKeyTypeSource().getText();
        while (!this.isFinished()) {
            if (!this.isPaused()) {
                this.getMonitor().pushKey(keyType);
            }
            try {
                PeriodicBotEntry.sleep(period);
                continue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doClick(long period, int clicks) {
        int x = Integer.valueOf(this.getXTargetSource().getText());
        int y = Integer.valueOf(this.getYTargetSource().getText());
        while (!this.isFinished()) {
            if (!this.isPaused()) {
                this.getMonitor().moveAndClick(x, y, clicks);
            }
            try {
                PeriodicBotEntry.sleep(period);
                continue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


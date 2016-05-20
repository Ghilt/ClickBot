package bot;

import bot.BotEntry;
import bot.EntryInformation;
import java.awt.Color;
import javax.swing.JTextField;

public class DetectionBotEntry extends BotEntry implements Runnable {
	private JTextField ySource;
	private JTextField xSource;

	public DetectionBotEntry(EntryInformation entryInformation) {
		super(entryInformation);
	}

	@Override
	public void run() {
		int x = Integer.valueOf(xSource.getText());
		int y = Integer.valueOf(ySource.getText());
		Color c = getMonitor().establishCondition(x, y);
		if (getXTargetSource().getText().equals("na")) {
			doKey(x, y, c);
		} else {
			int clicks = Integer.valueOf(getNbrOfClicksSource().getText());
			doClick(x, y, c, clicks);
		}
	}

	private void doClick(int x, int y, Color c, int clicks) {
		while (!isFinished()) {
			if (!isPaused() && getMonitor().detectedColorChange(x, y, c)) {
				getMonitor().moveAndClick(x, y, clicks);
			}
			try {
				sleep(2000);
				continue;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void doKey(int x, int y, Color c) {
		String keyType = getKeyTypeSource().getText();
		while (!isFinished()) {
			if (!isPaused() && getMonitor().detectedColorChange(x, y, c)) {
				getMonitor().pushKey(keyType);
			}
			try {
				sleep(2000);
				continue;
			} catch (InterruptedException e) {
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

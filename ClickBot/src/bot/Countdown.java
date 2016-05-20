package bot;

import java.awt.MouseInfo;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Countdown
extends Thread {
    private int time;
    private JButton button;
    private JTextField x;
    private JTextField y;

    public Countdown(JTextField x, JTextField y, JButton button, int time) {
        this.time = time;
        this.button = button;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        long timeLeft = this.time;
        long startTime = System.currentTimeMillis();
        this.button.setEnabled(false);
        while (timeLeft > 0) {
            timeLeft = (long)this.time - (System.currentTimeMillis() - startTime);
            if (timeLeft > 0) {
                this.button.setText("" + timeLeft);
                continue;
            }
            this.button.setText(this.button.getName());
            this.x.setText("" + MouseInfo.getPointerInfo().getLocation().x);
            this.y.setText("" + MouseInfo.getPointerInfo().getLocation().y);
            this.button.setEnabled(true);
        }
    }
}


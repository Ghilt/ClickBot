package bot;

import bot.Countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LocateButton
extends JButton
implements ActionListener {
    private JTextField x;
    private JTextField y;
    private JTextField clicksField;
    private JTextField keyField;

    public LocateButton(JTextField xCoord, JTextField yCoord, JTextField clicks, JTextField key, String string) {
        super(string);
        this.x = xCoord;
        this.y = yCoord;
        this.clicksField = clicks;
        this.keyField = key;
    }

    public LocateButton(JTextField xCoord, JTextField yCoord, String string) {
        super(string);
        this.x = xCoord;
        this.y = yCoord;
        this.keyField = this.clicksField = new JTextField();
    }

    public void actionPerformed(ActionEvent arg0) {
        this.clicksField.setEnabled(true);
        this.keyField.setText("na");
        this.keyField.setEnabled(false);
        new Countdown(this.x, this.y, this, 3200).start();
    }
}


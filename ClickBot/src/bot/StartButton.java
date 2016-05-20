package bot;

import bot.EntryInformation;
import bot.Gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener {
    private EntryInformation startList;
    private Gui gui;

    public StartButton(Gui gui, EntryInformation startList, String name) {
        super(name);
        this.gui = gui;
        this.startList = startList;
    }

    public void actionPerformed(ActionEvent e) {
        this.gui.showAbort(this.startList);
        this.startList.start();
        this.gui.dispose();
    }
}


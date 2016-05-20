package bot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class EntryInformation {
    private Robot bot;
    private ArrayList<BotEntry> entryList = new ArrayList();
    private Gui gui;
    private JTextArea log;
    private boolean pause;

    public EntryInformation(Gui gui) {
        this.gui = gui;
        pause = false;
        try {
            bot = new Robot();
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public synchronized PeriodicBotEntry writePeriodicEntry() {
        PeriodicBotEntry entry = new PeriodicBotEntry(this);
        entryList.add(entry);
        return entry;
    }

    public synchronized DetectionBotEntry writeDetectionEntry() {
        DetectionBotEntry entry = new DetectionBotEntry(this);
        entryList.add(entry);
        return entry;
    }

    public synchronized void start() {
        for (BotEntry entry : entryList) {
            entry.start();
        }
    }

    public synchronized boolean detectedColorChange(int x, int y, Color c) {
        return !bot.getPixelColor(x, y).equals(c);
    }

    public synchronized void moveAndClick(int x, int y, int clicks) {
        bot.mouseMove(x, y);
        int i = 0;
        while (i < clicks) {
            bot.mousePress(16);
            bot.mouseRelease(16);
            ++i;
        }
        
        log.append("\n[" + getFormattedTime() + "] - " + clicks + " Mouse Click(s) at coordinates X: " + x + " Y: " + y);
        log.setCaretPosition(log.getDocument().getLength());
    }

    public synchronized void pushKey(CharSequence characters) {
        int length = characters.length();
        int i = 0;
        while (i < length) {
            char character = characters.charAt(i);
            type(character);
            ++i;
        }

        log.append("\n[" + getFormattedTime() + "] - Keys pushed: " + characters);
        log.setCaretPosition(log.getDocument().getLength());
    }

    public void type(char character) {
        switch (character) {
            case 'a': {
                doType(65);
                break;
            }
            case 'b': {
                doType(66);
                break;
            }
            case 'c': {
                doType(67);
                break;
            }
            case 'd': {
                doType(68);
                break;
            }
            case 'e': {
                doType(69);
                break;
            }
            case 'f': {
                doType(70);
                break;
            }
            case 'g': {
                doType(71);
                break;
            }
            case 'h': {
                doType(72);
                break;
            }
            case 'i': {
                doType(73);
                break;
            }
            case 'j': {
                doType(74);
                break;
            }
            case 'k': {
                doType(75);
                break;
            }
            case 'l': {
                doType(76);
                break;
            }
            case 'm': {
                doType(77);
                break;
            }
            case 'n': {
                doType(78);
                break;
            }
            case 'o': {
                doType(79);
                break;
            }
            case 'p': {
                doType(80);
                break;
            }
            case 'q': {
                doType(81);
                break;
            }
            case 'r': {
                doType(82);
                break;
            }
            case 's': {
                doType(83);
                break;
            }
            case 't': {
                doType(84);
                break;
            }
            case 'u': {
                doType(85);
                break;
            }
            case 'v': {
                doType(86);
                break;
            }
            case 'w': {
                doType(87);
                break;
            }
            case 'x': {
                doType(88);
                break;
            }
            case 'y': {
                doType(89);
                break;
            }
            case 'z': {
                doType(90);
                break;
            }
            case 'A': {
                doType(16, 65);
                break;
            }
            case 'B': {
                doType(16, 66);
                break;
            }
            case 'C': {
                doType(16, 67);
                break;
            }
            case 'D': {
                doType(16, 68);
                break;
            }
            case 'E': {
                doType(16, 69);
                break;
            }
            case 'F': {
                doType(16, 70);
                break;
            }
            case 'G': {
                doType(16, 71);
                break;
            }
            case 'H': {
                doType(16, 72);
                break;
            }
            case 'I': {
                doType(16, 73);
                break;
            }
            case 'J': {
                doType(16, 74);
                break;
            }
            case 'K': {
                doType(16, 75);
                break;
            }
            case 'L': {
                doType(16, 76);
                break;
            }
            case 'M': {
                doType(16, 77);
                break;
            }
            case 'N': {
                doType(16, 78);
                break;
            }
            case 'O': {
                doType(16, 79);
                break;
            }
            case 'P': {
                doType(16, 80);
                break;
            }
            case 'Q': {
                doType(16, 81);
                break;
            }
            case 'R': {
                doType(16, 82);
                break;
            }
            case 'S': {
                doType(16, 83);
                break;
            }
            case 'T': {
                doType(16, 84);
                break;
            }
            case 'U': {
                doType(16, 85);
                break;
            }
            case 'V': {
                doType(16, 86);
                break;
            }
            case 'W': {
                doType(16, 87);
                break;
            }
            case 'X': {
                doType(16, 88);
                break;
            }
            case 'Y': {
                doType(16, 89);
                break;
            }
            case 'Z': {
                doType(16, 90);
                break;
            }
            case '`': {
                doType(192);
                break;
            }
            case '0': {
                doType(48);
                break;
            }
            case '1': {
                doType(49);
                break;
            }
            case '2': {
                doType(50);
                break;
            }
            case '3': {
                doType(51);
                break;
            }
            case '4': {
                doType(52);
                break;
            }
            case '5': {
                doType(53);
                break;
            }
            case '6': {
                doType(54);
                break;
            }
            case '7': {
                doType(55);
                break;
            }
            case '8': {
                doType(56);
                break;
            }
            case '9': {
                doType(57);
                break;
            }
            case '=': {
                doType(16, 48);
                break;
            }
            case '!': {
                doType(16, 49);
                break;
            }
            case '\"': {
                doType(16, 50);
                break;
            }
            case '#': {
                doType(16, 51);
                break;
            }
            case '&': {
                doType(16, 54);
                break;
            }
            case '%': {
                doType(16, 53);
                break;
            }
            case '/': {
                doType(16, 55);
                break;
            }
            case '(': {
                doType(16, 56);
                break;
            }
            case ')': {
                doType(16, 57);
                break;
            }
            case '@': {
                doType(65406, 50);
                break;
            }
            case '-': {
                doType(45);
                break;
            }
            case '~': {
                doType(16, 192);
                break;
            }
            case '{': {
                doType(512);
                break;
            }
            case '$': {
                doType(515);
                break;
            }
            case '^': {
                doType(514);
                break;
            }
            case '*': {
                doType(151);
                break;
            }
            case '_': {
                doType(523);
                break;
            }
            case '+': {
                doType(521);
                break;
            }
            case '[': {
                doType(91);
                break;
            }
            case ']': {
                doType(93);
                break;
            }
            case '}': {
                doType(16, 93);
                break;
            }
            case '|': {
                doType(16, 92);
                break;
            }
            case ';': {
                doType(59);
                break;
            }
            case ':': {
                doType(513);
                break;
            }
            case ',': {
                doType(44);
                break;
            }
            case '<': {
                doType(153);
                break;
            }
            case '.': {
                doType(46);
                break;
            }
            case '>': {
                doType(160);
                break;
            }
            case '?': {
                doType(16, 47);
                break;
            }
            case ' ': {
                doType(32);
                break;
            }
            case '\'': {
                doType(222);
                break;
            }
            case '\\': {
                doType(10);
                break;
            }
            default: {
                throw new IllegalArgumentException("Cannot type character " + character);
            }
        }
    }

    private /* varargs */ void doType(int ... keyCodes) {
        doType(keyCodes, 0, keyCodes.length);
    }

    private void doType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }
        bot.keyPress(keyCodes[offset]);
        doType(keyCodes, offset + 1, length - 1);
        bot.keyRelease(keyCodes[offset]);
    }

    public synchronized Color establishCondition(int x, int y) {
        return bot.getPixelColor(x, y);
    }

    public void finishAll() {
        for (BotEntry entry : entryList) {
            entry.finish();
        }
    }

    public void setLog(JTextArea log) {
        this.log = log;
    }

    public boolean isPaused() {
        return pause;
    }

    public void setPauseAll(boolean b) {
        pause = b;
        if (b) {
            log.append("\n[" + getFormattedTime() + "] - Paused");
        } else {
            log.append("\n[" + getFormattedTime() + "] - Unpaused");
        }
        log.setCaretPosition(log.getDocument().getLength());
        for (BotEntry entry : entryList) {
            entry.setPause(b);
        }
    }
    
    private String getFormattedTime(){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm ss");
    	return LocalDateTime.now().format(formatter);
    }
}


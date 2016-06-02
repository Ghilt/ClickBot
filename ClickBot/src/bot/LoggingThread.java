package bot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JTextArea;

public class LoggingThread extends Thread {

	BlockingQueue<String> logMessages = new LinkedBlockingQueue<String>();
	private JTextArea log;

	public LoggingThread(JTextArea log) {
		this.log = log;
	}

	public void run() {
		while (true) {
			String msg;
			while ((msg = logMessages.poll()) != null) {
		        log.append(msg);
		        log.setCaretPosition(log.getDocument().getLength());	
			}
		}
	}

	public void log(String msg){
		try {
			logMessages.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

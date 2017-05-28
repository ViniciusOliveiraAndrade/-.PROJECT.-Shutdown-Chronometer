package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Time;
import view.Window;

public class Control implements ActionListener{

	private Window window;
	public Control(Window window) {
		this.window = window;
	}

	public KeyAdapter cosumeLetter() {
		KeyAdapter keyAdapter = new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		};

		return keyAdapter;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == window.getStartButton()){
			Time.setTime(window.getHoursField().getText(),window.getMinutesField().getText(),window.getSecondsField().getText());
			}

		if (e.getSource() == window.getCancelButton()){
			Time.cancelTimer();
		}
	}

}

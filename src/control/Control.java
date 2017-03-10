package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

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


	@SuppressWarnings("unused")
	public void start(){
		int hours = window.getHoursField();
		int minutes = window.getMinutesField();
		int seconds = window.getSecondsField();

		int time = seconds+ (minutes * 60)+ (hours * 3600);


		try {
			Process p = Runtime.getRuntime().exec("shutdown -s -t "+ time);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(window, "Não foi possivel Cancelar");
		}



	}


	@SuppressWarnings("unused")
	public void cancel(){
		try {
			Process p = Runtime.getRuntime().exec("shutdown -a");
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(window, "Não foi possivel Cancelar");
		}
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == window.getStartButton()){start();}


		if (e.getSource() == window.getCancelButton()){cancel();}




	}

}

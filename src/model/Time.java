package model;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Time {

	private static final String OS = System.getProperty("os.name").toLowerCase();
	@SuppressWarnings("unused")
	private static Process p;

	public static void setTime(String Hour, String Minute, String Second){
		int t = convert(Hour, Minute, Second);
		System.out.println(OS);
		switch (OS){
		case "linux": {
			try {
				p = Runtime.getRuntime().exec("shutdown -h +"+ t);
				JOptionPane.showMessageDialog(null, "O computador desligaram em "+t+" Minutos");
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro,\nNão foi possivel iniciar o processo de desligamento");
			}
			break;
		}

		default:{
			try {
				p = Runtime.getRuntime().exec("shutdown -s -t "+ t);
				JOptionPane.showMessageDialog(null, "O computador desligaram em "+t+" Segundos");
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro,\nNão foi possivel iniciar o processo de desligamento");
			}
			break;
		}
		}
	}

	public static void cancelTimer(){
		switch (OS){
		case "linux": {
			try {
				p = Runtime.getRuntime().exec("shutdown -c");
				JOptionPane.showMessageDialog(null, "Cancelamento concluido");
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro,\nNão foi possivel Cancelar");
			}
			break;
		}

		default:{
			try {
				p = Runtime.getRuntime().exec("shutdown -a");
				JOptionPane.showMessageDialog(null, "Cancelamento concluido");
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro,\nNão foi possivel Cancelar");
			}
			break;
		}
		}
	} 
	
	private static int convert(String Hour, String Minute, String Second){
		int time = 0;
		int h = 0;
		int m = 0;
		int s = 0;

		switch (OS){
		case "linux": {
			if (!Hour.isEmpty()){
				h = (Integer.parseInt(Hour) / 60);
			}	
			if (!Minute.isEmpty()){
				m =  Integer.parseInt(Minute);
			}
			if (!Second.isEmpty()){
				s =  Integer.parseInt(Second);
				if(s >= 60){
					s = s / 60;
				}else if((s >= 45)&&(s < 60)){
					s = 1;
				
				}else {s = 0;}
			}
			if((h==0)&&(m==0)&&(s==0)){
				m=1;
			}

			time = h + m + s;
			break;
		}

		default:{
			if (!Hour.isEmpty()){
				h = Integer.parseInt(Hour);
			}	
			if (!Minute.isEmpty()){
				m =  Integer.parseInt(Minute);
			}
			if (!Second.isEmpty()){
				s =  Integer.parseInt(Second);
			}
			if((h==0)&&(m==0)&&(s==0)){
				s = 60;
			}
			time = (h * 3600) + (m * 60) + s;
			break;
		}
		}
		return time;
	} 
}
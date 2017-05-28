package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.Control;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField hoursField;
	private JTextField minutesField;
	private JTextField secondsField;
	
	private JButton cancelButton;
	private JButton startButton;
	private Control control;
	
	private JPanel  panel,panel_1;
	
	private JLabel lblNewLabel,label,label_1 ;
	
	public Window() {
		setSize(491,125);
		setTitle("Shutdown Chronometer");
		try{
		setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/Timer.png")).getImage());
		}catch(Exception e){}
		setResizable(false);
		getContentPane().setLayout(null);
		
		control = new Control(this);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 11, 260, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Hours      :    Minutes   :   Seconds");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 11, 275, 17);
		panel.add(lblNewLabel);
		
		hoursField = new JTextField();
		hoursField.setBounds(17, 39, 50, 20);
		panel.add(hoursField);
		hoursField.setColumns(10);
		hoursField.addKeyListener(control.cosumeLetter());
		
		minutesField = new JTextField();
		minutesField.setBounds(102, 39, 50, 20);
		panel.add(minutesField);
		minutesField.setColumns(10);
		minutesField.addKeyListener(control.cosumeLetter());
		
		secondsField = new JTextField();
		secondsField.setBounds(183, 39, 50, 20);
		panel.add(secondsField);
		secondsField.setColumns(10);
		secondsField.addKeyListener(control.cosumeLetter());
		
		label = new JLabel(" :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(80, 39, 13, 20);
		panel.add(label);
		
		label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(163, 37, 13, 20);
		panel.add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(275, 11, 200, 75);
		getContentPane().add(panel_1);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelButton.setBounds(102, 20, 89, 35);
		panel_1.add(cancelButton);
		
		startButton = new JButton("Start");
		startButton.setBounds(10, 20, 82, 35);
		panel_1.add(startButton);
		startButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cancelButton.addActionListener(control);
		startButton.addActionListener(control);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

	public JTextField getHoursField() {
		return hoursField;
	}

	public JTextField getMinutesField() {
		return minutesField;
	}

	public JTextField getSecondsField() {
		return secondsField;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getStartButton() {
		return startButton;
	}
	
}

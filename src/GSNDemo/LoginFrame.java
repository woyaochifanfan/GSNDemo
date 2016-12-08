package GSNDemo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginFrame extends JFrame{
	private JButton regBtn;
	private JButton logBtn;
	private JPanel btnPanel;
	public LoginFrame(){
		this.setBounds(0, 0, 480, 320);
		this.setResizable(false);
		createButtons();
		
	}
	
	private void createButtons(){
		btnPanel = new JPanel();
		regBtn = new JButton();
		logBtn = new JButton();
		regBtn.setBounds(100, 220, 120, 40);
		logBtn.setBounds(260, 220, 120, 40);
		regBtn.setText("×¢²á");
		logBtn.setText("µÇÂ¼");
		btnPanel.setLayout(null);
		btnPanel.add(regBtn);
		btnPanel.add(logBtn);
		this.getContentPane().add(btnPanel);

	}
}

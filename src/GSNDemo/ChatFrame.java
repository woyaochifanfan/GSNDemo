package GSNDemo;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChatFrame extends JFrame{
	private JButton sendBtn;
	public ChatFrame(){
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 720, 480);
		this.setLocationRelativeTo(null);
		createComps();
	}
	private void createComps(){
		sendBtn = new JButton("·¢ËÍ");
		sendBtn.setBounds(600, 360, 120, 120);
		
		
		this.setLayout(null);
		this.getContentPane().add(sendBtn);
	}
}


package GSNDemo;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame{
	private JButton sendBtn;
	private JTextArea myText;
	private JTextArea msgText;
	public ChatFrame(){
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 720, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("聊天");
		//createBasic();
		createComps();
	}
	private void createComps(){
		sendBtn = new JButton("发送");
		sendBtn.setBounds(620, 370,80, 80);		
		myText = new JTextArea();
		msgText = new JTextArea();
		msgText.setBounds(0,0,610,360);
		myText.setBounds(0, 370, 610, 80);
		myText.setAutoscrolls(true);
		msgText.setAutoscrolls(true);
		myText.setBorder(BorderFactory.createLoweredBevelBorder());
		msgText.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setLayout(null);
		this.getContentPane().add(sendBtn);
		this.getContentPane().add(msgText);
		this.getContentPane().add(myText);
	}
	private void createBasic(){
		ImageIcon img = new ImageIcon("1.jpg");		// 这是背景图片
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
		
		
	}
	
}

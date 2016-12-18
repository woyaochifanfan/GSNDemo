
package GSNDemo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatFrame extends JFrame{
	private JButton sendBtn;
	public ChatFrame(){
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 720, 480);
		this.setLocationRelativeTo(null);
		//createBasic();
		createComps();
	}
	private void createComps(){
		sendBtn = new JButton("发送");
		sendBtn.setBounds(600, 360, 120, 120);		
		
		this.setLayout(null);
		this.getContentPane().add(sendBtn);
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

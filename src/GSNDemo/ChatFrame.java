
package GSNDemo;

import java.awt.Color;
import java.awt.Font;

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
	private JLabel headLabel;
	private JLabel nameLabel;
	private JTextArea commentText;
	private Account myAccount;
	private Account yourAccount;
	private Person me;
	private Person you;
	private Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
	public ChatFrame(String user_me,String user_you){
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 720, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("聊天");
		
		myAccount = AccountManager.accMap.get(user_me);
		me = myAccount.getPerson();
		yourAccount = AccountManager.accMap.get(user_you);
		you = yourAccount.getPerson();
		
		createComps();
		createPersonInfo();
	}
	private void createComps(){
		sendBtn = new JButton("发送");
		sendBtn.setBounds(600, 370,100, 80);	
		sendBtn.setFont(myFont);
		myText = new JTextArea();
		msgText = new JTextArea();
		msgText.setBounds(0,0,580,360);
		myText.setBounds(0, 368, 580, 80);
		myText.setAutoscrolls(true);
		msgText.setAutoscrolls(true); 
		myText.setBorder(BorderFactory.createLoweredBevelBorder());
		msgText.setBorder(BorderFactory.createLoweredBevelBorder());
		msgText.setEditable(false);
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
	private void createPersonInfo(){
		headLabel = new JLabel();
		headLabel.setBounds(600,10,100,100);
		headLabel.setIcon(you.getImg());
		headLabel.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
		this.getContentPane().add(headLabel);
		
		nameLabel = new JLabel(you.getNickname());
		nameLabel.setBounds(600,120,200,50);
		nameLabel.setFont(new Font("微软雅黑",Font.BOLD, 20));
		this.getContentPane().add(nameLabel);
		
		commentText = new JTextArea(you.getComment());
		commentText.setFont(myFont);
		commentText.setBounds(600,200,100,80);
		commentText.setEditable(false);
		commentText.setOpaque(false);
		commentText.setLineWrap(true);
		this.getContentPane().add(commentText);
		
	}
	
}

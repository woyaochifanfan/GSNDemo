package GSNDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainInterFace extends JFrame{
	private JLabel headLabel;
	private JLabel nameLabel;
	private JTextArea commentText;
	private JLabel selectLabel;
	private JButton addFriendsBtn;
	private JButton delFriendsBtn;
	private JButton chatBtn;
	private JButton groupBtn;
	private JButton viewFriendsInfoBtn;
	private JButton viewMyInfoBtn;
	private JButton msgBtn;
	private JButton exitBtn;
	private JComboBox<String> friendsList; 
	private Account myAccount;
	private Person me;
	private Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
	public MainInterFace(String username){
		this.setTitle("用户界面");
		this.setResizable(false);
		this.setLayout(null);		
		this.setSize(320, 600);
		this.setLocationRelativeTo(null);
		
		myAccount = AccountManager.accMap.get(username);
		me = myAccount.getPerson();
		
		createBasic();
		createPersonInfo();
		createComps();
		
		
	}
	private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");	// 这是背景图片
		
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false);		
		
	}
	private void createComps(){ 
		selectLabel = new JLabel("选择:");
		selectLabel.setFont(myFont);
		selectLabel.setBounds(10, 200, 100, 20);
		this.getContentPane().add(selectLabel);
		
		chatBtn = new JButton("聊天");
		chatBtn.setFont(myFont);
		
		
		groupBtn = new JButton("群聊");
		viewFriendsInfoBtn = new JButton("查看资料");
		viewMyInfoBtn = new JButton("我的信息");
		msgBtn = new JButton("消息");
		exitBtn = new JButton("退出");
		addFriendsBtn = new JButton("添加好友");
		delFriendsBtn = new JButton("删除好友");
		 
 
		
		String[] contant = {"联系人：","小王","张三","李四","王五","小红","小李"};		
	 
		friendsList = new JComboBox<String>(contant);
		friendsList.setEditable(false);
		friendsList.setMaximumRowCount(8);
		friendsList.setBounds(10,150,300,30);
		friendsList.setFont(myFont);
		this.getContentPane().add(friendsList);
		
	
	   
		    
        	/*button.addActionListener(new ActionListener() { 
        		 
        		public void actionPerformed(ActionEvent e) { 
        		setVisible(false);//隐藏窗体 
        		
        		} 
        		});  
        	but1.addActionListener(new ActionListener() { 
        		 
        		public void actionPerformed(ActionEvent e) { 
        			JOptionPane.showMessageDialog(null, "您最近没有收到消息");
        		
        		} 
        		});
        	but2.addActionListener(new ActionListener() { 
        		 
        		public void actionPerformed(ActionEvent e) { 

                    PersonalMessage p = new PersonalMessage();
        		
        		} 
        		});  */
        	


	}
	private void createPersonInfo(){
		headLabel = new JLabel();
		headLabel.setBounds(10,10,100,100);
		headLabel.setIcon(me.getImg());
		headLabel.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
		this.getContentPane().add(headLabel);
		
		nameLabel = new JLabel(me.getNickname());
		nameLabel.setBounds(120,10,200,50);
		nameLabel.setFont(new Font("微软雅黑",Font.BOLD, 32));
		this.getContentPane().add(nameLabel);
		
		commentText = new JTextArea(me.getComment());
		commentText.setFont(myFont);
		commentText.setBounds(120,60,180,40);
		commentText.setEditable(false);
		commentText.setOpaque(false);
		commentText.setLineWrap(true);
		this.getContentPane().add(commentText);
		
	}
	
	

}

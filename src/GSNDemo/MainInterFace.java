package GSNDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
	private JLabel contactLabel;
	private JPanel btnPanel;
	private JButton addFriendsBtn;
	private JButton delFriendsBtn;
	private JButton chatBtn;
	private JButton groupBtn;
	private JButton viewFriendsInfoBtn;
	private JButton viewMyInfoBtn;
	private JButton msgBtn;
	private JButton optionBtn;
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
		
		this.addWindowFocusListener(new WindowFocusListener(){

			@Override
			public void windowGainedFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				refresh();
			}

			@Override
			public void windowLostFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	
		
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
		contactLabel = new JLabel("联系人:");
		contactLabel.setFont(myFont);
		contactLabel.setBounds(10, 120, 120, 20);
		this.getContentPane().add(contactLabel);
		
		selectLabel = new JLabel("选择:");
		selectLabel.setFont(myFont);
		selectLabel.setBounds(10, 200, 100, 20);
		this.getContentPane().add(selectLabel);
		
		btnPanel = new JPanel();
		GridLayout myLayout = new GridLayout(4, 2);
		btnPanel.setLayout(myLayout);
		btnPanel.setBounds(10, 240, 290, 320);
		
		chatBtn = new JButton("聊天");
		chatBtn.setFont(myFont);
		btnPanel.add(chatBtn);
		
		groupBtn = new JButton("群聊");
		groupBtn.setFont(myFont);
		btnPanel.add(groupBtn);
		
		viewFriendsInfoBtn = new JButton("查看资料");
		viewFriendsInfoBtn.setFont(myFont);
		btnPanel.add(viewFriendsInfoBtn);
		
		viewMyInfoBtn = new JButton("我的信息");
		viewMyInfoBtn.setFont(myFont);
		btnPanel.add(viewMyInfoBtn);
		
		addFriendsBtn = new JButton("添加好友");
		addFriendsBtn.setFont(myFont);
		btnPanel.add(addFriendsBtn);
		
		delFriendsBtn = new JButton("删除好友");
		delFriendsBtn.setFont(myFont);
		btnPanel.add(delFriendsBtn);
		
		msgBtn = new JButton("消息");
		msgBtn.setFont(myFont);
		btnPanel.add(msgBtn);
		
		optionBtn = new JButton("设置");
		optionBtn.setFont(myFont);
		btnPanel.add(optionBtn);
		
		this.getContentPane().add(btnPanel);
		
		String[] content = me.getFrdList().toArray(new String[me.getFrdList().size()]);
		friendsList = new JComboBox<>(content);
		friendsList.setEditable(false);
		friendsList.setMaximumRowCount(8);
		friendsList.setBounds(10,155,300,30);
		friendsList.setFont(myFont);
		this.getContentPane().add(friendsList);
		
		chatBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChatFrame chatfrm = new ChatFrame();
				chatfrm.setVisible(true);
			}
			
		});
	   
		viewMyInfoBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonalInformation myInfo = new PersonalInformation(myAccount.getUsername(),true);
				myInfo.setVisible(true);
			}
			
		});
		    
		viewFriendsInfoBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String fd = (String)friendsList.getSelectedItem();
				if (fd!=null){
					PersonalInformation frdsInfo = new PersonalInformation(fd,false);
					frdsInfo.setVisible(true);
				}

				
			}
			
		});
		
		addFriendsBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,"请输入对方用户名：\n","输入",JOptionPane.PLAIN_MESSAGE,null,null,"");
				if(s!=null){
					if (AccountManager.accMap.get(s)!=null){
						JOptionPane.showMessageDialog(null, "添加成功");
						me.getFrdList().add(s);
						friendsList.addItem(s);
					}
				}
			}
			
		});
        
		delFriendsBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String sel = (String)friendsList.getSelectedItem();
				if (sel!=null){
					int n = JOptionPane.showConfirmDialog(null, "你确定要删除好友"+sel+"吗", "确认",JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION){
						me.getFrdList().remove(sel);
						friendsList.removeItem(sel);
					}
				}
			}
			
		});
		
		


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
	
	public void refresh(){
		headLabel.setIcon(me.getImg());
		nameLabel.setText(me.getNickname());
		commentText.setText(me.getComment());
	}
	

}

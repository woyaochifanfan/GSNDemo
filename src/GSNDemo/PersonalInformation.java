package GSNDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PersonalInformation extends JFrame {
	private Account acc;
	private Person prsn;
	private JLabel nameLabel;
	private JTextArea commentText;
	private JLabel genderLabel;
	private JLabel birthdayLabel;
	private JLabel headLabel;
	private JLabel levelLabel;
	private JLabel xpLabel;
	private Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
	PersonalInformation(String username,boolean isMyself){
		this.setSize(320, 450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		acc = AccountManager.accMap.get(username);
		prsn = acc.getPerson();
		createBasic();
		createComps();
		if (isMyself){
			createEdit();
		}
		
	}
	private void createBasic(){
		ImageIcon img = new ImageIcon("1.jpg");		// 这是背景图片
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
	}

	private void createComps(){
		headLabel = new JLabel();
		headLabel.setBounds(10,10,100,100);
		headLabel.setIcon(prsn.getImg());
		headLabel.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
		this.getContentPane().add(headLabel);
		
		nameLabel = new JLabel(prsn.getNickname());
		nameLabel.setBounds(120,10,200,50);
		nameLabel.setFont(new Font("微软雅黑",Font.BOLD, 32));
		this.getContentPane().add(nameLabel);
		
		commentText = new JTextArea(prsn.getComment());
		commentText.setFont(myFont);
		commentText.setBounds(120,60,180,40);
		commentText.setEditable(false);
		commentText.setOpaque(false);
		commentText.setLineWrap(true);
		this.getContentPane().add(commentText);
		
		genderLabel = new JLabel("性别："+prsn.getGender());
		genderLabel.setFont(myFont);
		genderLabel.setBounds(10, 140, 300, 20);
		this.getContentPane().add(genderLabel);
		
		Calendar t =prsn.getBirthday();
		birthdayLabel = new JLabel("生日："+t.get(Calendar.YEAR)+"年"+(t.get(Calendar.MONTH)+1)+"月"+t.get(Calendar.DATE)+"日");
		birthdayLabel.setFont(myFont);
		birthdayLabel.setBounds(10,200,300,20);
		this.getContentPane().add(birthdayLabel);
		
		levelLabel = new JLabel("等级："+prsn.getLevel());
		levelLabel.setFont(myFont);
		levelLabel.setBounds(10,260, 300, 20);
		this.getContentPane().add(levelLabel);
		
		xpLabel = new JLabel("经验值："+prsn.getXp());
		xpLabel.setFont(myFont);
		xpLabel.setBounds(10,320,300,20);
		this.getContentPane().add(xpLabel);
		
	}
	
	private void createEdit(){
		JButton editBtn = new JButton("编辑");
		editBtn.setFont(myFont);
		editBtn.setBounds(80,380,160,40);
		this.getContentPane().add(editBtn);
		
		
		
		editBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] res = new String[Person.types.length];
				String s = (String) JOptionPane.showInputDialog(null,"请选择需编辑的内容:\n", "选择", JOptionPane.PLAIN_MESSAGE, null, Person.types, null);  
				if (s.equals(Person.types[0])){
					//
				}else if (s.equals(Person.types[1])){
					res[1] = (String) JOptionPane.showInputDialog(null,"请输入您的昵称：\n","输入",JOptionPane.PLAIN_MESSAGE,null,null,"");  
					if (res[1]!=null){
						nameLabel.setText(res[1]);
						prsn.setNickname(res[1]);
					}
				}else if (s.equals(Person.types[2])){
					res[2] = (String) JOptionPane.showInputDialog(null,"请输入您的个性签名：\n","输入",JOptionPane.PLAIN_MESSAGE,null,null,"");
					if (res[2]!=null){
						commentText.setText(res[2]);
						prsn.setComment(res[2]);
					}
				}else if (s.equals(Person.types[3])){
					res[3] = (String) JOptionPane.showInputDialog(null,"请输入您的性别：\n","输入",JOptionPane.PLAIN_MESSAGE,null,null,"");
					if (res[3]!=null){
						genderLabel.setText("性别："+res[3]);
						prsn.setGender(res[3]);
					}
				}else if (s.equals(Person.types[4])){
					SimpleDateFormat str =  new SimpleDateFormat("yyyy-MM-dd");
					res[4] = (String) JOptionPane.showInputDialog(null,"请输入您的生日（YYYY-MM-DD）：\n","输入",JOptionPane.PLAIN_MESSAGE,null,null,"");
					try {
						str.parse(res[4]);
						String[] arr = new String[3];
						arr = res[4].split("-");
						Calendar t = Calendar.getInstance();
						t.set(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1,Integer.parseInt(arr[2]));
						birthdayLabel.setText("生日："+t.get(Calendar.YEAR)+"年"+(t.get(Calendar.MONTH)+1)+"月"+t.get(Calendar.DATE)+"日");
						prsn.setBirthday(t);
						
					} catch (ParseException e) {
						
					}
				}else{
					
				}
				
			}
			
		});
	}
	

}

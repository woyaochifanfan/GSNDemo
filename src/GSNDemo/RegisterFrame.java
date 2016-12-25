package GSNDemo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame{
	private JButton regBtn;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JPasswordField pwcheckText;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel pwcheckLabel;
	private JLabel tipsLabel;
	public RegisterFrame(){
		this.setTitle("注册");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(480, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createComps();
		createBasic();
	}

	
	private void createComps(){
		Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
		regBtn = new JButton("注册");
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		pwcheckText = new JPasswordField();
		tipsLabel = new JLabel();
		usernameLabel = new JLabel("请输入用户名:");
		passwordLabel = new JLabel("请输入密码:");
		pwcheckLabel = new JLabel("请再次输入密码:");
		regBtn.setBounds(180, 220, 120, 40);
		regBtn.setFont(myFont);
		usernameLabel.setBounds(120, 40,240,20);
		usernameLabel.setFont(myFont);
		usernameText.setBounds(120, 60, 240, 20);
		passwordLabel.setBounds(120, 100,240,20);
		passwordLabel.setFont(myFont);
		passwordText.setBounds(120, 120, 240, 20);
		pwcheckLabel.setBounds(120, 160, 240, 20);
		pwcheckLabel.setFont(myFont);
		pwcheckText.setBounds(120, 180, 240, 20);
		tipsLabel.setBounds(0, 270, 480, 20);
		tipsLabel.setText("*限使用英文大小写和数字 用户名:4~16位,限字母开头 密码:6-16位");
		tipsLabel.setFont(myFont);
		this.setLayout(null);
		this.getContentPane().add(regBtn);
		this.getContentPane().add(usernameText);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(pwcheckText);
		this.getContentPane().add(usernameLabel);
		this.getContentPane().add(pwcheckLabel);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(tipsLabel);
		MyListener myListener = new MyListener();
		regBtn.addActionListener(myListener);
	}
	
	private class MyListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==regBtn){
				if (usernameText.getText().matches("[a-zA-Z][a-zA-Z0-9]{3,15}")){
					String pw = new String(passwordText.getPassword());
					String pwcheck = new String(pwcheckText.getPassword());
					if (pw.matches("[a-zA-Z0-9]{6,16}")){
						if (pwcheck.equals(pw)){
							JOptionPane.showMessageDialog(null, "注册成功");
							AccountManager.accMap.put(usernameText.getText(), new Account(usernameText.getText(),pw,new Person()));
							RegisterFrame.this.setVisible(false);
							
						}else{
							JOptionPane.showMessageDialog(null, "两次密码输入不一致");
						}
					}else{
						JOptionPane.showMessageDialog(null, "密码格式错误");
					}
				}else{
					JOptionPane.showMessageDialog(null, "账号格式错误");
				}
			}

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
}

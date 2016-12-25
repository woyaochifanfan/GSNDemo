
package GSNDemo;

import java.awt.BorderLayout;
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

public class LoginFrame extends JFrame{
	private JButton regBtn;
	private JButton logBtn;
	private static JTextField usernameText;
	private JPasswordField passwordText;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel logoLabel;
	
	public static void setUsername(String username) {
		usernameText.setText(username);
	}
	
	public LoginFrame(){
		this.setTitle("GSN Beta1.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createComps();
		createBasic();
		
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
		Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
		regBtn = new JButton();
		logBtn = new JButton();
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		usernameLabel = new JLabel("账号:");
		usernameLabel.setFont(myFont);
		passwordLabel = new JLabel("密码:");
		passwordLabel.setFont(myFont);
		logoLabel = new JLabel("GSN");
		logoLabel.setFont(new Font("微软雅黑",Font.PLAIN,96));
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		logoLabel.setBounds(120,0,240,120);
		usernameLabel.setBounds(100, 140, 40, 20);
		usernameText.setBounds(160, 140, 220, 20);
		passwordLabel.setBounds(100, 180, 40, 20);
		passwordText.setBounds(160, 180, 220, 20);
		
		regBtn.setBounds(100, 220, 120, 40);
		logBtn.setBounds(260, 220, 120, 40);
		regBtn.setText("注册");
		regBtn.setFont(myFont);
		logBtn.setText("登录");
		logBtn.setFont(myFont);
		
		this.setLayout(null);
		this.getContentPane().add(regBtn);
		this.getContentPane().add(logBtn);
		this.getContentPane().add(logoLabel);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(usernameLabel);
		this.getContentPane().add(usernameText);
		MyListener myListener = new MyListener();
		regBtn.addActionListener(myListener);
		logBtn.addActionListener(myListener);
	}

	
	private class MyListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==regBtn){
				RegisterFrame regFrm = new RegisterFrame();
				regFrm.setVisible(true);

			}else if (e.getSource()==logBtn){
				if (usernameText.getText().isEmpty()){
					return;
				}
				Account acc = AccountManager.accMap.get(usernameText.getText());
				if (acc!=null){
					String pwInput = new String(passwordText.getPassword());
					String pwCheck = new String(acc.getPassword());
					if (pwInput.equals(pwCheck)){
						JOptionPane.showMessageDialog(null, "登陆成功");
						MainInterFace mainInterFace = new MainInterFace(acc.getUsername());
						mainInterFace.setVisible(true);
						LoginFrame.this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "密码错误");
					}
				}else{
					JOptionPane.showMessageDialog(null, "账号不存在");
				}
			}
			
		}
		
	}
}


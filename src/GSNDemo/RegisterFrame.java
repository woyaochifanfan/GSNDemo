package GSNDemo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame{
	private JButton regBtn;
	private JTextField useridText;
	private JPasswordField passwordText;
	private JPasswordField pwcheckText;
	private JLabel useridLabel;
	private JLabel passwordLabel;
	private JLabel pwcheckLabel;
	public RegisterFrame(){
		this.setTitle("娉ㄥ唽");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(480, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createComps();
	}
	
	private void createComps(){
		Font myFont = new Font("微软雅黑",Font.PLAIN, 16);
		regBtn = new JButton("注册");
		useridText = new JTextField();
		passwordText = new JPasswordField();
		pwcheckText = new JPasswordField();
		useridLabel = new JLabel("请输入账号6位纯数字:");
		passwordLabel = new JLabel("请输入密码6-16位:");
		pwcheckLabel = new JLabel("请再次输入密码:");
		regBtn.setBounds(180, 220, 120, 40);
		regBtn.setFont(myFont);
		useridLabel.setBounds(120, 40,240,20);
		useridLabel.setFont(myFont);
		useridText.setBounds(120, 60, 240, 20);
		passwordLabel.setBounds(120, 100,240,20);
		passwordLabel.setFont(myFont);
		passwordText.setBounds(120, 120, 240, 20);
		pwcheckLabel.setBounds(120, 160, 240, 20);
		pwcheckLabel.setFont(myFont);
		pwcheckText.setBounds(120, 180, 240, 20);
		
		//12345
		this.setLayout(null);
		this.getContentPane().add(regBtn);
		this.getContentPane().add(useridText);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(pwcheckText);
		this.getContentPane().add(useridLabel);
		this.getContentPane().add(pwcheckLabel);
		this.getContentPane().add(passwordLabel);
		MyListener myListener = new MyListener();
		regBtn.addActionListener(myListener);
		
	}
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==regBtn){
				if (useridText.getText().matches("[1-9]\\d{5}")){
					String pw = new String(passwordText.getPassword());
					String pwcheck = new String(pwcheckText.getPassword());
					if (pw.length() >=6 && pw.length()<=16){
						if (pwcheck.equals(pw)){
							JOptionPane.showMessageDialog(null, "注册成功");
							Account acc = new Account(Integer.parseInt(useridText.getText()),pw,new Person());
							//add sth.
							RegisterFrame.this.dispose();
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
}

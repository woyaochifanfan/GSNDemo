package GSNDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainInterFace extends JFrame{
	public MainInterFace(){
		this.setTitle("用户界面");
		this.setResizable(false);
		this.setLayout(null);		
		
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		
		createBasic();
		createzujian();
		
	
		
	}
	private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");	// 这是背景图片
		
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false);		
		
	}
	private void createzujian(){ 
		 JButton button = new JButton("退出");
		 button.setBounds(333,543,60,30);
		 
		
		 String[] contant = {"联系人：","小王","张三","李四","王五","小红","小李"};		
		 
			JComboBox comboBox = new JComboBox(contant);
			comboBox.setEditable(true);
			comboBox.setMaximumRowCount(5);
			
				
			comboBox.setBounds(30,150,180,30);
			this.getContentPane().add(comboBox);
			this.getContentPane().add(button);
	       
			    
	        	button.addActionListener(new ActionListener() { 
	        		 
	        		public void actionPerformed(ActionEvent e) { 
	        		setVisible(false);//隐藏窗体 
	        		
	        		} 
	        		});  


	}
	
	

}

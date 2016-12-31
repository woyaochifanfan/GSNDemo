package gsn.frames;
import gsn.data.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HeadSelect extends JFrame{
	public JButton headbut1;
	public JButton headbut2;
	
	 HeadSelect(){
		this.setTitle("头像选择界面");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setSize(300, 300);		
		createComps();	
		
		
	}
	public void createComps(){
		JLabel labelone = new JLabel();
	    ImageIcon imgone = new ImageIcon("3.jpg");
		 headbut1 = new JButton("选择");
		labelone.setIcon(new ImageIcon("3.jpg"));
		labelone.setBounds(40,0,100,100);
		headbut1.setBounds(60,120,60,40);
		
		JLabel labeltwo = new JLabel();		
		ImageIcon imgtwo = new ImageIcon("5.jpg");
		 headbut2 = new JButton("选择");
		labeltwo.setIcon(new ImageIcon("5.jpg"));
		labeltwo.setBounds(160,0,100,100);
		headbut2.setBounds(180,120,60,40);		
		
		this.getContentPane().add(labelone);
		this.getContentPane().add(headbut1);
		this.getContentPane().add(labeltwo);
		this.getContentPane().add(headbut2);
		
		
	}
	
	

}

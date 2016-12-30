package gsn.frames;
import gsn.data.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HeadSelect extends JFrame{
	private Person pers;
	 HeadSelect(){
		this.setTitle("头像选择界面");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setSize(300, 300);		
		createComps();		
		
	}
	public void createComps(){
		JLabel label = new JLabel();
		final ImageIcon img = new ImageIcon("3.jpg");
		JButton but = new JButton("选择");
		label.setIcon(new ImageIcon("3.jpg"));
		
		label.setBounds(100,0,100,100);
		but.setBounds(120,120,60,40);
		this.getContentPane().add(label);
		this.getContentPane().add(but);
		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				pers.setImg(img);
				
			}
			
		});
		
		
	}

}

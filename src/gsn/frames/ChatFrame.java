
package gsn.frames;
import gsn.data.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois; 
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
		
		if (user_me.equals("SystemManager")){
			ServerThread st = new ServerThread();
			st.start();
		}else{
			ClientThread ct = new ClientThread();
			ct.start();
		}
	}
	private void createComps(){
		sendBtn = new JButton("发送");
		sendBtn.setBounds(600, 370,100, 80);	
		sendBtn.setFont(myFont);
		myText = new JTextArea();
		msgText = new JTextArea();
		myText.setFont(myFont);
		msgText.setFont(myFont);
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
		sendBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String txt = myText.getText();
				if (txt!=null){
					try {
						oos.writeObject(txt);
						oos.flush();
						//
						Calendar c = Calendar.getInstance();
						msgText.append(me.getNickname()+"  "+c.getTime()+"\n");
						msgText.append(txt+"\n");
						myText.setText("");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			
			}
			
		});
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
	private void connect(){
		try {
			socket = new Socket(NetHandler.ip, NetHandler.port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			String str;
			while (true){
				str=(String)ois.readObject();
				if (str=="quit"){
					break;
				}
				Calendar c = Calendar.getInstance();
				msgText.append(you.getNickname()+"  "+c.getTime()+"\n");
				msgText.append(str+"\n");
			}
			ois.close();
				
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void serverConnect(){
		ServerSocket server;
		try {
			server = new ServerSocket(NetHandler.port);
			socket = server.accept();
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			String str;
			while (true){
				str=(String)ois.readObject();
				if (str=="quit"){
					break;
				}
				Calendar c = Calendar.getInstance();
				msgText.append(you.getNickname()+"  "+c.getTime()+"\n");
				msgText.append(str+"\n");
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private class ServerThread extends Thread{
		public void run(){
			serverConnect();
		}
	}
	private class ClientThread extends Thread{
		public void run(){
			connect();
		}
	}
	
}

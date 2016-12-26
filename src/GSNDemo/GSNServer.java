package GSNDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class GSNServer {
	public static final int PUSH_DATA = 1;
	public static final int RECV_DATA = 2;
	public static final int CHATTING = 3;
	public static void main(String[] args){
		try {
			ServerSocket server= new ServerSocket(NetHandler.port);
			while (true){
				Socket socket = server.accept();
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(AccountManager.accMap);
				oos.flush();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Object o = ois.readObject();
				if (o!=null){
					AccountManager.accMap = (HashMap<String, Account>) o;
				}
				
				ois.close();
				oos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void pushData(){
		try {
			Socket socket = new Socket(NetHandler.ip, NetHandler.port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(AccountManager.accMap);
			oos.flush();
			oos.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void recvData(){
		try {
			Socket socket = new Socket(NetHandler.ip, NetHandler.port);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			AccountManager.accMap = (HashMap<String, Account>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

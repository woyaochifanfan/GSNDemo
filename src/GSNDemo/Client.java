package GSNDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException{
		Socket server = null;
		try{
			String inputString;
			server = new Socket("127.0.0.1",4445);
			System.out.println("请输入信息");
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(server.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(server.getInputStream()));
			inputString = sin.readLine();
			while(inputString!=null&&inputString.trim().equals("quit")){
				os.println(inputString);
				os.flush();
				System.out.println("Client发送的消息为："+inputString);
			 	System.out.println("Server发送的消息为："+is.readLine());
				inputString = sin.readLine();
			 	
			}
			os.close();
			is.close();
			server.close();
			System.out.println("聊天结束！");
			}catch(UnknownHostException e){
				e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
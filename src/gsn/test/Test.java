package gsn.test;
import gsn.data.*;
import gsn.frames.*;
public class Test {

	public static void main(String[] args) {
	
		LoginFrame a = new LoginFrame();
		a.setVisible(true);
		AccountManager.accMap.put("SystemManager",new Account("SystemManager","000000",new Person("系统管理员","我是系统管理员，您的默认好友","不详",100,0)));
		AccountManager.accMap.put("TestRobot1",new Account("TestRobot1","111111",new Person("机器人1","我是一个测试机器人","不详",100,0)));
		AccountManager.accMap.put("TestRobot2",new Account("TestRobot2","111111",new Person("机器人2","我是一个测试机器人","不详",100,0)));
		AccountManager.accMap.put("TestRobot3",new Account("TestRobot3","111111",new Person("机器人3","我是一个测试机器人","不详",100,0)));
		AccountManager.accMap.put("TestRobot4",new Account("TestRobot4","111111",new Person("机器人4","我是一个测试机器人","不详",100,0)));
		AccountManager.accMap.put("TestRobot5",new Account("TestRobot5","111111",new Person("机器人5","我是一个测试机器人","不详",100,0)));
		
		//ChatFrame b = new ChatFrame();
		//b.setVisible(true);
	
	} 
	

}

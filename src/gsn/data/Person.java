package gsn.data;

import java.util.Calendar;
import java.util.TreeSet;

import javax.swing.ImageIcon;


public class Person {
	public static String[] types = {"头像","昵称","个性签名","性别","生日"};
	private String nickname;
	private String comment;
	private String gender;
	private Calendar birthday;
	private ImageIcon img;
	private int level;
	private long xp;
	private TreeSet<String> frdList;
	
	public Person(String nickname, String comment, String gender, int level,long xp) {
		this.nickname = nickname;
		this.comment = comment;
		this.gender = gender;
		this.birthday = Calendar.getInstance();
		this.img =  new ImageIcon("DefaultHeadIcon.jpg");
		this.level = level;
		this.xp = xp;
		frdList = new TreeSet<String>();
		frdList.add("SystemManager");
		frdList.add("TestRobot1");
		frdList.add("TestRobot2");
		frdList.add("TestRobot3");
		frdList.add("TestRobot4");
		frdList.add("TestRobot5");
	}
	public Person(){
		nickname = "请编辑昵称";
		comment = "请编辑您的个性签名";
		gender = "unknown";
		birthday = Calendar.getInstance();
		img = new ImageIcon("DefaultHeadIcon.jpg");
		level = 0;
		xp =0;
		frdList = new TreeSet<String>();
		frdList.add("SystemManager");
		frdList.add("TestRobot1");
		frdList.add("TestRobot2");
		frdList.add("TestRobot3");
		frdList.add("TestRobot4");
		frdList.add("TestRobot5");
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getXp() {
		return xp;
	}
	public void setXp(long xp) {
		this.xp = xp;
	}
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public TreeSet<String> getFrdList() {
		return frdList;
	}

	

	
	
	
}

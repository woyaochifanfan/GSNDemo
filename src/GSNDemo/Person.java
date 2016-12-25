package GSNDemo;

import java.util.Calendar;

import javax.swing.ImageIcon;


public class Person {
	private int id;
	private String nickname;
	private String comment;
	private String gender;
	private Calendar birthday;
	private ImageIcon img;
	private int level;
	private long xp;
	public Person(){
		id = 10000;
		nickname = "Çë±à¼­êÇ³Æ";
		comment = "Çë±à¼­ÄúµÄ¸öÐÔÇ©Ãû";
		gender = "unknown";
		birthday = Calendar.getInstance();
		img = new ImageIcon("DefaultHeadIcon.jpg");
		level = 0;
		xp =0;
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
	

	
	
	
}

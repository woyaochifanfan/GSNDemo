package GSNDemo;

import java.util.Calendar;


public class Person {
	private String nickname;
	private String comment;
	private String gender;
	private Calendar birthday;
	private int level;
	private long xp;
	public Person(String nickname, String comment, String gender, Calendar birthday, int level, long xp) {
		this.nickname = nickname;
		this.comment = comment;
		this.gender = gender;
		this.birthday = birthday;
		this.level = level;
		this.xp = xp;
	}
	public Person(){
		nickname = "unknown";
		comment = "unknown";
		gender = "unknown";
		birthday = Calendar.getInstance();
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
	

	
	
	
}

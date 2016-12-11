package GSNDemo;

public class Account {

	private int userid;
	private String password;
	private Person person;
	public Account(int userid, String password, Person person) {
		this.userid = userid;
		this.password = password;
		this.person = person;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}


	
	
}

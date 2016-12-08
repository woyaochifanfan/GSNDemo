package GSNDemo;

public class Person {
	private Account account;
	private String nickname;
	private String comment;
	
	public Person(Account account, String nickname, String comment) {
		this.account = account;
		this.nickname = nickname;
		this.comment = comment;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
	
	
	
}

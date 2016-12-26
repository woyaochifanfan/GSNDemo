
package GSNDemo;

import java.io.Serializable;

public class Account implements Serializable{

	private String username;
	private String password;
	private Person person;
	public Account(String username, String password, Person person) {
		super();
		this.username = username;
		this.password = password;
		this.person = person;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

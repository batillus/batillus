package NaRaene.NaRaene.domain;

import javax.persistence.*;



@Entity
@Table(name = "user")
public class User {
	
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="id", columnDefinition = "int(11)")
    private long userId;
 
 @Column(name = "login", columnDefinition = "char(32)")
 private String login;
 
 @Column(name = "password", columnDefinition = "char(100)")
 private String password;

 @Column(name = "first_name", columnDefinition = "char(32)")
 private String firstName;

 @Column(name = "last_name", columnDefinition = "char(32)")
 private String lastName;
 
 
 
 public User() {
 }

 public User(String login, String password, String firstName, String lastName) {
     this.login = login;
     this.password = password;
     this.firstName = firstName;
     this.lastName = lastName;
    
 }
	
 
 public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

package Library.Project.User;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false,unique = true,length = 45)
	private String email;
	@Column(nullable = false,length = 20)
	private String firstName;
	@Column(nullable = false,length = 20)
	private String lastName;
	@Column(nullable = false,length = 64)
	private String pass;
	
	@Column(nullable = false)
	private String role;
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public User()
	{}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
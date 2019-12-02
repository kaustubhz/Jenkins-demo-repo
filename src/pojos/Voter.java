package pojos;

public class Voter {

	private int id;
	private String email,password,status;
	
	public Voter(int id, String email, String password, String status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", email=" + email + ", status=" + status + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

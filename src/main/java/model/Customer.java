package model;

public class Customer {
	private int id;
	private String fullname;
	private String password;
	private String phone_number;
	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String fullname, String phone_number,String email, String password) {
		super();
		
		this.setFullname(fullname);
		
		this.setPhone_number(phone_number);
		this.setEmail(email);
		this.setPassword(password);
	}
	public Customer(int id ,String fullname, String phone_number,String email, String password) {
		super();
		this.setId(id);
		this.setFullname(fullname);
		
		this.setPhone_number(phone_number);
		this.setEmail(email);
		this.setPassword(password);
	}
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	


	

	
}

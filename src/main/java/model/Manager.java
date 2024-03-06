package model;

public class Manager {
	private int id;
	private String fullname;
	private String password;
	private String phone_number;
	private String email;
	private int garaid;
	public Manager() {}
	public Manager(String fullname,String phone_number,String email,String password,int idgara) {
		super();
		
		this.setFullname(fullname);
		this.setPassword(password);
		this.setPhone_number(phone_number);
		this.setEmail(email);
		this.setGaraid(idgara);
	}
	public Manager(int id , String fullname,String phone_number,String email,String password,int idgara) {
		super();
		this.setId(id);
		this.setFullname(fullname);
		this.setPassword(password);
		this.setPhone_number(phone_number);
		this.setEmail(email);
		this.setGaraid(idgara);
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
	public int getGaraid() {
		return garaid;
	}
	public void setGaraid(int garaid) {
		this.garaid = garaid;
	}
	
}

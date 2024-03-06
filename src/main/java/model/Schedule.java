package model;

public class Schedule 
{
	private int id;
	private String musty;
	private int status;
	public Garage garage = new Garage();
	
	public String getMusty() {
		return musty;
	}
	
	public void setMusty(String musty) {
		this.musty = musty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

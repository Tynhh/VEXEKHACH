package model;

public class Seat {
	private int id;
	private String number_chair;
	private int status;
	private Trip trip = new Trip();
	
	public String getNumber_chair() {
		return number_chair;
	}

	public void setNumber_chair(String number_chair) {
		this.number_chair = number_chair;
	}

	

	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	

}

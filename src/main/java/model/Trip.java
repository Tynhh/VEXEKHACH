package model;

import java.util.ArrayList;

public class Trip{
	private int id;
	private String departure;
	private String destination;
	private String departure_time;
	private int price;
	private int num_seat;
	private String trip_board;
	public Garage garage = new Garage();
	public ArrayList<Seat> list_seat = new  ArrayList<Seat>();
	public ArrayList<Schedule> list_musty = new ArrayList<Schedule>();
	
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum_seat() {
		return num_seat;
	}
	public void setNum_seat(int num_seat) {
		this.num_seat = num_seat;
	}
	public String getTrip_board() {
		return trip_board;
	}
	public void setTrip_board(String trip_board) {
		this.trip_board = trip_board;
	}
	public Garage getGarage() {
		return garage;
	}
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	public void setGarageID(int id) {
		this.garage.setId(id);
	}
	public int getGarageID() {
		return garage.getId();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Schedule> getList_musty() {
		return list_musty;
	}
	public void setList_musty(ArrayList<Schedule> list_musty) {
		this.list_musty = list_musty;
	}
	public ArrayList<Seat> getList_seat() {
		return list_seat;
	}
	public void setList_seat(ArrayList<Seat> list_seat) {
		this.list_seat = list_seat;
	}

}

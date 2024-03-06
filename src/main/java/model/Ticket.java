package model;

public class Ticket {
	private int tripid;
	private String fullname;
	private String phonenumber;
	private String starts;
	private String musty;
	private String numberchair;
	private String tripbroad;
	private String startstime;
	private int price;

	private int seatid;
	private int customerid;
	public Ticket() {
	}

	public Ticket(int id, String name, String phone, String starts, String musty, String chair, String tripbroad,
			int price,String time, int seatid, int customid) {
		super();
		this.setTripid(id);
		this.setFullname(name);
		this.setPhonenumber(phone);
		this.setStarts(starts);
		this.setMusty(musty);
		this.setNumberchair(chair);
		this.setTripbroad(tripbroad);
		this.setStartstime(time);
		this.setPrice(price);
		
		this.setSeatid(seatid);
		this.setCustomerid(customid);
	}

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getMusty() {
		return musty;
	}

	public void setMusty(String musty) {
		this.musty = musty;
	}

	public String getNumberchair() {
		return numberchair;
	}

	public void setNumberchair(String numberchair) {
		this.numberchair = numberchair;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getTripbroad() {
		return tripbroad;
	}

	public void setTripbroad(String tripbroad) {
		this.tripbroad = tripbroad;
	}

	public int getSeatid() {
		return seatid;
	}

	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getStartstime() {
		return startstime;
	}

	public void setStartstime(String startstime) {
		this.startstime = startstime;
	}

}
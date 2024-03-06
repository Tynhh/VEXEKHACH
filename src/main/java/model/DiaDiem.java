package model;

import java.io.Serializable;



public class DiaDiem implements Serializable{
	private static final long serialVersionUID = 1L;
	private long idDiaDiem;
	private String tenDiaDiem;
	
	public DiaDiem(long idDiaDiem, String tenDiaDiem) {
		this.idDiaDiem = idDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
	}
	public DiaDiem(String tenDiaDiem){
		idDiaDiem = 1000;
		this.tenDiaDiem = tenDiaDiem;
	}
	public long getIdDiaDiem() {
		return idDiaDiem;
	}
	
	public String getTenDiaDiem() {
		return tenDiaDiem;
	}
	
	@Override
	public String toString() {
		return this.tenDiaDiem;
	}
	
}

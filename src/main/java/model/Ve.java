/*
 * package model;
 * 
 * import java.text.SimpleDateFormat; import java.util.Date; import
 * java.util.List;
 * 
 * import DAO.ChuyenDAO; import factory.dao.FactoryDAOImp; import
 * factory.dao.FactoryDao;
 * 
 * public class Ve { private long idVe; private String maVe; private String
 * ghiChu; private Date ngayDatVe; private List<Ghe> danhSachGhe; private
 * boolean daKhoiHanh; private boolean trangThaiThanhToan; private ThanhToan
 * phuongThucThanhToan; private Date thoiHanThanhToan; private boolean
 * trangThaiHuyVe; private String liDoHuyVe; private SimpleDateFormat formats =
 * new SimpleDateFormat(FORMAT);; public static final String FORMAT =
 * "dd/MM/yyyy HH:mm";
 * 
 * 
 * 
 * 
 * 
 * 
 * public Ve(String maVe, String ghiChu, Date ngayDatVe, List<Ghe> danhSachGhe,
 * boolean daKhoiHanh, boolean trangThaiThanhToan, Date thoiHanThanhToan,
 * boolean trangThaiHuyVe, String liDoHuyVe) { this.maVe = maVe; this.ghiChu =
 * ghiChu; this.ngayDatVe = ngayDatVe; this.danhSachGhe = danhSachGhe;
 * this.daKhoiHanh = daKhoiHanh; this.trangThaiThanhToan = trangThaiThanhToan;
 * this.thoiHanThanhToan = thoiHanThanhToan; this.trangThaiHuyVe =
 * trangThaiHuyVe; this.liDoHuyVe = liDoHuyVe; } public Ve(long idVe,String
 * maVe, String ghiChu, Date ngayDatVe, List<Ghe> danhSachGhe, boolean
 * daKhoiHanh, boolean trangThaiThanhToan, Date thoiHanThanhToan, boolean
 * trangThaiHuyVe, String liDoHuyVe) { this.idVe = idVe; this.maVe = maVe;
 * this.ghiChu = ghiChu; this.ngayDatVe = ngayDatVe; this.danhSachGhe =
 * danhSachGhe; this.daKhoiHanh = daKhoiHanh; this.trangThaiThanhToan =
 * trangThaiThanhToan; this.thoiHanThanhToan = thoiHanThanhToan;
 * this.trangThaiHuyVe = trangThaiHuyVe; this.liDoHuyVe = liDoHuyVe; }
 * 
 * 
 * public String getNgayDatVe() { return formats.format(this.ngayDatVe); }
 * 
 * public String getMaVe() { return maVe; }
 * 
 * public void setMaVe(String maVe) { this.maVe = maVe; }
 * 
 * 
 * 
 * public boolean isTrangThaiThanhToan() { return trangThaiThanhToan; }
 * 
 * public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
 * this.trangThaiThanhToan = trangThaiThanhToan; }
 * 
 * 
 * public String getTenGhe() { String res = ""; int n = danhSachGhe.size(); for
 * (int i = 0; i < n - 1; i++) { res += danhSachGhe.get(i).getSoGhe() + ", "; }
 * if (danhSachGhe.size() > 0) res += danhSachGhe.get(n - 1).getSoGhe(); return
 * res; }
 * 
 * public int getTongTien() { return chuyen.getGia() * danhSachGhe.size(); }
 * 
 * public int getSoLuongGhe() { return danhSachGhe.size(); }
 * 
 * public String getThoiHanThanhToan() { return
 * formats.format(thoiHanThanhToan); }
 * 
 * public List<Ghe> getDanhSachGhe() { return danhSachGhe; }
 * 
 * public ThanhToan getPhuongThucThanhToan() { return phuongThucThanhToan; }
 * 
 * public void setPhuongThucThanhToan(ThanhToan phuongThucThanhToan) {
 * this.phuongThucThanhToan = phuongThucThanhToan; }
 * 
 * 
 * 
 * public String getGhiChu() { return ghiChu; }
 * 
 * 
 * 
 * public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
 * 
 * 
 * 
 *//**
	 * @return the khachHang
	 */
/*
 * public KhachHang getKhachHang() { return khachHang; }
 * 
 * 
 * 
 *//**
	 * @param khachHang the khachHang to set
	 *//*
		 * public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; }
		 * 
		 * 
		 * 
		 * public boolean isDaKhoiHanh() { return daKhoiHanh; }
		 * 
		 * 
		 * 
		 * public void setDaKhoiHanh(boolean daKhoiHanh) { this.daKhoiHanh = daKhoiHanh;
		 * }
		 * 
		 * 
		 * 
		 * public boolean isTrangThaiHuyVe() { return trangThaiHuyVe; }
		 * 
		 * 
		 * 
		 * public void setTrangThaiHuyVe(boolean trangThaiHuyVe) { this.trangThaiHuyVe =
		 * trangThaiHuyVe; }
		 * 
		 * 
		 * 
		 * public String getLiDoHuyVe() { return liDoHuyVe; }
		 * 
		 * 
		 * 
		 * public void setLiDoHuyVe(String liDoHuyVe) { this.liDoHuyVe = liDoHuyVe; }
		 * 
		 * 
		 * 
		 * public void setIdVe(long idVe) { this.idVe = idVe; }
		 * 
		 * 
		 * 
		 * public void setNgayDatVe(Date ngayDatVe) { this.ngayDatVe = ngayDatVe; }
		 * 
		 * 
		 * 
		 * public void setDanhSachGhe(List<Ghe> danhSachGhe) { this.danhSachGhe =
		 * danhSachGhe; }
		 * 
		 * 
		 * 
		 * public void setThoiHanThanhToan(Date thoiHanThanhToan) {
		 * this.thoiHanThanhToan = thoiHanThanhToan; }
		 * 
		 * 
		 * 
		 * public Chuyen getChuyen() { return chuyen; }
		 * 
		 * 
		 * 
		 * public void setChuyen(Chuyen chuyen) { this.chuyen = chuyen; }
		 * 
		 * 
		 * 
		 * public long getIdVe() { return idVe; }
		 * 
		 * public Date getNgayDatVes(){ return ngayDatVe; }
		 * 
		 * public Date getThoiHanThanhToans(){ return thoiHanThanhToan; } public String
		 * getBenXuatPhat(){ return chuyen.getBenXuatPhat(); } public int getGia(){
		 * return chuyen.getGia(); } public String getLoaiGhe(){ return
		 * chuyen.getLoaiGhe(); } public String getLoaiXe(){ return chuyen.getLoaiXe() +
		 * " chổ"; } public String getTrangThaiThanhToan(){ return
		 * isTrangThaiThanhToan()? "Đã thanh toán" : "Chưa Thanh Toán"; } public String
		 * getTrangThaiKhoiHanh(){ return isDaKhoiHanh() ? "Đã Khởi hành" :
		 * "Chưa khởi hành"; } }
		 */
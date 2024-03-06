package DAO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NotifiDAO{
	public static void DoneSave(boolean a)
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		if(a) {
			JOptionPane.showMessageDialog(frame,
	                "Thêm Thành Công",
	                "THÔNG BÁO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Không Thể Thêm!!",
				    "Lỗi",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void DoneUpdate(boolean a)
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		if(a) {
			JOptionPane.showMessageDialog(frame,
	                "Cập Nhật Thành Công",
	                "THÔNG BÁO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Vui Lòng xem lại thông tin!!",
				    "Lỗi",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void DoneDelete(boolean a)
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		if(a) {
			JOptionPane.showMessageDialog(frame,
	                "Xoá Thành Công",
	                "THÔNG BÁO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Không Thể Xoá!!",
				    "Lỗi",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void DoneExport(boolean a)
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		if(a) {
			JOptionPane.showMessageDialog(frame,
	                "Xuất File Thành Công",
	                "THÔNG BÁO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Ghi file thất bại!",
				    "Lỗi",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void DoneDeleteTicket(boolean a)
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		if(a) {
			JOptionPane.showMessageDialog(frame,
	                "Huỷ Vé Thành Công",
	                "THÔNG BÁO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
				    "Không thể huỷ vé!!",
				    "Lỗi",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
}
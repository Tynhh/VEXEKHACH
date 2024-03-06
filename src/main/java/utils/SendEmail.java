package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	private static SendEmail instant = new SendEmail();
	private static Session session;
	private static final String USER = "vexeonline.uth@gmail.com";
	private static final String PASSWORD = "xomsebuvivoctczt";

	private SendEmail() {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Authenticator pa = null;
		pa = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER, PASSWORD);
			}
		};
		session = Session.getDefaultInstance(prop, pa);
	}

	public static SendEmail getInstant() {
		return instant;
	}

	public void guiMail(String to, String noiDung) {
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(USER));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Website bán vé xe online!!");

			message.setText("Chào bạn\nBạn vừa nhận mail thông báo từ công ty chúng tôi về thông tin vé"
					+ ".\nVới nội dung là:\n" + noiDung
					+ "\n Nếu có sai sót hãy liên hệ với chúng tôi với SDT:0123456789!\nChúc bạn ngày mới vui vẻ!");

			Transport.send(message);
			System.out.println("Done mail");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void guiMailManager(String to, String noiDung) {
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(USER));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Yêu cầu đặt lại mật khẩu Website bán vé xe online!!");

			message.setText("\n" + noiDung
					+ "\n Nếu có bất kỳ sai sót hoặc thắc mắc nào, hãy liên hệ với chúng tôi với SDT : 0123.456.789 !\nChúc bạn ngày mới vui vẻ!");

			Transport.send(message);
			System.out.println("Done mail");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	

}

package com.laptrinhweb.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.UserDto;

@Component
public class MailUtil {
	@Autowired
	public JavaMailSender emailSender;

	/*
	 * Mỗi khi gọi phương thức sendMail, một Runnable được gửi đến ExecutorService
	 * để thực thi việc gửi email trên một thread riêng biệt. ExecutorService giúp
	 * bạn tạo và quản lý các thread để thực hiện công việc gửi email một cách bất
	 * đồng bộ
	 */
	private ExecutorService executorService = Executors.newFixedThreadPool(10); // Số lượng thread tùy chọn

	public void sendMailResetPassword(UserDto userDto, String newPassword) {
		String subject = "Thông báo: Mật khẩu đã được đổi thành công";
		StringBuilder content = new StringBuilder();
		content.append("<p>Xin ch&agrave;o <strong>").append(userDto.getFullName()).append("</strong>.</p>").append(
				"<p>Ch&uacute;ng t&ocirc;i đến từ <strong>Organi.com</strong>, xin th&ocirc;ng b&aacute;o rằng mật khẩu của bạn đ&atilde; được đổi th&agrave;nh c&ocirc;ng.</p>")
				.append("<p>T&ecirc;n đăng nhập: <strong>").append(userDto.getUserName()).append("</strong></p>")
				.append("<p>Mật khẩu mới của bạn l&agrave;:<strong>").append(newPassword).append("</strong></p>")
				.append("<p>&nbsp;Vui l&ograve;ng đăng nhập bằng mật khẩu mới n&agrave;y để tiếp tục sử dụng t&agrave;i khoản.</p>")
				.append("<p>Vui l&ograve;ng nhấn v&agrave;o link b&ecirc;n dưới để đăng nhập bằng mật khẩu mới:</p>")
				.append("<p><a href=\"http://localhost:8080/Organi/dang-nhap\"><strong>Đăng nhập</strong></a></p>")
				.append("<p>Tr&acirc;n trọng, Đội ngũ quản trị vi&ecirc;n.</p>");
		sendMail(userDto.getEmail(), subject, content.toString());
	}

	public void sendMailVerifyUser(UserDto userDto) {
		String subject = "Thông báo: Đăng kí tài khoản thành công";
		StringBuilder content = new StringBuilder();
		content.append("<p>Ch&agrave;o bạn <em><strong>").append(userDto.getFullName()).append("</strong></em>,</p>")
				.append("<p>Xin ch&uacute;c mừng! Bạn đ&atilde; đăng k&yacute; th&agrave;nh c&ocirc;ng t&agrave;i khoản tr&ecirc;n website <strong>Organi.com</strong>. Để ho&agrave;n tất qu&aacute; tr&igrave;nh đăng k&yacute; v&agrave; x&aacute;c thực t&agrave;i khoản, vui l&ograve;ng nhấp v&agrave;o đường dẫn dưới đ&acirc;y:</p>")
				.append("<p><a href=\"http://localhost:8080/Organi/xac-thuc-nguoi-dung?id=").append(userDto.getId())
				.append("&verifyCode=").append(userDto.getVerifyCode()).append("\"")
				.append("><strong>Nhấn v&agrave;o đ&acirc;y để x&aacute;c thực.</strong></a></p>")
				.append("<p>Đường dẫn tr&ecirc;n sẽ đưa bạn đến trang x&aacute;c thực t&agrave;i khoản của ch&uacute;ng t&ocirc;i.&nbsp;</p>")
				.append("<p>Tr&acirc;n trọng,</p><p>Đội ngũ hỗ trợ <strong>Organi.com</strong>.</p>");
		sendMail(userDto.getEmail(), subject, content.toString());
	}

	private void sendMail(String to, String subject, String content) {
		executorService.submit(() -> {
			try {
				MimeMessage message = emailSender.createMimeMessage();
				boolean multipart = true;
				MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
				message.setContent(content, "text/HTML; charset=UTF-8");
				helper.setTo(to);
				helper.setSubject(subject);
				// sends the e-mail
				emailSender.send(message);
			} catch (MessagingException e) {
				// Xử lý ngoại lệ, ví dụ: hiển thị thông báo lỗi hoặc ghi log
				e.printStackTrace();
			}
		});
	}
}

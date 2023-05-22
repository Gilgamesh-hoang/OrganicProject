package com.laptrinhweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Kích hoạt tính năng "Auditing" và chỉ định đối tượng cung cấp thông tin người
 * dùng (auditorProvider) để Spring Data JPA có thể lấy thông tin người sửa đổi
 * dữ liệu.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
	/**
	 * được đăng ký làm đối tượng cung cấp thông tin người dùng cho Spring Data JPA.
	 * Phương thức này trả về một đối tượng AuditorAwareImpl để cung cấp thông tin
	 * về người sửa đổi dữ liệu.
	 */
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	public static class AuditorAwareImpl implements AuditorAware<String> {
		/**
		 * cung cấp thông tin về người dùng hiện tại. Phương thức này sử dụng đối tượng
		 * SecurityContextHolder để lấy thông tin về người dùng đang đăng nhập vào hệ
		 * thống.
		 */
		@Override
		public String getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				return null;
			}
			return authentication.getName();// return user name
		}
	}
}
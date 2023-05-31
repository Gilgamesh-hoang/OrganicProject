package com.laptrinhweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.laptrinhweb.service.impl.UserDetailsServiceImpl;
import com.laptrinhweb.util.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private CustomSuccessHandler customSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable(); // CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng
								// quyền chứng thực của người sử dụng đối với 1 website khác

		// Các trang không yêu cầu login như vậy ai cũng có thể vào được admin hay user
		// hoặc guest có thể vào các trang
		http.authorizeRequests().antMatchers("/", "/trang-chu", "/dang-nhap", "/dang-xuat", "/blog", "/blogDetail/**",
				"/tim-kiem-blog", "/lien-he", "/san-pham/**", "/tim-kiem-san-pham", "/danh-muc", "/thuong-hieu")
				.permitAll();

		// Trang yêu cầu phải login
		http.authorizeRequests()
				.antMatchers("/gio-hang/**", "/danh-sach-yeu-thich/**", "/thay-doi-mat-khau", "/chinh-sua-thong-tin",
						"/thong-tin-cua-toi", "/thong-tin-tai-khoan", "/thanh-toan", "/don-hang/**", "/dia-chi/**",
						"/binh-luan/**")
				.authenticated();

		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

		// Khi người dùng đã login, với vai trò user .
		// Nhưng cố ý truy cập vào trang admin
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessDenied");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // noi nhan url, chua action spring security
																// viet san dung de login. Khi nhan submit
				.loginPage("/dang-nhap").successHandler(customSuccessHandler)// đây Khi đăng nhập thành công thì vào
				// trang này
				.failureUrl("/dang-nhap?incorrectAccount")// Khi đăng nhập sai username và password thì nhập lại
				.usernameParameter("j_username")// tham số này nhận từ form login
				.passwordParameter("j_password")// tham số này nhận từ form login
				// Cấu hình cho Logout Page. Khi logout mình trả về trang
				.and().logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/trang-chu").deleteCookies("JSESSIONID");
//		http.authorizeRequests().and().formLogin()//
//		// Submit URL của trang login
//		.loginProcessingUrl("/j_spring_security_check") // noi nhan url, chua action spring security
//		// viet san dung de login. Khi nhan submit
//		.loginPage("/dang-nhap").defaultSuccessUrl("/trang-chu")// đây Khi đăng nhập thành công thì vào
//		// trang này
//		.failureUrl("/dang-nhap?incorrectAccount")// Khi đăng nhập sai username và password thì nhập lại
//		.usernameParameter("j_username")// tham số này nhận từ form login
//		.passwordParameter("j_password")// tham số này nhận từ form login
//		// Cấu hình cho Logout Page. Khi logout mình trả về trang
//		.and().logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/trang-chu").deleteCookies("JSESSIONID");

		// Cấu hình Remember Me. Nếu người dùng tick vào đó ta sẽ dùng cookie lưu lại
		// trong 24h
		http.authorizeRequests().and() //
				.rememberMe().key("uniqueAndSecret").tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		// Và sét đặt PasswordEncoder.
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); // Ta lưu tạm remember me trong memory
																				// (RAM). Nếu cần mình có thể lưu trong
																				// database
		return memory;
	}
}

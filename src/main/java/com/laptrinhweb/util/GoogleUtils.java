package com.laptrinhweb.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserSocial;

@Component
public class GoogleUtils {
	// Thực hiện gửi request tới google (lấy access_token, lấy thông tin tài khoản)

	public static String GOOGLE_CLIENT_ID = "962062893818-gvp7bp2rgclufevrqdhhgsppivjouive.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "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";
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Organi/login-google";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";

	public String getToken(final String code) throws ClientProtocolException, IOException {
		String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID).add("client_secret", GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code).add("grant_type", GOOGLE_GRANT_TYPE)
						.build())
				.execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public UserSocial getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		UserSocial userSocial = mapper.readValue(response, UserSocial.class);

		return userSocial;
	}

	public MyUser buildUser(UserSocial userSocial) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(SystemConstant.USER));
		MyUser userDetail = new MyUser(userSocial.getEmail(), "", enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		userDetail.setFullName(userSocial.getName());
		userDetail.setId(cutId(userSocial.getId()));
		userDetail.setEmail(userSocial.getEmail());
		return userDetail;
	}

	private int cutId(String idString) {
		// tại vì int chỉ chứa được 2 tỷ mà id của google trả về khoảng 21 số nên phải
		// cắt để int có thể chứa đưuọc mà không cần phải thay đổi kiểu của id
		String id = idString.substring(0, 9);
		return Integer.parseInt(id);
	}

}

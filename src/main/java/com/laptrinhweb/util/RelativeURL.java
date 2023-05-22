package com.laptrinhweb.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class RelativeURL {

	// lấy ra đường dẫn tương đối
	// vd: http://localhost:8080/Organi/danh-muc?genreId=1&page=2 ->
	// /danh-muc?genreId=1
	public String relativeUrl(HttpServletRequest request) {
		//
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String queryString = request.getQueryString();
		StringBuilder uriWithoutContextPath = new StringBuilder(requestUri.substring(contextPath.length()));

		if (queryString != null) {
			uriWithoutContextPath.append("?" + queryString);
		}
		int index = uriWithoutContextPath.indexOf("&");
		if (index >= 0) {
			uriWithoutContextPath.delete(uriWithoutContextPath.indexOf("&"), uriWithoutContextPath.length());
		}
		return uriWithoutContextPath.toString();

	}
}

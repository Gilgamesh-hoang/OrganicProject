package com.laptrinhweb.util;

import com.laptrinhweb.constant.SystemConstant;

public class OrderUtil {

	public static String map(String key) {
		if (key.equals(SystemConstant.PROCESSING))
			return "Đang chuẩn bị";
		else if (key.equals(SystemConstant.SHIPPED))
			return "Đang giao hàng";
		else if (key.equals(SystemConstant.DELIVERED))
			return "Đã giao hàng";
		else
			return null;
	}
}

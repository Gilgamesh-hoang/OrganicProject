package com.laptrinhweb.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	public Map<String, String> getMessage(String message) {
		Map<String, String> map = new HashMap<>();
		if (message.equals("update_success")) {
			map.put("message", "Update success");
			map.put("alert", "success");
		} else if (message.equals("insert_success")) {
			map.put("message", "Insert success");
			map.put("alert", "success");
		} else if (message.equals("delete_success")) {
			map.put("message", "Delete success");
			map.put("alert", "success");
		} else if (message.equals("error_system")) {
			map.put("message", "Error system");
			map.put("alert", "danger");
		}
		return map;
	}
}

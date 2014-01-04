package com.knt.frontpage.core;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;



import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Maps;
import com.knt.mapper.JsonMapper;

public class JsonUtil {
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	private static JsonMapper mapper = new JsonMapper();

	// AJAX输出，返回null
	public static String ajax(HttpServletResponse response, String content, String type) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// AJAX输出文本，返回null
	public static String ajaxText(HttpServletResponse response, String text) {
		return ajax(response, text, "text/plain");
	}

	// AJAX输出HTML，返回null
	public static String ajaxHtml(HttpServletResponse response, String html) {
		return ajax(response, html, "text/html");
	}

	// AJAX输出XML，返回null
	public static String ajaxXml(HttpServletResponse response, String xml) {
		return ajax(response, xml, "text/xml");
	}

	// 根据字符串输出JSON，返回null
	public static String ajaxJson(HttpServletResponse response, String jsonString) {
		return ajax(response, jsonString, "text/html");
	}

	// 根据Map输出JSON，返回null
	public static String ajaxJson(HttpServletResponse response, Map<String, String> jsonMap) {
		return ajax(response, mapper.toJson(jsonMap), "text/html");
	}

	// 输出JSON警告消息，返回null
	public static String ajaxJsonWarnMessage(HttpServletResponse response, String message) {
		Map<String, String> jsonMap = Maps.newHashMap();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		return ajax(response, mapper.toJson(jsonMap), "text/html");
	}

	// 输出JSON成功消息，返回null
	public static String ajaxJsonSuccessMessage(HttpServletResponse response, String message) {
		Map<String, String> jsonMap = Maps.newHashMap();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, message);
		return ajax(response, mapper.toJson(jsonMap), "text/html");
	}

	// 输出JSON错误消息，返回null
	public static String ajaxJsonErrorMessage(HttpServletResponse response, String message) {
		Map<String, String> jsonMap = Maps.newHashMap();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		return ajax(response, mapper.toJson(jsonMap), "text/html");
	}

	public static String beanMapToJson(HttpServletResponse response, Map<String, Object> provincemaps) {
		return mapper.toJson(provincemaps);
	}

	public static String beanListToJson(HttpServletResponse response, List<?> beanList) {
		return ajax(response, mapper.toJson(beanList), "text/html");
	}

	public static Object fromJsonToObject(String jsonString) {
		return mapper.fromJson(jsonString, Object.class);
	}

	public static Object fromJsonToObject(String jsonString, Class<?> beanClass) {
		return mapper.fromJson(jsonString, beanClass);
	}

	@SuppressWarnings("unchecked")
	public static List<String> fromJsonToList(String jsonString) {
		return mapper.fromJson(jsonString, List.class);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> fromJsonToMap(String jsonString) {
		return mapper.fromJson(jsonString, HashMap.class);
	}

	public static List<?> fromJsonToListBean(String jsonString, Class<?> collectionClass, Class<?>... elementClasses) {
		JavaType beanListType = mapper.createCollectionType(collectionClass, elementClasses);
		List<?> beanList = mapper.fromJson(jsonString, beanListType);
		return beanList;
	}
}

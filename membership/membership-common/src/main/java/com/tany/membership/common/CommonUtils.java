package com.tany.membership.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	/*public static Map<String, Object> wxLogin(String code, String appId, String appSecret) {
		String params = "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code
				+ "&grant_type=authorization_code";

		String content = HttpUtils.get("https://api.weixin.qq.com/sns/jscode2session?" + params);

		return JsonUtils.jsonToMap(content);
	}*/

	public static Map<String, Object> getOpenId(String code, String appId, String appSecret) {
		//RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type=authorization_code";
		String result = HttpUtils.httpGet(url, appId, appSecret, code); //restTemplate.getForObject(url, String.class, appId, appSecret, code);

		Map<String, Object> resultMap = JsonUtils.jsonToMap(result);

		for (Entry<String, Object> entry : resultMap.entrySet()) {
			logger.info(entry.getKey() + "---" + entry.getValue());
		}
		return resultMap;
	}

	public static <TARGET, ORIGIN> TARGET entityMapping(Class<TARGET> targetClass, ORIGIN origin) {
		Field[] targetFields = targetClass.getDeclaredFields();
		Class<?> clazz = origin.getClass();
		TARGET target = null;
		try {
			target = targetClass.newInstance();
			for (Field targetField : targetFields) {

				targetField.setAccessible(true);
				Field originField = clazz.getDeclaredField(targetField.getName());
				if (originField == null) {
					targetField.set(target, null);
				} else {
					originField.setAccessible(true);
					targetField.set(target, originField.get(origin));
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| InstantiationException e) {
			e.printStackTrace();
		}

		return target;
	}

	public static void printException(Logger logger,Exception ex) {
		
		StackTraceElement stackTraceElement = ex.getStackTrace()[0];
		logger.error("Exception=" + ex.getMessage() == null ? ex.toString() : ex.getMessage());
		logger.error("File=" + stackTraceElement.getFileName());
		logger.error("Line=" + stackTraceElement.getLineNumber());
		logger.error("Method=" + stackTraceElement.getMethodName());
	}
}

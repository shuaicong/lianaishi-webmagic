package com.lianaishi.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	@SuppressWarnings("unchecked")
	public static Map<String,Object> json2Map(String json){
	return JSON.parseObject(json, Map.class);
	}

	public static String obj2JsonString(Object obj){
	return JSON.toJSONString(obj);
	}


}

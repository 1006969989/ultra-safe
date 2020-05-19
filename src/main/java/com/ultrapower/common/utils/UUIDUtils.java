package com.ultrapower.common.utils;

import java.util.UUID;

/**
 * 生成uuid工具
 * @author mint
 *
 */
public class UUIDUtils {
	
	/**
	 * 生成32位不带横线UUID 
	 * @return 32位不带横线UUID 
	 */
	public static String get32UUIDWithOutLine() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 生成36位带横线的UUID
	 * @return 36位带横线的UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}

 
package com.lixuan.rems.util;

import java.util.Collection;

/**  
 * ClassName:ValidateUtil：验证工具类  
 * Date:     2015年12月7日 下午7:47:44  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2015, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ValidateUtil {
	
	/**
	 *判断字符串的有效性
	 */
	public static boolean isValid(String src)
	{
		return !(src == null || "".equals(src.trim()));
	}
	
	/**
	 * 判断集合的有效性
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col)
	{
		if(col == null || col.isEmpty())
		{
			return false;
		}
		return true;
	}
}
  

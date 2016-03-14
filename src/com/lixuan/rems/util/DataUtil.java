package com.lixuan.rems.util;

import java.security.MessageDigest;

/**  
 * ClassName:数据处理工具类   
 * Date:     2015年12月6日 下午5:49:49  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2015, lixuan.com All Rights Reserved.   
 * @see        
 */
public class DataUtil 
{
	/**
	 * 使用md5算法加密
	 */
	public static String md5(String src)
	{
		try 
		{
			StringBuffer buffer = new StringBuffer();
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			byte[] bytes = src.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] targ = md.digest(bytes);
			System.out.println(targ.toString());
			for(byte b:targ)
			{
				buffer.append(chars[(b >> 4) & 0x0F]);
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
  

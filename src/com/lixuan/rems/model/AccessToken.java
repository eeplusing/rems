package com.lixuan.rems.model;

/**
 * 微信通用接口凭证
 * @ClassName:AccessToken   
 * @Date:     2016年1月21日 上午11:05:20  
 * @author    CAOPENG  
 * @version   1.0 
 * @since     JDK 1.7  
 * @right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class AccessToken 
{
	//获取到的凭证
	private String token;
	
	//凭证有效时间，单位：秒
	private int expiresIn;

	public String getToken() 
	{
		return token;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}

	public int getExpiresIn() 
	{
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) 
	{
		this.expiresIn = expiresIn;
	}

	public AccessToken(String token, int expiresIn) 
	{
		super();
		this.token = token;
		this.expiresIn = expiresIn;
	}

	public AccessToken() 
	{
		super();
	}
}
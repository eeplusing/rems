package com.lixuan.rems.model;

import java.util.List;

/**
 * 多图文消息对象
*  @Date:     2016年1月21日 上午9:47:22  
 * @author    CAOPENG  
 * @version   1.0 
 * @since     JDK 1.7  
 * @right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class News 
{
	//多条图文消息信息列表，默认第一个item为大图
	private List<Article> Articles;

	public List<Article> getArticles() 
	{
		return Articles;
	}

	public void setArticles(List<Article> articles) 
	{
		Articles = articles;
	}

	public News(List<Article> articles) 
	{
		super();
		Articles = articles;
	}

	public News() 
	{
		super();
	}
	
}

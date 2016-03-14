 
package com.lixuan.rems.model;  
/**  
 * ClassName:LinkMessage   
 * Date:     2016年1月21日 上午9:48:24  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqLinkMessage extends ReqBaseMessage 
{
	//消息标题
	private String Title;
	
	//消息描述
	private String Description;
	
	//消息链接
	private String Url;
	
	public String getTitle() 
	{
		return Title;
	}
	public void setTitle(String title) 
	{
		Title = title;
	}
	public String getDescription() 
	{
		return Description;
	}
	public void setDescription(String description) 
	{
		Description = description;
	}
	public String getUrl() 
	{
		return Url;
	}
	public void setUrl(String url) 
	{
		Url = url;
	}
}
  

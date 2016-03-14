 
package com.lixuan.rems.model;  
/**  
 * ClassName:TextMessage   
 * Date:     2016年1月21日 上午9:46:06  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqTextMessage extends ReqBaseMessage 
{
	//用户发送的消息内容
	private String Content;

	public String getContent() 
	{
		return Content;
	}

	public void setContent(String content) 
	{
		Content = content;
	}

}
  

package com.lixuan.rems.model;


/**
 * 文本消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class RespTextMessage extends RespBaseMessage {
	//回复的消息内容
	private String Content;

	public String getContent() 
	{
		return Content;
	}

	public void setContent(String content) 
	{
		Content = content;
	}

	public RespTextMessage(String content) 
	{
		super();
		Content = content;
	}

	public RespTextMessage() 
	{
		super();
	}
}
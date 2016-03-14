 
package com.lixuan.rems.model;  
/**  
 * ClassName:BaseRequestMessage   
 * Date:     2016年1月21日 上午9:29:21  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqBaseMessage 
{
	//消息Id，64位整型
	private long MsgId;
	
	//开发者微信号
	private String ToUserName;
	
	//发送方帐号（一个OpenID）
	private String FromUserName;
	
	//消息创建时间 （整型）
	private long CreateTime;

	//消息类型 text、image、location、link、voice、shortvideo
	private String MsgType;

	public String getToUserName() 
	{
		return ToUserName;
	}

	public void setToUserName(String toUserName) 
	{
		ToUserName = toUserName;
	}

	public String getFromUserName() 
	{
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) 
	{
		FromUserName = fromUserName;
	}
	public long getCreateTime() 
	{
		return CreateTime;
	}

	public void setCreateTime(long createTime) 
	{
		CreateTime = createTime;
	}

	public String getMsgType() 
	{
		return MsgType;
	}

	public void setMsgType(String msgType) 
	{
		MsgType = msgType;
	}

	public long getMsgId() 
	{
		return MsgId;
	}

	public void setMsgId(long msgId) 
	{
		MsgId = msgId;
	}
}
  

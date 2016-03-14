package com.lixuan.rems.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lixuan.rems.model.RespBaseMessage;
import com.lixuan.rems.model.RespMediaMessage;
import com.lixuan.rems.model.RespMusicMessage;
import com.lixuan.rems.model.RespNewsMessage;
import com.lixuan.rems.model.RespTextMessage;
import com.lixuan.rems.model.RespVideoMessage;
import com.lixuan.rems.util.ConstantUtil;
import com.lixuan.rems.util.MessageUtil;

/**
 * 消息处理
 * @author caspar.chen
 * @version 1.0
 */
public class MessageService {

	public static Map<String, RespBaseMessage> bulidMessageMap = new HashMap<String, RespBaseMessage>();
	
	static 
	{
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_TEXT, new RespTextMessage());
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_NEWS, new RespNewsMessage());
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_IMAGE, new RespMusicMessage());
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_VOICE, new RespMediaMessage());
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_VIDEO, new RespVideoMessage());
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_MUSIC, new RespMusicMessage());
	}
	
	/**
	 * 构建基本消息
	 * @param requestMap xml请求解析后的map
	 * @param msgType   消息类型
	 * @return BaseMessage 基本消息对象
	 */
	public static Object bulidBaseMessage(Map<String, String> requestMap,String msgType) 
	{
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");

		RespBaseMessage message = bulidMessageMap.get(msgType);
		message.setToUserName(fromUserName);
		message.setFromUserName(toUserName);
		message.setCreateTime(new Date().getTime());
		message.setMsgType(msgType);
		message.setFuncFlag(0);
		return message;
	}

	/**
	 * 发送消息接口 
	 * @param obj 消息对象
	 * @param msgType 消息类型
	 * @return 返回xml格式数据给微信
	 */
	public static String bulidSendMessage(Object obj, String msgType) 
	{
		String responseMessage = "";

		// 图文消息处理
		if (msgType == ConstantUtil.RESP_MESSAGE_TYPE_NEWS) 
		{
			responseMessage = MessageUtil.newsMessageToXml((RespNewsMessage) obj);
		} 
		else 
		{// 其他消息处理
			responseMessage = MessageUtil.messageToXml(obj);
		}
		return responseMessage;
	}

}

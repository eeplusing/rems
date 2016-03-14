 
package com.lixuan.rems.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lixuan.rems.model.RespTextMessage;
import com.lixuan.rems.util.ConstantUtil;
import com.lixuan.rems.util.MessageUtil;

/**  
 * @ClassName:CoreService   
 * @Date:     2016年1月21日 下午8:18:27  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.8  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */

@Service
public class CoreService 
{
	/**
	* 处理微信发来的请求
	* @param request
	* @return
	*/ 
	 public static String processRequest(HttpServletRequest request) 
	 {
		 //返回的消息
		 String respMessage = null; 
		 //事件类型
		 String eventType = null;
		 try 
		 { 
			 // 默认返回的文本消息内容 
			 String respContent = " eplus拼命工作也没有找到主人想要的东西!"; 
			 
			 // xml请求解析
			 Map<String, String> requestMap = MessageUtil.parseXml(request);
		
			 // 发送方帐号(open_id)
			 String fromUserName = requestMap.get("FromUserName"); 
		
			 // 公众帐号
			 String toUserName = requestMap.get("ToUserName"); 
		
			 // 消息类型
			 String msgType = requestMap.get("MsgType"); 
		
			 // 回复文本消息
			 RespTextMessage textMessage = new RespTextMessage();
			 textMessage.setToUserName(fromUserName); 
		     textMessage.setFromUserName(toUserName); 
		
			 textMessage.setCreateTime(new Date().getTime());
			 textMessage.setMsgType(ConstantUtil.RESP_MESSAGE_TYPE_TEXT);
			 textMessage.setFuncFlag(0); 
		
			 // 文本消息响应
			 if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_TEXT))
			 {
				 respContent = "欢迎光临Eplus！-----From 503 all members";
			 } 
		
			 // 图片消息响应
			 else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_IMAGE)) 
			 {
				 String picUrl = requestMap.get("PicUrl");
				 respContent = ImageMessageRespService.faceRecognition(picUrl); 
			 }
		
			 // 地理位置消息响应 
			 else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_LOCATION)) 
			 {
				 respContent = "您发送的是地理位置消息!";
			 } 
		
			// 链接消息响应 
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_LINK)) 
			{
				respContent = "您发送的是链接消息!"; 
			} 
		
			 // 语音消息响应  
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_VOICE)) 
		    {
				respContent = "您发送的是音频消息!";
			} 
			 
			 // 视频消息响应  
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_VEDIO)) 
			{
				respContent = "您发送的是视频消息，小eplus不敢看颜值报表的画面!";
			} 
		
			 // 事件推送响应  
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_EVENT)) 
			{
				// 获取事件类型
				eventType = requestMap.get("Event"); 
				 //订阅响应  
				if (eventType.equals(ConstantUtil.EVENT_TYPE_SUBSCRIBE)) 
				{
					respContent = "欢迎关注Eplus!  --From 503 all members";
				} 
			
				 // 取消订阅响应  
				else if (eventType.equals(ConstantUtil.EVENT_TYPE_UNSUBSCRIBE)) 
				{
				 // TODO 取消订阅后用户再收不到公众号发送的消息,因此不需要回复消息
				} 
			
				 //自定义菜单点击事件响应 
				else if (eventType.equals(ConstantUtil.EVENT_TYPE_CLICK)) 
				{
				 // TODO 自定义菜单权没有开放,暂不处理该类消息
				}
			}
		
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
	
		return respMessage;
	}
	
}
  

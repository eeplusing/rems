package com.lixuan.rems.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lixuan.rems.model.Article;
import com.lixuan.rems.model.RespNewsMessage;
import com.lixuan.rems.model.RespTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**  
 * ClassName:MessageUtil   
 * Date:     2016年1月21日 下午4:31:31  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class MessageUtil 
{
	/**
	 * 解析微信发来的请求（XML）
	 * @param request
	 * @return Map
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
		{
			map.put(e.getName(), e.getText());
		}
		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	
	/**
	 * 基本消息对象转换成xml
	 * @param message 消息对象
	 * @return xml
	 */
	public static String messageToXml(Object message)
	{
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}
	
	/**
	 * 文本消息对象转换成xml
	 * @param textMessage 文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(RespTextMessage textMessage) 
	{
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 图文消息对象转换成xml
	 * @param newsMessage 图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(RespNewsMessage newsMessage) 
	{
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 */
	private static XStream xstream = new XStream(new XppDriver() 
	{
		public HierarchicalStreamWriter createWriter(Writer out) 
		{
			return new PrettyPrintWriter(out) 
			{
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;
				protected void writeText(QuickWriter writer, String text) 
				{
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} 
					else 
					{
						writer.write(text);
					}
				}
			};
		}
	});
	
	/**
	 * emoji表情转换(hex to utf-16)
	 * @param hexEmoji
	 * @return String
	 */
	public static String emoji(int hexEmoji) 
	{
		return String.valueOf(Character.toChars(hexEmoji));
	}

}
  

 
package com.lixuan.rems.model;  
/**  
 * ClassName:VoiceMessage   
 * Date:     2016年1月21日 上午9:49:02  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqVoiceMessage extends ReqBaseMessage 
{
	// 媒体ID
	private String MediaId;
	
	//语音格式
	private String Format;
	
	//识别
	private String Recognition;
	
	public String getMediaId() 
	{
		return MediaId;
	}
	public void setMediaId(String mediaId) 
	{
		MediaId = mediaId;
	}
	public String getFormat() 
	{
		return Format;
	}
	public void setFormat(String format) 
	{
		Format = format;
	}
	public String getRecognition() 
	{
		return Recognition;
	}
	public void setRecognition(String recognition) 
	{
		Recognition = recognition;
	}
}
  

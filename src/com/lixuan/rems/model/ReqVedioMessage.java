 
package com.lixuan.rems.model;  
/**  
 * ClassName:VedioMessage   
 * Date:     2016年1月21日 上午9:49:56  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqVedioMessage extends ReqBaseMessage 
{
	// 媒体ID
	private String MediaId;
		
	//语音格式
	private String ThumbMediaId;

	public String getMediaId() 
	{
		return MediaId;
	}

	public void setMediaId(String mediaId) 
	{
		MediaId = mediaId;
	}

	public String getThumbMediaId() 
	{
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) 
	{
		ThumbMediaId = thumbMediaId;
	}
}
  

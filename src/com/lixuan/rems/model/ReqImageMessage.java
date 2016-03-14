 
package com.lixuan.rems.model;  
/**  
 * ClassName:ImageMessage   
 * Date:     2016年1月21日 上午9:47:22  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqImageMessage extends ReqBaseMessage 
{
	private String PicUrl;
	
	private String MediaId;

	public String getPicUrl() 
	{
		return PicUrl;
	}

	public void setPicUrl(String picUrl) 
	{
		this.PicUrl = picUrl;
	}

	public String getMediaId() 
	{
		return MediaId;
	}

	public void setMediaId(String mediaId)
	{
		MediaId = mediaId;
	}
	
}
  

package com.lixuan.rems.model;

/**
 * 多媒体消息<br>
 * 图片消息、语音消息直接用此类
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class RespMediaMessage extends RespBaseMessage
{
	//通过上传多媒体文件，得到的id
	private String mediaId;

	public String getMediaId() 
	{
		return mediaId;
	}

	public void setMediaId(String mediaId) 
	{
		this.mediaId = mediaId;
	}

	public RespMediaMessage() 
	{
		super();
	}
	
}

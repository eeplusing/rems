 
package com.lixuan.rems.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**  
 * @ClassName:FileUpDownUtil   
 * @Date:     2016年1月24日 下午11:42:33  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      上传和下载网络上的文件 
 */
public class FileUpDownUtil 
{
	public static void downFiel(String fileUrl, String filename, String savePath) throws Exception
	{
		// 构造URL  
        URL url = new URL(fileUrl);  
        
        // 打开连接  
        URLConnection con = url.openConnection(); 
        
        //设置请求超时为5s  
        con.setConnectTimeout(5*1000);  
        
        // 输入流  
        InputStream is = con.getInputStream();  
      
        // 1K的数据缓冲  
        byte[] bs = new byte[1024]; 
        
        // 读取到的数据长度  
        int len;  
        
        // 输出的文件流  
       File sf=new File(savePath);  
       if(!sf.exists())
       {  
           sf.mkdirs();  
       }  
       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);  
        // 开始读取  
        while ((len = is.read(bs)) != -1) 
        {  
          os.write(bs, 0, len);  
        }  
        // 完毕，关闭所有链接  
        os.close();  
        is.close();  
	}
}
  

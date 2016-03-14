 
package com.lixuan.rems.action;  

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lixuan.rems.service.impl.CoreService;
import com.lixuan.rems.util.SignUtil;

/**  
* @ClassName:WeixinIOUtil   
* @Date:     2016年1月21日 下午10:03:40  
* @Author    CAOPENG  
* @Version   1.0 
* @Since     JDK 1.7  
* @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
* @Todo      该类是本应用与微信平台衔接的接口       
*/

@Controller
@RequestMapping("/weixinConnection")
public class WeixinIOController extends HttpServlet
{
	private static final long serialVersionUID = -7356158384123643554L;
	
	//注入coreService
	@Resource(name="coreService")
	private CoreService coreService;
	
	/**
	 *微信接入
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		System.out.println("==================invoke doGet() 验证签名====================");
		
		/*注意事项：首先设置中文字符集  ：utf-8  gbk  gb2312*/
		try
		{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();  
		}
		
		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = null;
		// 时间戳
		String timestamp = null;
		// 随机数
		String nonce = null;
		// 随机字符串
		String echostr = null;
		try 
		{
			signature = request.getParameter("signature");
			timestamp = request.getParameter("timestamp");
			nonce = request.getParameter("nonce");
			echostr = request.getParameter("echostr");
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();  
		}

		PrintWriter out = null;
		try 
		{
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) 
			{
				//返回微信平台信息
				out.print(echostr);
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			out.close();
			out = null;
		}
	}

	/**
	 * 核心业务：用户发的所有信息经微信平台进入该方法
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("===================invoke doPost() 进入核心业务=====================");
		
		/*注意事项：首先设置中文字符集  ：utf-8  gbk  gb2312*/
		try 
		{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		//调用核心业务类接收消息、处理消息
		String respMessage = coreService.processRequest(request);

		// 响应消息
		PrintWriter out = null;
		try 
		{
			out = response.getWriter();
			//返回微信平台信息
			out.print(respMessage);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			out.close();
			out = null;
		}
	}
}
 

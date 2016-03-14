﻿<%@ WebHandler Language="C#" Class="ZDproxy" Debug="true" %>


using System;
using System.Web;
using System.Net;
using System.IO;
using Microsoft.Win32;

public class ZDproxy : IHttpHandler
{
    
    public void ProcessRequest (HttpContext context) 
    {
        Stream outStream = null;
        HttpWebRequest myHttpWebRequest = null;
        HttpWebResponse myHttpWebResponse = null;
        try
        {
            string url = Convert.ToString(context.Request.QueryString["url"]);
            myHttpWebRequest = (HttpWebRequest)WebRequest.Create(url);
            myHttpWebRequest.Method = context.Request.HttpMethod;
            WebProxy myProxy = new WebProxy();
            if (context.Request.HttpMethod == "POST")
            {
                myHttpWebRequest.ContentType = "text/plain; charset=utf-8";
                System.IO.Stream requestStream = context.Request.InputStream;
                byte[] requestByts=new byte[requestStream.Length];
                requestStream.Read(requestByts, 0, Convert.ToInt32(requestStream.Length));
                System.IO.Stream myRequestStream = myHttpWebRequest.GetRequestStream();
                myRequestStream.Write(requestByts, 0, Convert.ToInt32(requestStream.Length));
                myRequestStream.Close();
            }
            myHttpWebResponse = (HttpWebResponse)myHttpWebRequest.GetResponse();
            outStream = myHttpWebResponse.GetResponseStream();
            StreamReader sr = new StreamReader(outStream);
            context.Response.Write(sr.ReadToEnd());
        }
        catch (Exception ex)
        {
            myHttpWebRequest.ContentType="text/xml";
            context.Response.Write("请求失败："+ex.Message);
        }
        finally
        {
            if (outStream != null)
                outStream.Close();
            if (myHttpWebResponse != null)
                myHttpWebResponse.Close();
        }
    }
    
    public bool IsReusable {
        get {
            return false;
        }
    }

}
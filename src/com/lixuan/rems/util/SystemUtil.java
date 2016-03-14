package com.lixuan.rems.util;

import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 * @Title        : SystemUtil.java
 * @Description : 
 * @Author       : BianWeiqing
 * @DateTime     : 2015年12月23日 下午1:54:42
 * @Copyright    : 2015 Moutum All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SystemUtil
{
    /* 
     * 将map对象转化为json格式字符串
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, String> map)
    {
        StringBuffer json = new StringBuffer("{");
        int index = 0;
        for(String key : map.keySet())
        {
            if(index > 0)
            {
                json.append(",");
            }
            
            json.append("'" + key + "':'" + map.get(key) + "'");
            
            index++;
        }
        json.append("}");
        return json.toString();
    }
    
    /*
     * 将json格式字符串转化为map对象
     * @param json
     * @return
     */
    public static Map<String, String> jsonToMap(String json)
    {
        Map<String, String> map = new HashMap<String, String>();
        json = json.replace("'", "").replace("{", "").replace("}", "");
        String[] infos = json.split(",");
        for(String str : infos)
        {
            String[] info = str.split(":");
            if(info.length < 2)
            {
                map.put(info[0], "");
            }
            else if(info.length > 2)
            {
                String key = info[0];
                String value = "";
                for(int i = 1; i<info.length; i++)
                {
                    if(i == info.length - 1)
                    {
                        value += info[i];
                    }
                    else
                    {
                        value += info[i] + ":";
                    }
                }
                map.put(key, value);
            }
            else
            {
                map.put(info[0], info[1]);
            }
        }
        return map;
    }
    
    public static void main(String[] args)
    {
        Map<String, String> map = jsonToMap("{'2':'LQ-630K','3':'1549.00','4':'灰色','8':'宽×深×高 386mm×306mm×185mm','48':'2015-10-08 9:30','51':'LQ-630K型打印机专用碳带X1','44':'4','25':'','50':'2','52':'','11':'','49':''}");
        for(String key : map.keySet())
        {
            System.out.println(key + ":" + map.get(key));
        }
        
    }
}


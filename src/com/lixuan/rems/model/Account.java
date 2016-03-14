package com.lixuan.rems.model;


/**  
 * @ClassName:Account   
 * @Date:     2016年1月21日 上午11:05:20  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class Account
{
    //账号ID
    private long accountId;
    
    //登录账号
    private String accountNo;
    
    //登录密码
    private String accountPass;

    public long getAccountId()
    {
        return accountId;
    }

    public void setAccountId(long accountId)
    {
        this.accountId = accountId;
    }

    public String getAccountNo()
    {
        return accountNo;
    }

    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

    public String getAccountPass()
    {
        return accountPass;
    }

    public void setAccountPass(String accountPass)
    {
        this.accountPass = accountPass;
    }
}

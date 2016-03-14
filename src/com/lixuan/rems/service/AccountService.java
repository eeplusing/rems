package com.lixuan.rems.service;


import com.lixuan.rems.model.Account;


/************************************************************************************
 * @Title        : AccountService.java
 * @Description : 
 * @Author       : ZhaoShasha
 * @DateTime     : 2015年12月9日 上午10:00:01
 * @Copyright    : 2015 Moutum All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public interface AccountService extends BaseService<Account>
{
    /*账户是否存在*/
    //public boolean isRegisted(String accountNo);
   
    /*账户与密码是否匹配*/
    //public boolean isRegisted(String accountNo, String accountPass);
    
    /*按账号查询账户*/
   // public Account getAccount(String accountNo);

    /*分页查询账户*/
   // public List<Account> getEmployeeListByPage(int offset, int count, String empName);

    /*将角色为roleId的账户的角色置为空*/
   // public void clearRole(Long roleId);

}


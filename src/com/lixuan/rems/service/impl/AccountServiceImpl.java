package com.lixuan.rems.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixuan.rems.model.Account;
import com.lixuan.rems.service.AccountService;


/************************************************************************************
 * @Title        : AccountServiceImpl.java
 * @Description : 
 * @Author       : CaoPeng
 * @DateTime     : 2015年12月9日 上午10:02:03
 * @Copyright    : 2015 lixaun All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
@Service @Transactional // @EnableTransactionManagement
public class AccountServiceImpl extends BaseSupportImpl<Account> implements AccountService
{
    /**
    @Override
    public boolean isRegisted(String accountNo)
    {
        String hql = "FROM Account a WHERE a.accountNo = ?";
        List<Account> list = accountDao.findEntityByHql(hql, accountNo);
        return ValidateUtil.isValid(list);
    }
    
	@Override
	public boolean isRegisted(String accountNo, String accountPass)
	{
	    String hql = "FROM Account a WHERE a.accountNo = ? AND a.accountPass = ?";
        List<Account> list = accountDao.findEntityByHql(hql, accountNo, DataUtil.md5(accountPass));
		return ValidateUtil.isValid(list);
	}
    @Override
    public Account getAccount(String accountNo)
    {
        String hql = "FROM Account a WHERE a.accountNo = ?";
        List<Account> list = accountDao.findEntityByHql(hql, accountNo);
        return list.get(0);
    }
    @Override
    public List<Account> getEmployeeListByPage(int offset, int count, String empName)
    {
        return accountDao.getEmployeeListByPage(offset, count, empName);
    }
    
    将角色为roleId的账户的角色置为空
    @Override
    public void clearRole(Long roleId)
    {
        String hql = "UPDATE Account a SET a.role = null WHERE a.role.roleId = ?";
        accountDao.batchEntityByHql(hql, roleId);
    }*/

   

}


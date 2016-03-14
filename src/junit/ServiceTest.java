package junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixuan.rems.model.Account;
import com.lixuan.rems.service.AccountService;

/********************************************************************************
 * @Title        : ServiceTest.java
 * @Description : 
 * @Author       : CaoPeng
 * @DateTime     : 2016年1月20日 下午7:22:45
 * @Copyright    : 2016 lixuan All Rights Reserved
 * @version      : V1.0
 ********************************************************************************/
public class ServiceTest
{
    
    static ApplicationContext act = null;
    static AccountService accountService = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        act = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = (AccountService)act.getBean("accountServiceImpl");
    }
    
    
    @Test 
    public void test()
    {
    	/*Account a = accountService.getById(2L);
    	a.setAccountNo("admin2");
    	a.setAccountPass("admin2");
    	accountService.saveOrUpdate(a);
    	a =  accountService.getById(2L);*/
    	Account a = new Account();
    	a.setAccountNo("admin");
    	a.setAccountPass("admin");
    	System.out.println(a.getAccountNo() + ":" + a.getAccountPass());
    	accountService.save(a);
    	a = accountService.getById(1L);
    	a.setAccountNo("admin2");
    	a.setAccountPass("admin2");
    	accountService.update(a);
    	a = accountService.getById(1L);
    	System.out.println(a.getAccountNo() + ":" + a.getAccountPass());
    	
        System.out.println("测试成功");
    }
    
}
package com.lixuan.rems.model;

/**
 * 自定义菜单
 * @ClassName:Menu   
 * @Date:     2016年1月21日 上午11:05:20  
 * @author    CAOPENG  
 * @version   1.0 
 * @since     JDK 1.7  
 * @right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class Menu 
{
	
	//菜单按钮
	private Button[] button;

	public Button[] getButton() 
	{
		return button;
	}

	public void setButton(Button[] button) 
	{
		this.button = button;
	}

	public Menu(Button[] button) 
	{
		super();
		this.button = button;
	}

	public Menu() 
	{
		super();
	}  
}
